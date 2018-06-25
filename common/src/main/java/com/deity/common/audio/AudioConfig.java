package com.deity.common.audio;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import java.io.File;

/**
 * 待播放的音频配置
 * Create by fengwenhua at 2018/6/25
 **/
public class AudioConfig {

    /**资源类型*/
    @AudioType.AudioResType
    private int audioResType;

    private Context context;

    /**本地资源*/
    private int localAudioRes;

    /**音频资源*/
    private File audioFile;

    /**音频url地址*/
    private String audioUrl;

    /**音频uri地址*/
    private Uri audioUri;

    /**是否循环播放*/
    private boolean isLooping;


    public AudioConfig(Builder builder){
        audioResType = builder.audioResType;
        context = builder.context;
        localAudioRes = builder.localAudioRes;
        audioFile = builder.audioFile;
        audioUrl = builder.audioUrl;
        audioUri = builder.audioUri;
    }

    /**检测资源合法性*/
    boolean isArgumentValid() {
        switch (audioResType) {
            case AudioType.TYPE_FILE:
                return audioFile != null && audioFile.exists();
            case AudioType.TYPE_RES:
                return localAudioRes > 0 && context != null;
            case AudioType.TYPE_URL:
                return !TextUtils.isEmpty(audioUrl);
            case AudioType.TYPE_URI:
                return audioUri != null;
            default:
                return false;
        }
    }


    /**是否需要加载*/
    boolean needPrepare() {
        switch (audioResType) {
            case AudioType.TYPE_FILE:
            case AudioType.TYPE_URL:
            case AudioType.TYPE_URI:
                return true;
            case AudioType.TYPE_RES:
            default:
                return false;
        }
    }

    public int getAudioResType() {
        return audioResType;
    }

    public Context getContext() {
        return context;
    }

    public int getLocalAudioRes() {
        return localAudioRes;
    }

    public File getAudioFile() {
        return audioFile;
    }

    public String getAudioUrl() {
        return audioUrl;
    }

    public Uri getAudioUri() {
        return audioUri;
    }

    public boolean isLooping() {
        return isLooping;
    }

    public static class Builder{
        /**资源类型*/
        @AudioType.AudioResType
        private int audioResType;

        /**上下文*/
        private Context context;

        /**本地资源*/
        private int localAudioRes;

        /**音频资源*/
        private File audioFile;

        /**音频url地址*/
        private String audioUrl;

        /**音频uri地址*/
        private Uri audioUri;

        /**是否循环播放*/
        private boolean isLooping;

        public Builder(Context context){
            this.context = context;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setLocalAudioRes(int localAudioRes) {
            this.localAudioRes = localAudioRes;
            return this;
        }

        public Builder setAudioFile(File audioFile) {
            this.audioFile = audioFile;
            return this;
        }

        public Builder setAudioUrl(String audioUrl) {
            this.audioUrl = audioUrl;
            return this;
        }

        public Builder setAudioUri(Uri audioUri) {
            this.audioUri = audioUri;
            return this;
        }

        public Builder setAudioResType(int audioResType) {
            this.audioResType = audioResType;
            return this;
        }

        public Builder setLooping(boolean looping) {
            isLooping = looping;
            return this;
        }

        public AudioConfig create(){
            return new AudioConfig(this);
        }


    }
}
