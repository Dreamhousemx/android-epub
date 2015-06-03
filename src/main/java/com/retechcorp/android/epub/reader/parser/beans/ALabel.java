package com.retechcorp.android.epub.reader.parser.beans;

import com.retechcorp.android.epub.reader.parser.EpubParserConstants;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Meng on 15/4/8.
 */
public abstract class ALabel implements EpubParserConstants {

    protected XmlPullParser xmlPullParser;

    public ALabel(XmlPullParser xmlPullParser) throws Exception {
        this.xmlPullParser = xmlPullParser;
        this.parser();
    }

    protected abstract void parser() throws Exception;
}
