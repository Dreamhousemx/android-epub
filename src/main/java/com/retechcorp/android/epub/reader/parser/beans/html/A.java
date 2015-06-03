package com.retechcorp.android.epub.reader.parser.beans.html;

import org.htmlparser.Tag;

/**
 * Created by Shaw on 15/5/25.
 * 超链接对象
 */
public class A implements AElement {
    private String text;
    private Tag tag;

    public A(String text, Tag tag) {
        this.text = text;
        this.tag = tag;
    }

    public String getText() {
        return text;
    }

    public Tag getTag() {
        return tag;
    }

    public String charAt(int index) {
        return text.charAt(index) + "";
    }

    public String substring(int start, int end) {
        return this.text.substring(start, end);
    }

    public A substring(int start) {
        this.text = this.text.substring(start);
        return this;
    }

    public int getLenght() {
        return this.text.length();
    }
}
