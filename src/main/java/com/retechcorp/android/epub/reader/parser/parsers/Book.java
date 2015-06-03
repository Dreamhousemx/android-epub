package com.retechcorp.android.epub.reader.parser.parsers;

import com.retechcorp.android.epub.reader.parser.beans.xml.*;
import com.retechcorp.android.epub.reader.parser.utils.DebugLog;

import java.util.*;

/**
 * Created by Meng on 15/4/8.
 * 书籍解压信息模型
 */
public class Book extends ADocument {

    private String targetRescore;
    private ContentOpf contentOpf;
    private ContentNcx contentNcx;
    private ContentToc contentToc;

    public Book(String documentPath) throws Exception {
        super(documentPath);
    }

    public Book(String source, String target, String desKey) throws Exception {
        super(source, target, desKey);
    }

    @Override
    protected void parser() throws Exception {
        ContentFile contentFile = new ContentFile(this.source, this.target, this.desKey);
        this.documentPath = contentFile.getOpf();
        this.contentOpf = new ContentOpf(this.documentPath);
        for (int i = 0; i < this.contentOpf.getPackage().getManifest().getItems().size(); i++) {
            if (this.contentOpf.getPackage().getManifest().getItems().get(i).getId().equals("ncx")) {
                // 获取ncx文件全路径
                this.documentPath = this.documentPath.substring(0, this.documentPath.lastIndexOf('/') + 1)
                        + this.contentOpf.getPackage().getManifest().getItems().get(i).getHref();
                targetRescore = this.documentPath.substring(0, this.documentPath.lastIndexOf('/') + 1);
                this.contentNcx = new ContentNcx(this.documentPath);
                break;
            } else if (this.contentOpf.getPackage().getManifest().getItems().get(i).getId().equals("toc")) {
                // 获取toc文件全路径
                this.documentPath = this.documentPath.substring(0, this.documentPath.lastIndexOf('/') + 1)
                        + this.contentOpf.getPackage().getManifest().getItems().get(i).getHref();
                targetRescore = this.documentPath.substring(0, this.documentPath.lastIndexOf('/') + 1);
                this.contentToc = new ContentToc(this.documentPath);
                break;
            }
        }
    }

    public String getTargetRescore() {
        return targetRescore;
    }

    public ContentOpf getContentOpf() {
        return contentOpf;
    }

    public LinkedList<Creator> getAuthors() {
        return this.contentOpf.getPackage().getMetadata().getDcCreator();
    }

    public LinkedList<Publisher> getPublisher() {
        return this.contentOpf.getPackage().getMetadata().getDcPublisher();
    }

    public LinkedList<Language> getLanguage() {
        return this.contentOpf.getPackage().getMetadata().getDcLanguage();
    }

    public LinkedList<String> getSection() {
        LinkedList<String> sections = new LinkedList<>();
        List<Itemref> itemrefs = this.contentOpf.getPackage().getSpine().getItemrefs();
        Manifest manifest = this.contentOpf.getPackage().getManifest();
        for (Itemref itemref : itemrefs) {
            String idref = itemref.getIdref();
            Item itemById = manifest.getItemById(idref);
            sections.add(itemById.getHref());
        }
        return sections;
    }

    public List<Title> getTitle() {
        return this.contentOpf.getPackage().getMetadata().getDcTitle();
    }

    public List<Map<String, String>> getDirectorys() {
        List<Map<String, String>> directoryList = new ArrayList<>();
        // 解析epub2
        String path = this.documentPath.substring(0, this.documentPath.lastIndexOf("/") + 1);
        if (null != this.contentNcx) {
            List<NavPoint> navPoints = this.contentNcx.getNcxDirectory().getNavMap().getNavPoints();
            if (null != navPoints) {
                for (NavPoint navPoint : navPoints) {
                    Map<String, String> directoryMap = new HashMap<>();
                    if (navPoint.getSrc().contains("#_")) {
                        directoryMap.put("id", navPoint.getSrc().substring(navPoint.getSrc().indexOf("#_") + 1));
                    }
                    directoryMap.put("text", navPoint.getText());
                    directoryMap.put("src", path + navPoint.getSrc());
                    directoryList.add(directoryMap);
                }
            }
        } else if (null != this.contentToc) {// 解析epub3
            List<Nav_Item> navItems = this.contentToc.getNavDirectory().getNavLi().getNavItems();
            for (Nav_Item navItem : navItems) {
                DebugLog.e("==", navItem.getText() + "======" + navItem.getHref());
                Map<String, String> directoryMap = new HashMap<>();
                if (navItem.getHref().contains("#_")) {
                    directoryMap.put("id", navItem.getHref().substring(navItem.getHref().indexOf("#_") + 2));
                }
                directoryMap.put("text", navItem.getText());
                directoryMap.put("src", path + navItem.getHref());
                directoryList.add(directoryMap);
            }
        }
        return directoryList;
    }

    public List<Map<String, String>> getDocumentOrder() {
        String path = this.documentPath.substring(0, this.documentPath.lastIndexOf("/") + 1);
        List<Map<String, String>> documents = new ArrayList<>();
        List<Itemref> spine = this.contentOpf.getPackage().getSpine().getItemrefs();
        Manifest manifest = this.contentOpf.getPackage().getManifest();
        for (Itemref itemref : spine) {
            String idref = itemref.getIdref();
            Item itemById = manifest.getItemById(idref);
            Map<String, String> document = new HashMap<>();
            String text = itemById.getHref().substring(itemById.getHref().lastIndexOf("/") + 1, itemById.getHref().lastIndexOf("."));
            document.put("text", text);
            document.put("src", path + itemById.getHref());
            documents.add(document);
        }
        return documents;
    }
}
