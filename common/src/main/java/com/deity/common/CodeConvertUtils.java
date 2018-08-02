package com.deity.common;

import android.text.TextUtils;
import android.util.Log;

import java.io.UnsupportedEncodingException;

/**
 * 编码转换
 * Create by fengwenhua at 2018/7/26
 **/
@SuppressWarnings("unused")
public class CodeConvertUtils {
    private static final String TAG = CodeConvertUtils.class.getSimpleName();

    /**
     * convert from Unicode to charset
     * @param content unicode编码的内容
     * @param charset 字符串编码
     * @return  特定编码的字符串,空字符串返回NULL
     */
    public static String unicode2CharsetStr(String content, String charset) {
        String result = null;
        if (!TextUtils.isEmpty(content)) {
            try {
                byte[] contentBytes = content.getBytes(charset);
                result = new String(contentBytes, charset);
            } catch (UnsupportedEncodingException e) {
                Log.e(TAG,"convert from Unicode to "+charset+" failure:"+LoggerUtils.logExceptionStack(e));
                throw new UnsupportedOperationException("convert from Unicode to "+charset+" failure:"+LoggerUtils.logExceptionStack(e));

            }
        }
        return result;
    }
}
