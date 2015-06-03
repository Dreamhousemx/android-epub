package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Meng on 15/4/8.
 */
public class NavPoint extends ALabel {

    private String id;
    private String playOrder;
    private String text;
    private String src;

    public NavPoint(XmlPullParser xmlPullParser) throws Exception {
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
                    if (NCX_LABEL_NAVPOINT.equals(nodeName)) {
                        this.id = xmlPullParser.getAttributeValue(null, NCX_LABEL_ID);
                        this.playOrder = xmlPullParser.getAttributeValue(null, NCX_LABEL_PLAYORDER);
                    } else if (NCX_LABEL_TEXT.equals(nodeName)) {
                        this.text = xmlPullParser.nextText();
                    } else if (NCX_LABEL_CONTENT.equals(nodeName)) {
                        this.src = xmlPullParser.getAttributeValue(null, NCX_LABEL_SRC);
                    }
                    //结束节点
                case XmlPullParser.END_TAG:
                    if (this.NCX_LABEL_NAVPOINT.equals(nodeName)) {
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

    public String getId() {
        return id;
    }

    public String getPlayOrder() {
        return playOrder;
    }

    public String getText() {
        return text;
    }

    public String getSrc() {
        return src;
    }
}
