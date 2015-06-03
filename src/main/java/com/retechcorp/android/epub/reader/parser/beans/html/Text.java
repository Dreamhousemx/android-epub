package com.retechcorp.android.epub.reader.parser.beans.html;

import org.htmlparser.Tag;

/**
 * Created by Meng on 15/4/8.
 * 文本对象
 */
public class Text implements AElement {
    private String text;
    private Tag tag;

    public Text(String text, Tag tag) {
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

    public Text substring(int start) {
        this.text = this.text.substring(start);
        return this;
    }

    public int getLenght() {
        return this.text.length();
    }
}
