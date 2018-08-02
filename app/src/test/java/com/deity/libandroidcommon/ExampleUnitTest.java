package com.deity.libandroidcommon;

import com.deity.common.CodeConvertUtils;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void unicode2Str() {
        print(CodeConvertUtils.unicode2CharsetStr("123","utf-8"));
    }

    private void print(String message){
        System.out.println(message);
    }
}