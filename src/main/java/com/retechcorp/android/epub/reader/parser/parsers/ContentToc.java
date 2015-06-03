package com.retechcorp.android.epub.reader.parser.parsers;

import com.retechcorp.android.epub.reader.parser.beans.xml.NavDirectory;
import com.retechcorp.android.epub.reader.parser.utils.FileDES;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by Meng on 15/4/8.
 * ncx文件解析
 */
public class ContentToc extends ADocument {

    private NavDirectory navDirectory;

    public ContentToc(String documentPath) throws Exception {
        super(documentPath);
    }


    @Override
    protected void parser() throws Exception {
        if (this.documentPath != null) {
            XmlPullParserFactory pullParserFactory = XmlPullParserFactory.newInstance();
            pullParserFactory.setNamespaceAware(true);
            //获取XmlPullParser的实例
            XmlPullParser xmlPullParser = pullParserFactory.newPullParser();
            xmlPullParser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);

            // 解密文件
            FileDES fileDES = new FileDES(this.desKey);
            InputStream fileInput = new FileInputStream(new File(this.documentPath));
            InputStream inputStream = fileDES.doDecryptFile(fileInput);
            //设置输入流xml文件
            xmlPullParser.setInput(inputStream, "UTF-8");
            //开始
            int eventType = xmlPullParser.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String nodeName = xmlPullParser.getName();
                switch (eventType) {
                    //文档开始
                    case XmlPullParser.START_DOCUMENT:
                        break;
                    //开始节点
                    case XmlPullParser.START_TAG:
                        if (this.NCX_LABEL_SECTION.equals(nodeName)) {
                            this.navDirectory = new NavDirectory(xmlPullParser);
                        }
                        break;
                    //结束节点
                    case XmlPullParser.END_TAG:
                        break;
                    default:
                        break;
                }
                eventType = xmlPullParser.next();
            }
            // 关闭解密流
            inputStream.close();
            fileInput.close();
        }
    }

    public NavDirectory getNavDirectory() {
        return navDirectory;
    }
}
