package com.retechcorp.android.epub.reader.parser.beans.html;

import com.retechcorp.android.epub.reader.parser.EpubParserConstants;
import org.htmlparser.Node;
import org.htmlparser.Remark;
import org.htmlparser.Tag;
import org.htmlparser.visitors.NodeVisitor;

import java.util.LinkedList;

/**
 * Created by Meng on 15/4/8.
 * html解析
 */
public class Paragraph implements AElement {
    private LinkedList<AElement> elementList;

    public Paragraph(Node paragraph) {
        this.elementList = new LinkedList<>();
        paragraph.accept(new NodeVisitor() {

            private Tag tag;

            @Override
            public void beginParsing() {
                //System.out.println("==============开始解析============");
            }

            @Override
            public void visitTag(Tag tag) {
                this.tag = tag;
                //System.out.println("==============开始标签 " + tag.getTagName() + "============");
                if (EpubParserConstants.CONSTANT_HTML_TAG_NAME_P.equalsIgnoreCase(tag.getTagName())) {

                } else if (EpubParserConstants.CONSTANT_HTML_TAG_NAME_A.equalsIgnoreCase(tag.getTagName())) {
                    elementList.add(new A(tag.getText(), tag));
                } else if (EpubParserConstants.CONSTANT_HTML_TAG_NAME_IMG.equalsIgnoreCase(tag.getTagName())) {
                    elementList.add(new Image(tag.getAttribute(EpubParserConstants.CONSTANT_HTML_TAG_ATTRIBUTE_SRC)));
                } else if (EpubParserConstants.CONSTANT_HTML_TAG_NAME_AUDIO.equalsIgnoreCase(tag.getTagName())) {
                    elementList.add(new Audio(tag.getAttribute(EpubParserConstants.CONSTANT_HTML_TAG_ATTRIBUTE_SRC)));
                } else if (EpubParserConstants.CONSTANT_HTML_TAG_NAME_VIDEO.equalsIgnoreCase(tag.getTagName())) {
                    elementList.add(new Video(tag.getAttribute(EpubParserConstants.CONSTANT_HTML_TAG_ATTRIBUTE_SRC)));
                } else if (EpubParserConstants.CONSTANT_HTML_TAG_NAME_IMAGE.equalsIgnoreCase(tag.getTagName())) {
                    elementList.add(new Image(tag.getAttribute(EpubParserConstants.CONSTANT_HTML_TAG_ATTRIBUTE_XLINK_HREF)));
                }
            }

            @Override
            public void visitEndTag(Tag tag) {
                // System.out.println("==============结束标签" + tag.getTagName() + "============");
                if (tag.getTagName().equals("P") || tag.getTagName().equals("DIV") || tag.getTagName().equals("H1")
                        || tag.getTagName().equals("H2") || tag.getTagName().equals("H3")) {
                    elementList.add(new EndTag(tag));
                }
            }

            @Override
            public void visitStringNode(org.htmlparser.Text string) {
                String text = string.getText();
                if (!"".equals(text.trim().replaceAll(System.getProperty("line.separator"), ""))) {
                    elementList.add(new Text(string.getText(), tag));
                }
            }

            @Override
            public void visitRemarkNode(Remark remark) {
                //System.out.println("==============标记节点============");
            }

            @Override
            public void finishedParsing() {
                //System.out.println("==============结束解析============");
            }

            @Override
            public boolean shouldRecurseChildren() {
                //System.out.println("==============shouldRecurseChildren============");
                return super.shouldRecurseChildren();
            }

            @Override
            public boolean shouldRecurseSelf() {
                //System.out.println("==============shouldRecurseSelf============");
                return super.shouldRecurseSelf();
            }
        });

    }

    public LinkedList<AElement> getElementList() {
        return elementList;
    }
}
