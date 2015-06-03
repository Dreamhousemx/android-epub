package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Meng on 15/4/8.
 */
public class Reference extends ALabel {
    private String title;
    private String type;
    private String href;

    public Reference(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (CONSTANT_LABEL_TITLE.equals(attributeName)) {
                this.title = attributeValue;
            } else if (CONSTANT_LABEL_HREF.equals(attributeName)) {
                this.href = attributeValue;
            } else if (CONSTANT_LABEL_TYPE.equals(attributeName)) {
                this.type = attributeValue;
            }
        }
    }
}
