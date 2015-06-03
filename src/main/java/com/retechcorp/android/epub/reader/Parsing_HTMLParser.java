package com.retechcorp.android.epub.reader;

/**
 * Created by Meng on 15/4/3.
 * HTMLParser解析
 */
public class Parsing_HTMLParser {

//    public Parsing_HTMLParser() {
//
//    }
//
//    public void parsing(Directory_Epub directory) throws Exception {
//        CalculatePages calculatePages = new CalculatePages();
//        Chapter chapter = new Chapter(directory);
//        List<Paragraph> paragraphList = chapter.getParagraphList();
//        for (Paragraph paragraph : paragraphList) {
//            calculatePages.calculateParagraph(paragraph);
//        }
//        Factory_Epub.TEMPORARYPAGES++;
//    }
//
//    public void parsing(Directory_Epub directory, int page, List<TextWord_Epub> curTextWords,
//                        List<Resources_Epub> curResources) throws Exception {
//        CalculatePage curPage = new CalculatePage(directory, page, curTextWords, curResources);
//        Chapter chapter = new Chapter(directory);
//        List<Paragraph> paragraphList = chapter.getParagraphList();
//        Factory_Epub.ISPAGE = false;
//        for (Paragraph paragraph : paragraphList) {
//            if (!Factory_Epub.ISPAGE) {
//                curPage.calculateParagraph(paragraph);
//            } else {
//                return;
//            }
//        }
//    }
//
//    public int parsing(Directory_Epub directory, int startIndex) throws Exception {
//        RequestPage curPage = new RequestPage(directory, startIndex);
//        Chapter chapter = new Chapter(directory);
//        List<Paragraph> paragraphList = chapter.getParagraphList();
//        Factory_Epub.ISPAGE = false;
//        for (Paragraph paragraph : paragraphList) {
//            if (!Factory_Epub.ISPAGE) {
//                curPage.calculateParagraph(paragraph);
//            } else {
//                break;
//            }
//        }
//        return curPage.page;
//    }
//
//    public int parsing(Directory_Epub directory,String id) throws Exception {
//        RequestDirectoryPage curPage = new RequestDirectoryPage(directory, id);
//        Chapter chapter = new Chapter(directory);
//        List<Paragraph> paragraphList = chapter.getParagraphList();
//        Factory_Epub.ISPAGE = false;
//        for (Paragraph paragraph : paragraphList) {
//            if (!Factory_Epub.ISPAGE) {
//                curPage.calculateParagraph(paragraph);
//            } else {
//                break;
//            }
//        }
//        return curPage.page;
//    }
}
