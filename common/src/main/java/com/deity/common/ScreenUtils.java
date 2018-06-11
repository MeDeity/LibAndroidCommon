package com.deity.common;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;

import java.lang.reflect.Method;

/**
 * 屏幕操作相关方法
 * Create by fengwenhua at 2018/5/18
 **/
public class ScreenUtils {

    private static final String TAG = ScreenUtils.class.getSimpleName();


    private ScreenUtils(){
        throw new AssertionError();
    }

    /**
     * 获取屏幕尺寸，但是不包括虚拟键功能高度
     * @return 屏幕尺寸高度
     */
    public int getNoHasVirtualKey(Activity context) {
        return context.getWindowManager().getDefaultDisplay().getHeight();
    }

    /**
     * 通过反射，获取包含虚拟键的整体屏幕高度
     * @return 含虚拟键的屏幕高度
     */
    @SuppressWarnings("unchecked")
    private int getHasVirtualKey(Activity context) {
        int dpi = 0;
        Display display = context.getWindowManager().getDefaultDisplay();
        DisplayMetrics dm = new DisplayMetrics();
        Class className;
        try {
            className = Class.forName("android.view.Display");
            Method method = className.getMethod("getRealMetrics", DisplayMetrics.class);
            method.invoke(display, dm);
            dpi = dm.heightPixels;
        } catch (Exception e) {
            Log.e(TAG,LoggerUtils.logExceptionStack(e));
        }
        return dpi;
    }
}

