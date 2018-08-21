package com.example.admin.myimageloader.Util;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by 黄伟杰 on 2018/8/16.
 */
public final class CloseUtils {
    public static void closeQuietly(Closeable closeable){
        if (null!=closeable){
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
