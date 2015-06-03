package com.retechcorp.android.epub.bean;

/**
 * Created by mx on 14/12/17.
 * 书签
 */
public class BookMark_Epub {
    //书签id
    private String bookmarkid;
    //章节索引
    private String chapter_index;
    //章节名称
    private String chapter_name;
    //坐标
    private String position;
    //摘要内容
    private String summary_content;
    //添加时间
    private String add_time;

    public BookMark_Epub() {
    }

    public BookMark_Epub(String bookmarkid, String chapter_index, String chapter_name, String position, String summary_content, String add_time) {
        this.bookmarkid = bookmarkid;
        this.chapter_index = chapter_index;
        this.chapter_name = chapter_name;
        this.position = position;
        this.summary_content = summary_content;
        this.add_time = add_time;
    }

    public String getBookmarkid() {
        return bookmarkid;
    }

    public void setBookmarkid(String bookmarkid) {
        this.bookmarkid = bookmarkid;
    }

    public String getChapter_index() {
        return chapter_index;
    }

    public void setChapter_index(String chapter_index) {
        this.chapter_index = chapter_index;
    }

    public String getChapter_name() {
        return chapter_name;
    }

    public void setChapter_name(String chapter_name) {
        this.chapter_name = chapter_name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSummary_content() {
        return summary_content;
    }

    public void setSummary_content(String summary_content) {
        this.summary_content = summary_content;
    }

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }
}
