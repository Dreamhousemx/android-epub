package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.Required;
import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Meng on 15/4/8.
 * 解析toc文件
 */
public class NavDirectory extends ALabel {

    @Required
    private String version;
    @Required
    private Nav_Li navLi;

    public NavDirectory(XmlPullParser xmlPullParser) throws Exception {
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
                    if (NCX_LABEL_NAV.equals(nodeName)) {
                        //navMap 的开始节点
                        this.navLi = new Nav_Li(xmlPullParser);
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (this.NCX_LABEL_SECTION.equals(nodeName)) {
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

    public Nav_Li getNavLi() {
        return navLi;
    }
}

