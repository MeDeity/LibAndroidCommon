package com.deity.common;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 日志工具栏
 * Create by fengwenhua at 2018/5/18
 **/
public class LoggerUtils {

    /**
     * 功能说明:打印异常堆栈
     * @param throwable 异常错误栈
     * @return 异常错误栈信息
     */
    public static String logExceptionStack(Throwable throwable) {
        StringWriter errorsWriter = new StringWriter();
        throwable.printStackTrace(new PrintWriter(errorsWriter));
        return errorsWriter.toString();
    }
}
