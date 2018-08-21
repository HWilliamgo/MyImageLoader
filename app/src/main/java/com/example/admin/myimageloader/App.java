package com.example.admin.myimageloader;

import android.app.Application;

/**
 * Created by 黄伟杰 on 2018/8/14.
 */
public class App extends Application {
    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Application getInstance() {
        return instance;
    }
}
