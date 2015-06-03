package com.retechcorp.android.epub.bean;

/**
 * Created by mx on 14/12/17.
 * 目录
 */
public class Directory_Epub {

    //章节名称
    private String directoryName;
    //章节地址
    private String directoryPath;
    //章节内容
    private String htmlString;
    //章节起始页
    private int directoryStartPage;

    public Directory_Epub() {
    }

    public Directory_Epub(String directoryName, String directoryPath, int directoryStartPage) {
        this.directoryName = directoryName;
        this.directoryPath = directoryPath;
        this.directoryStartPage = directoryStartPage;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public String getDirectoryPath() {
        return directoryPath;
    }

    public void setDirectoryPath(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public String getHtmlString() {
        return htmlString;
    }

    public void setHtmlString(String htmlString) {
        this.htmlString = htmlString;
    }

    public int getDirectoryStartPage() {
        return directoryStartPage;
    }

    public void setDirectoryStartPage(int directoryStartPage) {
        this.directoryStartPage = directoryStartPage;
    }
}
