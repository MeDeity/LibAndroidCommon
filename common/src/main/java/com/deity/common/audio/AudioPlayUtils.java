package com.deity.common.audio;

import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.util.Log;

import java.io.IOException;

/**
 * 音频文件播放工具类
 * Create by fengwenhua at 2018/6/25
 **/
public class AudioPlayUtils implements MediaPlayer.OnCompletionListener,MediaPlayer.OnErrorListener{

    private static final String TAG = AudioPlayUtils.class.getSimpleName()+">>>";

    private MediaPlayer mPlayer;

    public static AudioPlayUtils audioPlayUtils;

    private AudioPlayUtils(){}

    /**获取实例*/
    public static AudioPlayUtils getInstance(){
        if (null==audioPlayUtils){
            synchronized (AudioPlayUtils.class){
                if (null== audioPlayUtils){
                    audioPlayUtils = new AudioPlayUtils();
                }
            }
        }
        return audioPlayUtils;
    }


    public boolean audioPlay(@NonNull final AudioConfig config, MediaPlayer.OnCompletionListener onCompletionListener, MediaPlayer.OnErrorListener onErrorListener){
        if (!config.isArgumentValid()) {
            return false;
        }
        try{
            MediaPlayer player = create(config);
            setMediaPlayerListener(player, onCompletionListener, onErrorListener);
//            player.setVolume(config.mLeftVolume, config.mRightVolume);
//            player.setAudioStreamType(config.mStreamType);
            player.setLooping(config.isLooping());
            if (config.needPrepare()) {
                player.prepare();
            }
            player.start();

            mPlayer = player;
            return true;
        }catch (Exception e){
            Log.e(TAG,"audio play exception:",e);
            return false;
        }

    }


    private void setMediaPlayerListener(final MediaPlayer player,
                                        final MediaPlayer.OnCompletionListener onCompletionListener,
                                        final MediaPlayer.OnErrorListener onErrorListener) {
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.d(TAG, "OnCompletionListener::onCompletion");
                stopPlay();
                onCompletionListener.onCompletion(mp);
            }
        });
        player.setOnErrorListener(new MediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(MediaPlayer mp, int what, int extra) {
                Log.d(TAG, "OnErrorListener::onError" + what + ", " + extra);
                onErrorListener.onError(mp,what,extra);
                stopPlay();
                return true;
            }
        });
    }

    private MediaPlayer create(final AudioConfig config) throws IOException {
        stopPlay();

        MediaPlayer player;
        switch (config.getAudioResType()) {
            case AudioType.TYPE_URI:
                Log.d(TAG, "MediaPlayer to start play uri: " + config.getAudioUri());
                player = new MediaPlayer();
                player.setDataSource(config.getContext(), config.getAudioUri());
                return player;
            case AudioType.TYPE_FILE:
                Log.d(TAG, "MediaPlayer to start play file: " + config.getAudioFile().getName());
                player = new MediaPlayer();
                player.setDataSource(config.getAudioFile().getAbsolutePath());
                return player;
            case AudioType.TYPE_RES:
                Log.d(TAG, "MediaPlayer to start play: " + config.getLocalAudioRes());
                player = MediaPlayer.create(config.getContext(), config.getLocalAudioRes());
                return player;
            case AudioType.TYPE_URL:
                Log.d(TAG, "MediaPlayer to start play: " + config.getAudioUrl());
                player = new MediaPlayer();
                player.setDataSource(config.getAudioUrl());
                return player;
            default:
                throw new IllegalArgumentException("Unknown type: " + config.getAudioResType());
        }
    }

    /**
     * 关闭并释放MediaPlayer
     * @return 关闭释放成功
     */
    public synchronized boolean stopPlay() {
        if (mPlayer == null) {
            return false;
        }

        mPlayer.setOnCompletionListener(null);
        mPlayer.setOnErrorListener(null);
        try {
            mPlayer.stop();
            mPlayer.reset();
            mPlayer.release();
        } catch (IllegalStateException e) {
            Log.w(TAG, "stopPlay fail, IllegalStateException: " + e.getMessage());
        }finally {
            mPlayer = null;
        }
        return true;
    }

    /**
     * Called when the end of a media source is reached during playback.
     *
     * @param mp the MediaPlayer that reached the end of the file
     */
    @Override
    public void onCompletion(MediaPlayer mp) {
        Log.d(TAG,"a media source is reached during playback(onCompletion)");
    }

    /**
     * Called to indicate an error.
     * @return True if the method handled the error, false if it didn't.
     * Returning false, or not having an OnErrorListener at all, will
     * cause the OnCompletionListener to be called.
     */
    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        Log.d(TAG,"indicate an error,what:"+what+" extra:"+extra);
        return false;
    }
}
