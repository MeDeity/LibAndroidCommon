package com.deity.common;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * 这里添加文件描述
 * Create by fengwenhua at 2018/5/18
 **/
public class LoggerUtilsTest {

    @Test
    public void logExceptionStack() {
        System.out.println(LoggerUtils.logExceptionStack(new Exception("测试打印异常堆栈")));
    }
}