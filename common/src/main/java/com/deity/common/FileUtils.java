package com.deity.common;

import android.graphics.Bitmap;
import android.util.Log;

import com.deity.common.callback.ErrorCallback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件工具类
 */
public class FileUtils {

    private static final String TAG = FileUtils.class.getSimpleName();
    /**
     * 保存Bitmap 到图片
     * @param bitmap       图片
     * @param savePath     待保存的文件路径
     * @param saveFileName 待保存的文件名称
     * @return             保存的文件
     */
    public static File saveBitmapToFile(Bitmap bitmap, String savePath, String saveFileName, ErrorCallback errorCallback) {
        File dir = new File(savePath);
        if (!dir.exists()) {
            dir.mkdirs();// 创建文件夹
        }
        File saveFile = new File(savePath + saveFileName);
        if (saveFile.exists()) {
            saveFile.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(saveFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            Log.e(TAG,"saveBitmapToFile IOException>>>", e);
            errorCallback.handleException(e);
        }
        return saveFile;
    }
}
