package com.retechcorp.android.epub.bean;

/**
 * Created by Shaw on 15/5/8.
 */
public class Experience_Epub {

    private String bookid;
    // 开始阅读时间 / 读完时间
    private String time;
    // 单位：秒，如果为空，则表示此本书读完
    private String duration;

    public Experience_Epub() {
    }

    public Experience_Epub(String bookid, String time, String duration) {
        this.bookid = bookid;
        this.time = time;
        this.duration = duration;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
