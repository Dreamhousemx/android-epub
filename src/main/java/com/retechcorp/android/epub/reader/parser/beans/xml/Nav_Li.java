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
public class Nav_Li extends ALabel {

    private Map<String, Nav_Item> navItemMap;
    private List<Nav_Item> navItems;

    public Nav_Li(XmlPullParser xmlPullParser) throws Exception {
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
                    if (NCX_LABEL_LI.equals(nodeName)) {
                        //li的开始节点
                        if (this.navItems == null) {
                            this.navItems = new LinkedList<Nav_Item>();
                        }
                        if (navItemMap == null) {
                            this.navItemMap = new HashMap<String, Nav_Item>();
                        }
                        Nav_Item navItem = new Nav_Item(xmlPullParser);
                        this.navItemMap.put(navItem.getText(), navItem);
                        this.navItems.add(navItem);
                    }
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

    public List<Nav_Item> getNavItems() {
        return navItems;
    }

    public Nav_Item getNavItemMap(String id) {
        if (this.navItemMap == null) {
            return null;
        }
        return this.navItemMap.get(id);
    }
}
