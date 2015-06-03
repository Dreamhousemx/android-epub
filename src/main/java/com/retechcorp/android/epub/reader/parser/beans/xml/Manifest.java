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
public class Manifest extends ALabel {
    private Map<String, Item> idItems;
    private List<Item> items;

    public Manifest(XmlPullParser xmlPullParser) throws Exception {
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
                    if (CONSTANT_LABEL_ITEM.equals(nodeName)) {
                        //dc:identifier的开始节点
                        if (this.items == null) {
                            this.items = new LinkedList<>();
                        }
                        if (idItems == null) {
                            this.idItems = new HashMap<>();
                        }
                        Item item = new Item(xmlPullParser);
                        this.idItems.put(item.getId(), item);
                        this.items.add(item);
                    }
                    //结束节点
                case XmlPullParser.END_TAG:
                    if (this.CONSTANT_LABEL_MANIFEST.equals(nodeName)) {
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

    public List<Item> getItems() {
        return items;
    }

    public Item getItemById(String id) {
        if (this.idItems == null) {
            return null;
        }
        return this.idItems.get(id);
    }
}
