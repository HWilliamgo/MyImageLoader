package com.example.admin.myimageloader.ImageLoader;

import android.graphics.Bitmap;

/**
 * Created by 黄伟杰 on 2018/8/14.
 */
public class DoubleCache implements ICache {
    private ICache diskCache;
    private ICache memCache;

    public DoubleCache() {
        diskCache = new DiskCache();
        memCache = new MemoryCache();
    }

    public Bitmap get(String url) {
        Bitmap bitmap = memCache.get(url);
        if (bitmap == null) {
            bitmap = diskCache.get(url);
        }
        return bitmap;
    }

    public void put(String url, Bitmap bitmap) {
        memCache.put(url, bitmap);
        diskCache.put(url, bitmap);
    }
}
