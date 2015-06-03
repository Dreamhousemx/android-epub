package com.retechcorp.android.epub.bean;

import android.graphics.Bitmap;

/**
 * Created by Meng on 15/4/3.
 * 书籍显示的资源文件图片
 */
public class Resources_Epub {

    private Bitmap bitmap;
    private String type;
    private String url;
    private int bitmapStartX;
    private int bitmapStartY;
    private int showX;

    public Resources_Epub() {
    }

    public Resources_Epub(Bitmap bitmap, String type, String url, int bitmapStartX, int bitmapStartY, int showX) {
        this.bitmap = bitmap;
        this.type = type;
        this.url = url;
        this.bitmapStartX = bitmapStartX;
        this.bitmapStartY = bitmapStartY;
        this.showX = showX;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getBitmapStartX() {
        return bitmapStartX;
    }

    public void setBitmapStartX(int bitmapStartX) {
        this.bitmapStartX = bitmapStartX;
    }

    public int getBitmapStartY() {
        return bitmapStartY;
    }

    public void setBitmapStartY(int bitmapStartY) {
        this.bitmapStartY = bitmapStartY;
    }

    public int getShowX() {
        return showX;
    }

    public void setShowX(int showX) {
        this.showX = showX;
    }
}
