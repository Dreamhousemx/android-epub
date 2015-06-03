package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Meng on 15/4/8.
 */
public class Spine extends ALabel {
    private String toc;
    private List<Itemref> itemrefs;

    public Spine(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (CONSTANT_LABEL_TOC.equals(attributeName)) {
                this.toc = attributeValue;
            }
        }

        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (CONSTANT_LABEL_ITEM_REF.equals(nodeName)) {
                        //itemrefs 的开始节点
                        if (this.itemrefs == null) {
                            this.itemrefs = new LinkedList<>();
                        }
                        this.itemrefs.add(new Itemref(xmlPullParser));
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (this.CONSTANT_LABEL_SPINE.equals(nodeName)) {
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

    public String getToc() {
        return toc;
    }

    public List<Itemref> getItemrefs() {
        return itemrefs;
    }
}
