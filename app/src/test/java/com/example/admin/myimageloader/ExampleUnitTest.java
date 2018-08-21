package com.example.admin.myimageloader;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        String rawUrl = "https://www.baidu.com/img/superlogo_c4d7df0a003d3db9b65e9ef0fe6da1ec.png?where=super~";
        int startIndex = rawUrl.lastIndexOf("/");
        int endIndex = rawUrl.lastIndexOf(".");
        String substring=rawUrl.substring(startIndex,endIndex);

    }
}