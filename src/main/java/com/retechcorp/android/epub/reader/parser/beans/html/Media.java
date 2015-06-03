package com.retechcorp.android.epub.reader.parser.beans.html;

/**
 * Created by Meng on 15/4/8.
 */
public abstract class Media implements AElement {
    protected String path;

    public Media(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
