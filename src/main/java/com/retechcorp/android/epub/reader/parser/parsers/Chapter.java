package com.retechcorp.android.epub.reader.parser.parsers;

import com.retechcorp.android.epub.bean.Directory_Epub;
import com.retechcorp.android.epub.reader.parser.beans.html.Paragraph;
import com.retechcorp.android.epub.reader.parser.utils.DebugLog;
import com.retechcorp.android.epub.reader.parser.utils.FileDES;
import org.htmlparser.Node;
import org.htmlparser.Parser;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeList;

import java.util.LinkedList;

/**
 * Created by Meng on 15/4/8.
 * 章节解析
 */
public class Chapter extends ADocument {

    private LinkedList<Paragraph> paragraphList;
    private Directory_Epub directory;

    public Chapter(Directory_Epub directory) throws Exception {
        super(directory.getDirectoryPath());
        this.directory = directory;
        parser();
    }

    @Override
    protected void parser() throws Exception {
        if (null != directory) {
            if (null == directory.getHtmlString()) {
                // 解密文件
                FileDES fileDES = new FileDES(desKey);
                // 获取解密后的html字符串
                directory.setHtmlString(fileDES.doDecryptFile(this.documentPath));
            }
            if (!directory.getHtmlString().substring(0, 1).equals("<")) {
                directory.setHtmlString(directory.getHtmlString().substring(1));
            }
            Parser parser;
            try {
                parser = new Parser(directory.getHtmlString());
                parser.setEncoding("UTF-8");
                NodeList body = parser.extractAllNodesThatMatch(new TagNameFilter("BODY"));
                this.paragraphList = new LinkedList<>();
                for (int i = 0; i < body.size(); i++) {
                    Node node = body.elementAt(i);
                    NodeList children = node.getChildren();
                    for (int j = 0; j < children.size(); j++) {
                        Node paragraph = children.elementAt(j);
                        Paragraph prepared = new Paragraph(paragraph);
                        if (!prepared.getElementList().isEmpty()) {
                            this.paragraphList.add(prepared);
                        }
                    }
                }
            } catch (Exception e) {
                DebugLog.e("解析html出错", "" + e.getMessage());
            }
        }
    }

    public LinkedList<Paragraph> getParagraphList() {
        return paragraphList;
    }
}
