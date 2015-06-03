package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Meng on 15/4/8.
 */
public class Nav_Item extends ALabel {

    private String href;
    private String text;

    public Nav_Item(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (NCX_LABEL_A.equals(nodeName)) {
                        this.href = xmlPullParser.getAttributeValue(null, NCX_LABEL_A_HREF);
                        this.text = xmlPullParser.nextText();
                    }
                    //结束节点
                case XmlPullParser.END_TAG:
                    if (this.NCX_LABEL_LI.equals(nodeName)) {
                        eventType = XmlPullParser.END_DOCUMENT;
                    }
                    break;
                default:
                    break;
            }
            if (eventType != XmlPullParser.END_DOCUMENT) {
                eventType = xmlPullParser.next();
            }
        }
    }

    public String getHref() {
        return href;
    }

    public String getText() {
        return text;
    }
}
