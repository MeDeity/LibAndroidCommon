package com.deity.common.audio;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 音频类型
 * Create by fengwenhua at 2018/6/25
 **/
public class AudioType {
    /**文件类型*/
    public static final int TYPE_FILE = 1;
    /**本地资源类型*/
    public static final int TYPE_RES = 2;
    /**url*/
    public static final int TYPE_URL = 3;
    /**uri*/
    public static final int TYPE_URI = 4;


    @SuppressWarnings("unused")
    @IntDef({TYPE_FILE,TYPE_RES,TYPE_URL,TYPE_URI})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AudioResType{}
}
