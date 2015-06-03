package com.retechcorp.android.epub.reader;

/**
 * Created by Meng on 15/4/3.
 * 计算排版
 */
public class CalculatePage {

//    // 当前章节
//    private Directory_Epub directory;
//    // 页数计算
//    private int page;
//    // 显示页
//    private int curPage;
//    // 屏幕可绘制宽度
//    private int drawWidth;
//    // 屏幕可绘制高度
//    private int drawHeight;
//    // 设置文字样式，大小
//    private Paint myCurTextPaint;
//    // 每个文字宽度
//    private int charWidth;
//    // 每页起始绘制高度
//    private int startY;
//    // 目录起始字坐标
//    private int pageStartIndex;
//    // 保存每页所有文字坐标的集合
//    private List<TextWord_Epub> curTextWords;
//    // 保存每页所有资源坐标的集合
//    private List<Resources_Epub> curResources;
//
//    //排版时调用
//    public CalculatePage(Directory_Epub directory, int curPage, List<TextWord_Epub> curTextWords, List<Resources_Epub> curResources) {
//        this.directory = directory;
//        this.curPage = curPage;
//        this.curTextWords = curTextWords;
//        this.curResources = curResources;
//        this.page = directory.getDirectoryStartPage();
//        initData();
//    }
//
//    //初始化
//    private void initData() {
//        // 设置可绘制宽度
//        drawWidth = UIHelper.getScreenWidth(EpubReaderActivity.activity) - Factory_Epub.TEXTSIZE;
//        // 设置可绘制高度
//        drawHeight = (int) (UIHelper.getScreenHeight(EpubReaderActivity.activity) * 0.9);
//        // 设置起始绘制高度
//        startY = (int) (UIHelper.getScreenHeight(EpubReaderActivity.activity) * 0.1);
//        // 设置文字宽度
//        myCurTextPaint = new Paint();
//        myCurTextPaint.setTypeface(Typeface.MONOSPACE);
//        myCurTextPaint.setTypeface(FontUtils.font);
//        myCurTextPaint.setTextSize(Factory_Epub.TEXTSIZE);
//        // 设置段落起始宽度
//        charWidth = Factory_Epub.TEXTSIZE * 3;
//    }
//
//    //循环计算段落中所有节点
//    public void calculateParagraph(Paragraph paragraph) {
//        List<AElement> elementList = paragraph.getElementList();
//        for (AElement element : elementList) {
//            if (element instanceof Text) {
//                typographyText(handlingText(((Text) element).getText()));
//            } else if (element instanceof Image) {
//                typographyRescore("image", ((Image) element).getPath());
//            } else if (element instanceof Audio) {
//                typographyRescore("audio", ((Audio) element).getPath());
//            } else if (element instanceof Video) {
//                typographyRescore("video", ((Video) element).getPath());
//            } else if (element instanceof EndTag) {
//                startY += Factory_Epub.TEXTSIZE * 2;
//                charWidth = Factory_Epub.TEXTSIZE * 3;
//            } else if (Factory_Epub.ISPAGE) {
//                return;
//            }
//        }
//    }
//
//    //文字排版
//    private void typographyText(String text) {
//        for (int i = 0; i < text.length(); i++) {
//            char c = text.charAt(i);
//            float[] widths = new float[1];
//            myCurTextPaint.getTextWidths(String.valueOf(c), widths);
//            if (startY > drawHeight) {
//                page++;
//                if (page > curPage + 1) {
//                    Factory_Epub.ISPAGE = true;
//                    return;
//                }
//                startY = (int) (UIHelper.getScreenHeight(EpubReaderActivity.activity) * 0.1);
//                charWidth = Factory_Epub.TEXTSIZE;
//                i--;
//                pageStartIndex--;
//            } else {
//                charWidth += (int) (Math.ceil(widths[0]));
//                if (page == curPage && charWidth < drawWidth) {
//                    // 保存当前页面的所有文字，和该文字的坐标
//                    curTextWords.add(new TextWord_Epub(String.valueOf(c), charWidth - (int) (Math.ceil(widths[0])), startY, pageStartIndex));
//                }
//                if (charWidth > drawWidth) {
//                    i--;
//                    pageStartIndex--;
//                    charWidth = Factory_Epub.TEXTSIZE;
//                    startY += Factory_Epub.TEXTSIZE / 2 + Factory_Epub.TEXTSIZE;
//                }
//            }
//            pageStartIndex++;
//        }
//    }
//
//    private String handlingText(String text) {
//        text = text.replaceAll("&gt;", ">");
//        text = text.replaceAll("&nbsp;", " ");
//        return text;
//    }
//
//    // 计算资源文件
//    private void typographyRescore(String type, String path) {
//        try {
//            // 文件加密、解密工具类
//            FileDES fileDES = new FileDES(Factory_Epub.DES_KEY);
//            path = URLDecoder.decode(path, "UTF-8");
//            String resourceURL;
//            if (path.contains("../")) {
//                resourceURL = Factory_Epub.FILEWORKPATH + path.replace("../", "");
//            } else {
//                resourceURL = Factory_Epub.FILEWORKPATH + path;
//            }
//            Bitmap resourceBitmap = null;
//            switch (type) {
//                case "image":
//                    // 解密文件
//                    InputStream fileInput = new FileInputStream(new File(resourceURL));
//                    InputStream inputStream = fileDES.doDecryptFile(fileInput);
//                    resourceBitmap = BitmapFactory.decodeStream(inputStream);
//                    // 关闭解密流
//                    inputStream.close();
//                    fileInput.close();
//                    break;
//                case "audio":
//                    Bitmap bitmap = ImageUtil.getAudioImage(resourceURL);
//                    resourceBitmap = ImageUtil.createCircleImage(bitmap, bitmap.getHeight());
//                    break;
//                case "video":
//                    resourceBitmap = ImageUtil.getVideoImage(resourceURL);
//                    break;
//            }
//            if (directory.getDirectoryName().equals("封面") || path.contains("cover")) {
//                type = "cover";
//            }
//            if (null != resourceBitmap) {
//                if (resourceBitmap.getWidth() >= UIHelper.getScreenWidth(EpubReaderActivity.activity) ||
//                        resourceBitmap.getHeight() >= UIHelper.getScreenHeight(EpubReaderActivity.activity)) {
//                    resourceBitmap = ImageUtil.zoomBitmap(resourceBitmap, resourceBitmap.getWidth() / 2, resourceBitmap.getHeight() / 2);
//                }
//                if (startY + resourceBitmap.getHeight() + (Factory_Epub.TEXTSIZE / 2) + Factory_Epub.TEXTSIZE > drawHeight) {
//                    page++;
//                    startY = (int) (UIHelper.getScreenHeight(EpubReaderActivity.activity) * 0.1);
//                    if (page == curPage) {
//                        curResources.add(new Resources_Epub(resourceBitmap, type, resourceURL, charWidth, startY, resourceBitmap.getWidth()));
//                    }
//                    if (resourceBitmap.getWidth() >= Factory_Epub.TEXTSIZE * 3 || resourceBitmap.getHeight() > Factory_Epub.TEXTSIZE * 2) {
//                        charWidth = Factory_Epub.TEXTSIZE * 3;
//                        startY += resourceBitmap.getHeight() + Factory_Epub.TEXTSIZE / 2;
//                    } else {
//                        charWidth += resourceBitmap.getWidth();
//                    }
//                } else {
//                    if (page == curPage) {
//                        curResources.add(new Resources_Epub(resourceBitmap, type, resourceURL, charWidth, startY, resourceBitmap.getWidth()));
//                    }
//                    if (resourceBitmap.getWidth() >= Factory_Epub.TEXTSIZE * 3 || resourceBitmap.getHeight() > Factory_Epub.TEXTSIZE * 2) {
//                        charWidth = Factory_Epub.TEXTSIZE * 3;
//                        startY += resourceBitmap.getHeight() + Factory_Epub.TEXTSIZE / 2;
//                    } else {
//                        charWidth += resourceBitmap.getWidth();
//                    }
//                }
//            }
//        } catch (Exception e) {
//            DebugLog.e("文件加密、解密工具类", "" + e.getMessage());
//        }
//    }
}
