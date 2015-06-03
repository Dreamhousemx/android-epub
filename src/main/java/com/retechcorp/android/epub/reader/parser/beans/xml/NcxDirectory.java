package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.Required;
import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Meng on 15/4/8.
 * 解析.ncx文件
 */
public class NcxDirectory extends ALabel {

    @Required
    private String version;
    @Required
    private NavMap navMap;

    public NcxDirectory(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置directory节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (NCX_LABEL_VERSION.equals(attributeName)) {
                this.version = attributeValue;
            }
        }

        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (NCX_LABEL_NAVMAP.equals(nodeName)) {
                        //navMap 的开始节点
                        this.navMap = new NavMap(xmlPullParser);
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (this.NCX_LABEL_NCX.equals(nodeName)) {
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

    public String getVersion() {
        return version;
    }

    public NavMap getNavMap() {
        return navMap;
    }
}

