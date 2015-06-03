package com.retechcorp.android.epub.reader.parser.beans.xml;

import com.retechcorp.android.epub.reader.parser.Optional;
import com.retechcorp.android.epub.reader.parser.Required;
import com.retechcorp.android.epub.reader.parser.beans.ALabel;
import com.retechcorp.android.epub.reader.parser.beans.Dir;
import org.xmlpull.v1.XmlPullParser;

/**
 * Created by Meng on 15/4/8.
 */
public class Package extends ALabel {
    @Required
    private String namespaces;
    @Required
    private String version;
    @Required
    private String uniqueIdentifier;
    @Optional
    private String prefix;
    @Optional
    private String xmlLang;
    @Optional
    private Dir dir;
    @Optional
    private String id;
    @Required
    private Metadata metadata;
    @Required
    private Manifest manifest;
    @Required
    private Spine spine;

    public Package(XmlPullParser xmlPullParser) throws Exception {
        super(xmlPullParser);
    }

    @Override
    protected void parser() throws Exception {
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i = 0; i < attributeCount; i++) {
            //设置package节点的属性
            String attributeName = xmlPullParser.getAttributeName(i);
            String attributeValue = xmlPullParser.getAttributeValue(i);
            if (CONSTANT_LABEL_UNIQUE_IDENTIFIER.equals(attributeName)) {
                this.uniqueIdentifier = attributeValue;
            } else if (CONSTANT_LABEL_VERSION.equals(attributeName)) {
                this.version = attributeValue;
            }
        }

        int eventType = xmlPullParser.next();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            String nodeName = xmlPullParser.getName();
            switch (eventType) {
                //开始节点
                case XmlPullParser.START_TAG:
                    if (CONSTANT_LABEL_METADATA.equals(nodeName)) {
                        //metadata 的开始节点
                        this.metadata = new Metadata(xmlPullParser);
                    } else if (CONSTANT_LABEL_MANIFEST.equals(nodeName)) {
                        //manifest 的开始节点
                        this.manifest = new Manifest(xmlPullParser);
                    } else if (CONSTANT_LABEL_SPINE.equals(nodeName)) {
                        //spine 的开始节点
                        this.spine = new Spine(xmlPullParser);
                    } else if (CONSTANT_LABEL_GUIDE.equals(nodeName)) {
                        //guide 的开始节点
                    }
                    break;
                //结束节点
                case XmlPullParser.END_TAG:
                    if (this.CONSTANT_LABEL_PACKAGE.equals(nodeName)) {
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

    public String getNamespaces() {
        return namespaces;
    }

    public String getVersion() {
        return version;
    }

    public String getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getXmlLang() {
        return xmlLang;
    }

    public Dir getDir() {
        return dir;
    }

    public String getId() {
        return id;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public Manifest getManifest() {
        return manifest;
    }

    public Spine getSpine() {
        return spine;
    }
}
