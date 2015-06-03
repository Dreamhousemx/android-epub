package com.retechcorp.android.epub.reader.parser.beans.html;

import org.htmlparser.Tag;

/**
 * Created by Shaw on 15/5/27.
 * 结束标签
 */
public class EndTag implements AElement {

    private Tag tag;

    public EndTag(Tag tag) {
        this.tag = tag;
    }

    public Tag getTag() {
        return tag;
    }
}
