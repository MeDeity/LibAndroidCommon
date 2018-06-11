package com.deity.common;

import android.util.Log;

import java.util.Arrays;

/**
 * 进制转换工具类
 * 1.为什么有字节序(一直高位在前低位在后不是很好嘛)
 * Create by fengwenhua at 2018/6/11
 **/
@SuppressWarnings("unused")
public class NumConvertUtils {
    private static final String TAG = NumConvertUtils.class.getSimpleName();

    /**
     * 整型转byte数组(高位在前,低位在后)
     * 字节顺序：高位优先(big-endian)
     * @param arrayLength 需要转换的byte数组长度
     * @param value       整型数值
     * @return            byte数组
     */
    public static byte[] int2ByteArrayBigEndian(int arrayLength,int value){
        byte[] result = new byte[arrayLength];
        for (int i=0;i<arrayLength;i++){
            result[arrayLength-i-1] = (byte) (value>>i*8&0xFF);
        }
        Log.d(TAG,"int2ByteArrayBigEndian(arrayLength:"+arrayLength+",value:"+value+") result:"+ Arrays.toString(result));
        return result;
    }


    /**
     * 整型转byte数组(低位在后,高位在前)
     * 低位优先(little-endian)
     * @param arrayLength 需要转换的byte数组长度
     * @param value       整型数值
     * @return            byte数组
     */
    public static byte[] int2ByteArrayLittleEndian(int arrayLength,int value){
        byte[] result = new byte[arrayLength];
        for (int i=0;i<arrayLength;i++){
            result[i] = (byte) (value>>i*8&0xFF);
        }
        Log.d(TAG,"int2ByteArrayLittleEndian(arrayLength:"+arrayLength+",value:"+value+") result:"+ Arrays.toString(result));
        return result;
    }

}
