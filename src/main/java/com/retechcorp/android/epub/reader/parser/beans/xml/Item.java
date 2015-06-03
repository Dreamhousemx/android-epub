package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Meng on 15/4/8.
 */
public class Item extends ALabel {

    private String id;
    private String href;
    private String mediaType;

    public Item(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (CONSTANT_LABEL_ID.equals(attributeName)) {
                this.id = attributeValue;
            } else if (CONSTANT_LABEL_HREF.equals(attributeName)) {
                this.href = attributeValue;
            } else if (CONSTANT_LABEL_MEDIA_TYPE.equals(attributeName)) {
                this.mediaType = attributeValue;
            }
        }
    }


    public String getId() {
        return id;
    }

    public String getHref() {
        return href;
    }

    public String getMediaType() {
        return mediaType;
    }
}
