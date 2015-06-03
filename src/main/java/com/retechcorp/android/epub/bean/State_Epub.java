package com.retechcorp.android.epub.bean;

/**
 * Created by Shaw on 15/5/12.
 * 书籍状态
 */
public class State_Epub {

    private String font;
    private int font_size;
    private int day_night;
    private int pages;

    public State_Epub() {

    }

    public State_Epub(String font, int font_size, int day_night, int pages) {

    }

    public String getFont() {
        return font;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public int getFont_size() {
        return font_size;
    }

    public void setFont_size(int font_size) {
        this.font_size = font_size;
    }

    public int getDay_night() {
        return day_night;
    }

    public void setDay_night(int day_night) {
        this.day_night = day_night;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}
