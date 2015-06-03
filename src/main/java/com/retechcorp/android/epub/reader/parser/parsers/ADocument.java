package com.retechcorp.android.epub.reader.parser.parsers;

import com.retechcorp.android.epub.reader.parser.EpubParserConstants;

/**
 * Created by Meng on 15/4/8.
 * 解析文件基类
 */
public abstract class ADocument implements EpubParserConstants {

    protected String documentPath;
    protected String source;
    protected String target;
    protected String desKey;

    public ADocument(String documentPath) throws Exception {
        this.documentPath = documentPath;
        this.parser();
    }

    public ADocument(String source, String target, String desKey) throws Exception {
        this.source = source;
        this.target = target;
        this.desKey = desKey;
        this.parser();
    }

    protected abstract void parser() throws Exception;
}
