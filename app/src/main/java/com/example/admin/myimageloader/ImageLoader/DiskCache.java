package com.example.admin.myimageloader.ImageLoader;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.admin.myimageloader.App;
import com.example.admin.myimageloader.Util.CloseUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


/**
 * Created by 黄伟杰 on 2018/8/14.
 */
public class DiskCache implements ICache {

    private static final String CACHE_DIR = App.getInstance().getCacheDir().getAbsolutePath()+"/";

    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(CACHE_DIR + handleUrl(url));

    }

    public void put(String url, Bitmap bitmap) {
        try {
            FileOutputStream fos = new FileOutputStream(CACHE_DIR + handleUrl(url));
            boolean success=bitmap.compress(Bitmap.CompressFormat.PNG, 100, fos);
            CloseUtils.closeQuietly(fos);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private String handleUrl(String rawUrl){
        int startIndex=rawUrl.lastIndexOf("/");
        int endIndex=rawUrl.lastIndexOf(".");
        return rawUrl.substring(startIndex+1,endIndex)+".png";
    }
}
