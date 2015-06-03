package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.Required;
import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import org.xmlpull.v1.XmlPullParser;

import java.util.LinkedList;

/**
 * Created by Meng on 15/4/8.
 */
public class Metadata extends ALabel {
    @Required
    private LinkedList<Identifier> dcIdentifier;
    @Required
    private LinkedList<Title> dcTitle;
    @Required
    private LinkedList<Language> dcLanguage;
    @Required
    private LinkedList<Creator> dcCreator;
    @Required
    private LinkedList<Publisher> dcPublisher;

    public Metadata(XmlPullParser xmlPullParser) throws Exception {
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
                    if (CONSTANT_LABEL_DC_IDENTIFIER.equals(nodeName)) {
                        //dc:identifier的开始节点
                        if (this.dcIdentifier == null) {
                            this.dcIdentifier = new LinkedList<>();
                        }
                        this.dcIdentifier.add(new Identifier(xmlPullParser));
                    } else if (CONSTANT_LABEL_DC_TITLE.equals(nodeName)) {
                        //dc:title的开始节点
                        if (this.dcTitle == null) {
                            this.dcTitle = new LinkedList<>();
                        }
                        this.dcTitle.add(new Title(xmlPullParser));
                    } else if (CONSTANT_LABEL_DC_LANGUAGE.equals(nodeName)) {
                        //dc:language的开始节点
                        if (this.dcLanguage == null) {
                            this.dcLanguage = new LinkedList<>();
                        }
                        this.dcLanguage.add(new Language(xmlPullParser));
                    } else if (CONSTANT_LABEL_DC_CREATOR.equals(nodeName)) {
                        if (this.dcCreator == null) {
                            this.dcCreator = new LinkedList<>();
                        }
                        this.dcCreator.add(new Creator(xmlPullParser));
                    } else if (CONSTANT_LABEL_DC_PUBLISHER.equals(nodeName)) {
                        if (this.dcPublisher == null) {
                            this.dcPublisher = new LinkedList<>();
                        }
                        this.dcPublisher.add(new Publisher(xmlPullParser));
                    }
                    //结束节点
                case XmlPullParser.END_TAG:
                    if (this.CONSTANT_LABEL_METADATA.equals(nodeName)) {
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

    public LinkedList<Identifier> getDcIdentifier() {
        return dcIdentifier;
    }

    public LinkedList<Title> getDcTitle() {
        return dcTitle;
    }

    public LinkedList<Language> getDcLanguage() {
        return dcLanguage;
    }

    public LinkedList<Creator> getDcCreator() {
        return dcCreator;
    }

    public LinkedList<Publisher> getDcPublisher() {
        return dcPublisher;
    }
}
