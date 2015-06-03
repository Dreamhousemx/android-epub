package com.retechcorp.android.epub.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.retechcorp.android.epub.activity.EpubReaderActivity;
import com.retechcorp.android.epub.reader.parser.utils.DebugLog;
import com.retechcorp.android.epub.utils.EpubJavaScript;
import com.retechcorp.android.epub.utils.FileUtil;
import com.retechcorp.android.epub.utils.UIHelper;

import java.io.IOException;

public class EpubWebView extends WebView {

    private String epubHtmlFileUrl = "";
    private String basedir = "";
    private EpubReaderActivity activity;
    private int scrollWidth = 0;
    private int totalPage = 0;
    private float anchorPosition = 0;
    private boolean isLoadComplete = false;
    private int curPosition = 0;
    private TextView mTextView = null;

    //private InputStream mInputStream = null;

    public EpubWebView(Context context) {
        super(context);
    }

    public EpubWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EpubWebView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private byte lock_loadUrl[] = new byte[1];

    public void setAct(EpubReaderActivity activity) {
        this.activity = activity;
    }

    public void execJavaScript(String js) {
        super.loadUrl("javascript:" + js);
    }

    public int getTotalPage() {
        return this.totalPage;
    }

    public float getAnchorPostion() {
        return this.anchorPosition;
    }

    public boolean isComplete() {
        return this.isLoadComplete;
    }

    public void setCurWebViewPosition(int position) {
        this.curPosition = position;
    }

    @Override
    public void setOnLongClickListener(OnLongClickListener l) {
        DebugLog.e("我去","==========");
        super.setOnLongClickListener(l);
    }

    @Override
    public void loadUrl(String url) {

        int widthDip = UIHelper.getScreenWidthDip(activity);
        int heightDip = UIHelper.getScreenHeightDip(activity);
        String css = EpubJavaScript.getWebCss(widthDip, heightDip, 10, activity);

        if (!this.epubHtmlFileUrl.equals(url)) {
            this.epubHtmlFileUrl = url;
        }
        synchronized (lock_loadUrl) {
            freeMemory();
            String file = this.epubHtmlFileUrl.replace("file:///", "");
            // 必须加入"file:///"开头，否则不能正确读取资源文件
            this.basedir = "file:///" + this.epubHtmlFileUrl.substring(0, this.epubHtmlFileUrl.lastIndexOf("/") + 1);
            String html;
            String data;
            try {
                byte[] bHtmlData = FileUtil.readFileByBytes(file);
                html = new String(bHtmlData, "UTF-8");

                int pos = html.indexOf("</head>");
                if (pos != -1) {
                    data = html.substring(0, pos) + "\n<meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; minimum-scale=1.0; maximum-scale=1.0\"/>\n<style type='text/css'> \n<!--\n"
                            + css + "\n-->\n </style>\n" + html.substring(pos, html.length());
                } else {
                    pos = html.indexOf("<body");
                    if (pos != -1) {
                        data = "<head>" + html.substring(0, pos) + "\n<meta name=\"viewport\" content=\"width=device-width; initial-scale=1.0; minimum-scale=1.0; maximum-scale=1.0\"/>\n<style type='text/css'> \n<!--\n"
                                + css + "\n-->\n </style>\n" + "</head>\n" + html.substring(pos, html.length());
                    } else {
                        data = html;
                    }
                }
                super.loadDataWithBaseURL(this.basedir, data, "text/html", "UTF-8", null);
                setEpubProperties();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //set setting of webview
    private void setEpubProperties() {
        //unable scroll bar
        this.setHorizontalScrollBarEnabled(false);
        //enable JavaScript
        this.getSettings().setJavaScriptEnabled(true);
        //add new interface that contract with Javascript
        this.addJavascriptInterface(new JavaScriptInterface(), "Android");
        //set setWebChromeClient object and get onProgressChanged and onConsoleMessage methonds
        this.setWebChromeClient(new EpubWebChromeClient());
        //set WebviewClient object and get onPageFinished methond
        this.setWebViewClient(new EpubWebviewClient());
        //make the webview can't scroll
        this.setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    private class EpubWebChromeClient extends WebChromeClient {

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
            if (mTextView != null) {
                mTextView.setText(newProgress + "%");
                if (newProgress == 100) {
                    mTextView.setText("99%");
                }
            }
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            return super.onConsoleMessage(consoleMessage);
        }

//        @Override
//        public void onConsoleMessage(String message, int lineNumber, String sourceID) {
//            super.onConsoleMessage(message, lineNumber, sourceID);
//        }
    }

    //calling after webview object finish loading html
    //加载html完成后
    private class EpubWebviewClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            setProcessBar();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            //through Javascript to get the scollWidth of webview
            String js = " var scrollWidth = document.documentElement.scrollWidth;" +
                    " Android.setScrollWidthInterface(scrollWidth);" +
                    " Android.show(document.body.innerHTML);" +
                    //可以用来记忆当前的位置，直接使用scrollTo设置到某x轴
                    " window.scrollTo(" + EpubWebView.this.curPosition + ",0);" +
                    " Android.setCompleteInterface();";
            execJavaScript(js);
        }
    }

    //设置过程进度
    private void setProcessBar() {
        mTextView = new TextView(activity);
        mTextView.setTextSize(50);
        mTextView.setGravity(Gravity.CENTER);
        EpubWebView.this.addView(mTextView, new LinearLayout.LayoutParams(UIHelper.getScreenWidth(activity),
                UIHelper.getScreenHeight(activity)));
    }

    //set the value of scrollWidth
    //设置scorllWidth的值
    private class JavaScriptInterface {
        public void setScrollWidthInterface(int scrollWidth) {
            EpubWebView.this.scrollWidth = scrollWidth;
            EpubWebView.this.totalPage = (int) Math.ceil(((double) scrollWidth) / UIHelper.getScreenWidthDip(activity));
        }

        public void setCompleteInterface() {
            EpubWebView.this.isLoadComplete = true;
            //make progress bar disappear
            //隐藏进度条
            if (mTextView != null) {
                EpubWebView.this.post(new Runnable() {
                    @Override
                    public void run() {
                        removeView(mTextView);
                    }
                });
            }
        }

        public void show(String data) {
            // 获取html每页内容
//            DebugLog.e("获取每页内容", "" + data);
        }
    }
}
