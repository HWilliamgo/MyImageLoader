package com.example.admin.myimageloader.ImageLoader;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by 黄伟杰 on 2018/8/14.
 */
public class MemoryCache implements ICache {

    private LruCache<String, Bitmap> cache;

    public MemoryCache() {
        initCache();
    }

    private void initCache() {
        int maxMemory = (int) Runtime.getRuntime().maxMemory() / 1024;
        int maxSize = maxMemory / 4;

        cache = new LruCache<String, Bitmap>(maxSize) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap) {
        cache.put(url, bitmap);
    }

    public Bitmap get(String url) {
        return cache.get(url);
    }


}
