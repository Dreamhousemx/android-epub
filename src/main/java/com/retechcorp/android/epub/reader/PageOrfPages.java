package com.retechcorp.android.epub.reader;

/**
 * Created by mx on 14/12/17.
 * 计算总页数入口
 */
public class PageOrfPages {

//    // 排版进度回调接口
//    private ReturnProgress returnProgress;
//
//    public PageOrfPages() {
//    }
//
//    public void setReturnProgress(ReturnProgress returnProgress) {
//        this.returnProgress = returnProgress;
//    }
//
//    public void getChapter(int chapterID) throws Exception {
//        calculateEachPage(Factory_Epub.BOOKMODEL.getDirectoryMap().get(chapterID));
//    }
//
//    public void getChapters(List<Directory_Epub> directorys) throws Exception {
//        calculatePages(directorys);
//    }
//
//    //单章计算
//    private void calculateEachPage(Directory_Epub directory) throws Exception {
//        Factory_Epub.TEMPORARYPAGES = 0;
//        calculateDirectory(directory);
//        Factory_Epub.BOOKPAGES = Factory_Epub.TEMPORARYPAGES;
//        DebugLog.i("计算单章页数：", "一共有：" + Factory_Epub.BOOKPAGES + "页");
//    }
//
//    //整本计算
//    private void calculatePages(List<Directory_Epub> directorys) throws Exception {
//        Factory_Epub.TEMPORARYPAGES = 0;
//        // 循环图书目录获得每个章节的路径，循环解析
//        for (int i = 0; i < directorys.size(); i++) {
//            Directory_Epub directory = directorys.get(i);
//            directory.setDirectoryStartPage(Factory_Epub.TEMPORARYPAGES);
////            for (int j = 0; j < Factory_Epub.getDirectory.size(); j++) {
////                if (directory.getDirectoryPath().contains(Factory_Epub.getDirectory.get(j).get("src"))) {
////                    Factory_Epub.getDirectory.get(j).put("page", Factory_Epub.TEMPORARYPAGES + "");
////                    break;
////                }
////            }
//            calculateDirectory(directory);
//            if (null != this.returnProgress) {
//                returnProgress.getProgress(i);
//            }
//        }
//        DebugLog.i("计算总页数：", "一共有：" + Factory_Epub.TEMPORARYPAGES + "页");
//        Factory_Epub.BOOKMODEL.getDirectoryMap().clear();
//        Factory_Epub.BOOKMODEL.getDirectoryMap().addAll(directorys);
//        Factory_Epub.BOOKPAGES = Factory_Epub.TEMPORARYPAGES;
//    }
//
//    private void calculateDirectory(Directory_Epub directory) throws Exception {
//        if (directory.getDirectoryPath().contains(".jpg") || directory.getDirectoryPath().contains(".jpeg")
//                || directory.getDirectoryPath().contains(".png")) {
//            Bitmap bitmap = BitmapFactory.decodeFile(directory.getDirectoryPath());
//            Resources_Epub imageResource = new Resources_Epub(bitmap, "full", directory.getDirectoryPath(), 0, 0, 0);
//            EpubReaderActivity.activity.curView.getCurResources().add(imageResource);
//            Factory_Epub.TEMPORARYPAGES++;
//        } else {
//            // 调用HTMLParser解析
//            Parsing_HTMLParser parsing_htmlParser = new Parsing_HTMLParser();
//            parsing_htmlParser.parsing(directory);
//        }
//    }
}
