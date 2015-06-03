package com.retechcorp.android.epub.reader.parser.beans.html;

/**
 * Created by Meng on 15/4/8.
 */
public class Image implements AElement {
    private String path;

    public Image(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
