package com.retechcorp.android.epub.bean;

import java.io.Serializable;

/**
 * Created by mx on 15/1/17.
 * 笔记
 */
public class Note_Epub implements Serializable {

    //笔记内容
    private String note_content;
    //章节索引
    private String chapter_index;
    //摘要内容
    private String summary_content;
    //章节名称
    private String chapter_name;
    //坐标
    private String position;
    //添加时间
    private String add_time;
    //坐标偏移量
    private String position_offset;
    //下划线颜色
    private String summary_underline_color;
    // 阅读进度
    private String process;
    //笔记ID
    private String noteID;

    public Note_Epub() {
    }

    public Note_Epub(String note_content, String chapter_index, String summary_content, String chapter_name, String position,
                     String add_time, String position_offset, String summary_underline_color, String process, String noteID) {
        this.note_content = note_content;
        this.chapter_index = chapter_index;
        this.summary_content = summary_content;
        this.chapter_name = chapter_name;
        this.position = position;
        this.add_time = add_time;
        this.position_offset = position_offset;
        this.summary_underline_color = summary_underline_color;
        this.process = process;
        this.noteID = noteID;
    }

    public String getNote_content() {
        return note_content;
    }

    public void setNote_content(String note_content) {
        this.note_content = note_content;
    }

    public String getChapter_index() {
        return chapter_index;
    }

    public void setChapter_index(String chapter_index) {
        this.chapter_index = chapter_index;
    }

    public String getSummary_content() {
        return summary_content;
    }

    public void setSummary_content(String summary_content) {
        this.summary_content = summary_content;
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

    public String getAdd_time() {
        return add_time;
    }

    public void setAdd_time(String add_time) {
        this.add_time = add_time;
    }

    public String getPosition_offset() {
        return position_offset;
    }

    public void setPosition_offset(String position_offset) {
        this.position_offset = position_offset;
    }

    public String getSummary_underline_color() {
        return summary_underline_color;
    }

    public void setSummary_underline_color(String summary_underline_color) {
        this.summary_underline_color = summary_underline_color;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }

    public String getNoteID() {
        return noteID;
    }

    public void setNoteID(String noteID) {
        this.noteID = noteID;
    }
}
