package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Meng on 15/4/8.
 */
public class NavMap extends ALabel {
    private Map<String, NavPoint> idNavPoints;
    private List<NavPoint> navPoints;

    public NavMap(XmlPullParser xmlPullParser) throws Exception {
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
                        //navPoint的开始节点
                        if (this.navPoints == null) {
                            this.navPoints = new LinkedList<>();
                        }
                        if (idNavPoints == null) {
                            this.idNavPoints = new HashMap<>();
                        }
                        NavPoint navPoint = new NavPoint(xmlPullParser);
                        this.idNavPoints.put(navPoint.getId(), navPoint);
                        this.navPoints.add(navPoint);
                    }
                    //结束节点
                case XmlPullParser.END_TAG:
                    if (this.NCX_LABEL_NAVMAP.equals(nodeName)) {
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

    public List<NavPoint> getNavPoints() {
        return navPoints;
    }

    public NavPoint getNavPointById(String id) {
        if (this.idNavPoints == null) {
            return null;
        }
        return this.idNavPoints.get(id);
    }
}
