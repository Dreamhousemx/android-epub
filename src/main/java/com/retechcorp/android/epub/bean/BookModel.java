package com.retechcorp.android.epub.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mx on 14/12/17.
 * 书籍基础信息
 */
public class BookModel {

    //书籍id
    private String bookid;
    //阅读进度
    private Readprogress_Epub readprogress;
    // 图书基础信息集合
    private Map<String, String> metadataMap;
    // 图书目录信息
    private List<Directory_Epub> directoryMap;
    //书签集合
    private List<BookMark_Epub> bookmarkList;
    //书摘集合
    private List<Note_Epub> notelist;

    public BookModel() {
        metadataMap = new HashMap<>();
        directoryMap = new ArrayList<>();
        bookmarkList = new ArrayList<>();
        notelist = new ArrayList<>();
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public Readprogress_Epub getReadprogress() {
        return readprogress;
    }

    public void setReadprogress(Readprogress_Epub readprogress) {
        this.readprogress = readprogress;
    }

    public Map<String, String> getMetadataMap() {
        return metadataMap;
    }

    public List<Directory_Epub> getDirectoryMap() {
        return directoryMap;
    }

    public List<BookMark_Epub> getBookmarkList() {
        return bookmarkList;
    }

    public List<Note_Epub> getNotelist() {
        return notelist;
    }
}
