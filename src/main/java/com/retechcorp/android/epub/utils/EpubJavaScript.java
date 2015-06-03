package com.retechcorp.android.epub.utils;

import com.retechcorp.android.epub.activity.EpubReaderActivity;

public class EpubJavaScript {


    public static String getWebCss(int w, int h, int marginSpace, EpubReaderActivity activity) {

        //该CSS决定了epub的html内容“分屏排版
        return " html { "
                + " padding: " + (marginSpace * 4) + "px 0px " + marginSpace + "px " + marginSpace + "px; height: " + (h - marginSpace * 8) + "px; "
                + " -webkit-column-gap: " + (marginSpace * 2) + "px; "
                + " -webkit-column-width: " + (w - marginSpace * 2) + "px;"
                + " width : " + (w - marginSpace * 2) + "px;"
                + "}"
                + " img {"
                + " display: block;"
                + " margin-left: auto;"
                + " margin-right: auto;"
                + " max-height: 100% !important;"
                + " max-width: 100% !important;"
                + " height : auto !important;"
                + "}"
                + " video {"
                + " display: block;"
                + " margin-left: auto;"
                + " margin-right: auto;"
                + " max-height: 100% !important;"
                + " max-width: 100% !important;"
                + " height : auto !important;"
                + "}"
                + " audio {"
                + " display: block;"
                + " margin-left: auto;"
                + " margin-right: auto;"
                + " max-height: 100% !important;"
                + " max-width: 100% !important;"
                + " height : auto !important;"
                + "}";
    }
}
