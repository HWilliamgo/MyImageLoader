package com.example.admin.myimageloader.ImageLoader;

import android.graphics.Bitmap;

/**
 * Created by 黄伟杰 on 2018/8/14.
 */
public interface ICache {
    Bitmap get(String url);

    void put(String url, Bitmap bitmap);
}
