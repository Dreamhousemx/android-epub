package com.retechcorp.android.epub.bean;

/**
 * Created by mx on 15/2/11.
 * 阅读进度
 */
public class Readprogress_Epub {

    //章节索引
    private String chapter_index;
    //坐标
    private String position;
    //阅读进度
    private String progress;
    //最近阅读时间
    private String update_time;

    public Readprogress_Epub() {
    }

    public Readprogress_Epub(String chapter_index, String position, String progress, String update_time) {
        this.chapter_index = chapter_index;
        this.position = position;
        this.progress = progress;
        this.update_time = update_time;
    }

    public String getChapter_index() {
        return chapter_index;
    }

    public void setChapter_index(String chapter_index) {
        this.chapter_index = chapter_index;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
