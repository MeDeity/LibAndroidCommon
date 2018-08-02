package com.deity.common;

import org.junit.Test;


/**
 * 这里添加文件描述
 * Create by fengwenhua at 2018/7/26
 **/
public class CodeConvertUtilsTest {

    @Test
    public void unicode2Str() {
        print(CodeConvertUtils.unicode2CharsetStr("123","utf-8"));
    }

    private void print(String message){
        System.out.println(message);
    }
}