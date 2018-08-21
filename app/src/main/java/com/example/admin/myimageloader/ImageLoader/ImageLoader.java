package com.example.admin.myimageloader.ImageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.widget.ImageView;

import java.io.IOException;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by 黄伟杰 on 2018/8/14.
 */
public class ImageLoader {

    private ICache mCache = new DoubleCache();

    private ExecutorService mService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public void displayImage(final String url, final ImageView v) {
        v.setTag(url);

        mService.submit(new Runnable() {
            @Override
            public void run() {
                final Bitmap bitmap = getImage(url);
                if (bitmap == null) {
                    return;
                }
                v.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!v.getTag().equals(url)) {
                            //防止ImageView复用产生的图片错乱问题。
                            return;
                        }
                        v.setImageBitmap(bitmap);
                    }
                });
            }
        });
    }

    //依赖注入
    public void setCache(ICache cache) {
        this.mCache = cache;
    }

    private Bitmap getImage(String url) {
        Bitmap bitmap;
        bitmap = mCache.get(url);

        if (bitmap != null) {
            return bitmap;
        }

        try {
            URL u = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) u.openConnection();
            bitmap = BitmapFactory.decodeStream(connection.getInputStream());
            mCache.put(url, bitmap);
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
}
