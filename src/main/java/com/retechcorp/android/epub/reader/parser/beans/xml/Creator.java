package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.Optional;
import com.retechcorp.android.epub.reader.parser.Required;
import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Meng on 15/4/8.
 */
public class Creator extends ALabel {

    @Optional
    private String id;
    @Required
    private String value;

    public Creator(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = this.xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //解析属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (CONSTANT_LABEL_ID.equals(attributeName)) {
                this.id = attributeValue;
            }
        }
        this.value = this.xmlPullParser.nextText();
    }

    public String getId() {
        return id;
    }

    public String getValue() {
        return value;
    }
}
