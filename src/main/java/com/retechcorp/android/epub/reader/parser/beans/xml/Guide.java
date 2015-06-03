package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Meng on 15/4/8.
 */
public class Guide extends ALabel {
    private List<Reference> references;

    public Guide(XmlPullParser xmlPullParser) throws Exception {
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
                    if (CONSTANT_LABEL_REFERENCE.equals(nodeName)) {
                        //itemrefs 的开始节点
                        if (this.references == null) {
                            this.references = new LinkedList<>();
                        }
                        this.references.add(new Reference(xmlPullParser));
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (this.CONSTANT_LABEL_GUIDE.equals(nodeName)) {
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

    public List<Reference> getReferences() {
        return references;
    }
}
