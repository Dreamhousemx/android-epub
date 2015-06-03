package com.retechcorp.android.epub.activity;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.retechcorp.android.epub.R;
import com.retechcorp.android.epub.bean.Directory_Epub;
import com.retechcorp.android.epub.reader.parser.parsers.Book;
import com.retechcorp.android.epub.reader.parser.utils.DebugLog;
import com.retechcorp.android.epub.utils.UIHelper;
import com.retechcorp.android.epub.view.EpubWebView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by mx on 14/12/17.
 * 主显示页面
 */
public class EpubReaderActivity extends Activity implements GestureDetector.OnGestureListener {

    public static EpubReaderActivity activity;
    private GestureDetector gd;
    private Book book;
    private List<Directory_Epub> directorys;
    private LinearLayout mEpubLinearLayout;
    private EpubWebView mCurEpubWebView = null;
    private EpubWebView mPreEpubWebview = null;
    private EpubWebView mNextEpubWebview = null;
    private int scrollWidth = 0;

    private int curHtmlPage = 0;
    private int htmlSize = 0;
    private static final int NEXT_PAGE = 0;
    private static final int PRE_PAGE = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gd = new GestureDetector(this);
        // 设置无标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        // 设置全屏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        activity = this;
        // epub文件路径
        String source = getIntent().getStringExtra("source");
        String target = source.substring(0, source.lastIndexOf("/")) + source.substring(source.lastIndexOf("/"), source.lastIndexOf(".epub"));
        if (new File(source).exists()) {
            try {
                String desKey = "我去";
                book = new Book(source, target, desKey);
                getDocuments();
                setContentView(R.layout.epub_reader);
                initUiView();
                initData();
            } catch (Exception e) {
                e.printStackTrace();
                System.gc();
            }
        } else {
            Toast.makeText(EpubReaderActivity.this, "书籍不存在，请选择正确书籍！", Toast.LENGTH_LONG).show();
            EpubReaderActivity.this.finish();
        }
    }

    public List<Directory_Epub> getDocuments() {
        directorys = new ArrayList<>();
        for (Map<String, String> map : book.getDocumentOrder()) {
            Directory_Epub directory = new Directory_Epub();
            directory.setDirectoryName(map.get("text"));
            directory.setDirectoryPath(map.get("src"));
            directorys.add(directory);
        }
        return directorys;
    }

    @Override
    protected void onPause() {
        super.onPause();
    }


    private void initUiView() {
        mEpubLinearLayout = (LinearLayout) findViewById(R.id.epubLinearLayout);
    }

    private void initData() {
//        int pages = 0;
//        for (Directory_Epub directoryEpub : directorys) {
//            EpubWebView webView = new EpubWebView(this);
//            webView.setAct(activity);
//            webView.loadUrl(directoryEpub.getDirectoryPath());
//            int page= webView.getTotalPage();
//        }
//        DebugLog.e("计算总页数", "===" + pages);

        htmlSize = directorys.size();

        String curHtml = directorys.get(curHtmlPage).getDirectoryPath();
        mCurEpubWebView = new EpubWebView(this);

        mEpubLinearLayout.addView(mCurEpubWebView, new LinearLayout.LayoutParams(UIHelper.getScreenWidth(activity), UIHelper.getScreenHeight(activity)));
        mCurEpubWebView.setAct(activity);
        mCurEpubWebView.loadUrl(curHtml);

        mPreEpubWebview = new EpubWebView(this);
        mPreEpubWebview.setVisibility(View.GONE);
        mEpubLinearLayout.addView(mPreEpubWebview, new LinearLayout.LayoutParams(UIHelper.getScreenWidth(activity), UIHelper.getScreenHeight(activity)));
        mCurEpubWebView.setAct(activity);

        curHtmlPage++;

        String nextHtml = directorys.get(curHtmlPage).getDirectoryPath();
        mNextEpubWebview = new EpubWebView(this);
        mNextEpubWebview.setAct(activity);
        mEpubLinearLayout.addView(mNextEpubWebview, new LinearLayout.LayoutParams(UIHelper.getScreenWidth(activity), UIHelper.getScreenHeight(activity)));
        LoadHtmlTask htt = new LoadHtmlTask(mNextEpubWebview, nextHtml);
        htt.execute();
        Log.e("=====>>>", "==" + mCurEpubWebView.getTotalPage());
    }

    /*override dispatchTouchEvent method and dispatch the touch event to GestureDetector*/
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        gd.onTouchEvent(ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onDown(MotionEvent arg0) {
        return false;
    }

    private int verticalMinDistance = 20;
    private int minVelocity = 0;
    private double mCurX = 0;
    private double curPage = 1;

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        // 每个html可以显示的页数
        int mTotalPage = mCurEpubWebView.getTotalPage();
        if (e1.getX() - e2.getX() > verticalMinDistance && Math.abs(velocityX) > minVelocity) {
            if (curPage >= mTotalPage && curHtmlPage == htmlSize) {
                Toast.makeText(activity, "已经是最后一页了", Toast.LENGTH_SHORT).show();
                return true;
            }
            curPage++;
            if (curPage > mTotalPage && curHtmlPage < htmlSize) {
                curPage = 1;
                changePage(NEXT_PAGE);
            }
            mCurX = (curPage - 1) * UIHelper.getScreenWidth(activity);
            mCurEpubWebView.scrollTo((int) mCurX, 0);
        } else if (e2.getX() - e1.getX() > verticalMinDistance && Math.abs(velocityX) > minVelocity) {
            if (curPage <= 1 && curHtmlPage <= 1) {
                Toast.makeText(activity, "已经是第一页", Toast.LENGTH_SHORT).show();
                return true;
            }
            curPage--;
            if (curPage <= 0 && curHtmlPage <= htmlSize) {
                changePage(PRE_PAGE);
                curPage = mCurEpubWebView.getTotalPage();
            }
            mCurX = (curPage - 1) * UIHelper.getScreenWidth(activity);
            mCurEpubWebView.scrollTo((int) mCurX, 0);
        }
        return true;
    }

    private void changePage(int num) {

        EpubWebView tmpCurWebView = mCurEpubWebView;
        EpubWebView tmpNextWebView = mNextEpubWebview;
        EpubWebView tmpPreWebView = mPreEpubWebview;

        if (num == NEXT_PAGE) {

            mCurEpubWebView = tmpNextWebView;
            mPreEpubWebview = tmpCurWebView;
            mNextEpubWebview = tmpPreWebView;

            tmpNextWebView.setVisibility(View.VISIBLE);
            tmpCurWebView.setVisibility(View.GONE);
            tmpPreWebView.setVisibility(View.GONE);
            curHtmlPage++;
            if (curHtmlPage < htmlSize) {
                preLoadNextHtml(mNextEpubWebview, curHtmlPage);
            }
        } else if (num == PRE_PAGE) {

            mCurEpubWebView = tmpPreWebView;
            mPreEpubWebview = tmpNextWebView;
            mNextEpubWebview = tmpCurWebView;

            tmpPreWebView.setVisibility(View.VISIBLE);
            tmpCurWebView.setVisibility(View.GONE);
            tmpNextWebView.setVisibility(View.GONE);

            curHtmlPage--;
            int preHtmlPage = curHtmlPage - 2;
            if (preHtmlPage >= 0) {
                preLoadNextHtml(mPreEpubWebview, preHtmlPage);
            }
        }
    }

    private void preLoadNextHtml(EpubWebView epubView, int page) {
        String nextHtml = directorys.get(page).getDirectoryPath();
        epubView.setAct(activity);
        LoadHtmlTask htt = new LoadHtmlTask(epubView, nextHtml);
        htt.execute();
    }

    @Override
    public void onLongPress(MotionEvent e) {
        mCurEpubWebView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                return true;
            }
        });
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    //使用AsyncTask加载前一个或后一个HTML文件
    private class LoadHtmlTask extends AsyncTask<Void, Void, Void> {

        private EpubWebView epubWebview;
        private String loadUrl;

        public LoadHtmlTask(EpubWebView epubWebview, String loadUrl) {
            this.epubWebview = epubWebview;
            this.loadUrl = loadUrl;
        }

        @Override
        protected Void doInBackground(Void... params) {
            epubWebview.loadUrl(loadUrl);
            return null;
        }
    }
}

