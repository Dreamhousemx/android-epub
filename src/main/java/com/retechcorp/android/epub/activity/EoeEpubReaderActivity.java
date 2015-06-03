package com.retechcorp.android.epub.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.retechcorp.android.epub.R;
import com.retechcorp.android.epub.reader.parser.utils.DebugLog;

/**
 * Created by mx on 14/12/17.
 * 模仿页面
 */
// 按钮页面
public class EoeEpubReaderActivity extends Activity {

    private String source;

    /**
     * 第一次被创建时调用活动
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.epub_main);
        // 获取文件地址(小米测试机)
//        source = "/storage/emulated/0/AndroidBookReader/Books/170/Congo.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/171/Consent to kill_ a thriller - Vince Flynn.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/267/Eric - Terry Pratchett.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/270/Evil Under the Sun.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/270/Evil Under the Sun - Agatha Christie.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/271/Excession - Iain M. Banks.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/272/Exile's Return - Raymond E. Feist.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/273/Exiles_ a play in three acts - James Joyce.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/274/Extreme Measures_ A Thriller - Vince Flynn.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/275/Fablehaven - Brandon Mull.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/275/Fablehaven.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/277/Faefever - Karen Marie Moning.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/279/My pretty pony - Stephen King.epub";
//        source = "/storage/emulated/0/AndroidBookReader/Books/309/五年文集_edit.epub";
//        source = "/storage/emulated/0/文档/孙子兵法.epub";
//        source = "/storage/emulated/0/文档/iPhone 使用手册(适用于 iOS 8.3).epub";
//        source = "/storage/emulated/0/文档/Consent to kill_ a thriller - Vince Flynn.epub";
//        source = "/storage/emulated/0/文档/Evil Under the Sun - Agatha Christie.epub";
//        source = "/storage/emulated/0/文档/My pretty pony - Stephen King.epub";
//        source = "/storage/emulated/0/文档/第一章  失落的印度文明.epub";
//        source = "/storage/emulated/0/文档/打工旅行：一年实现一个梦_e8549a5f.epub";
//        source = "/storage/emulated/0/文档/茶叶战争.epub";
//        source = "/storage/emulated/0/文档/五年文集_edit.epub";
//        source = "/storage/emulated/0/文档/白银帝国.epub";
        source = "/storage/emulated/0/文档/第一章  失落的印度文明.epub";
        Button openEpub = (Button) findViewById(R.id.openEpub);

        openEpub.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String bookid = source.substring(0, source.lastIndexOf("/"));
                bookid = bookid.substring(bookid.lastIndexOf("/") + 1);
                DebugLog.e("bookid", ":" + bookid);
                Intent intent = new Intent();
                // 将文件地址传递到文件处理页面
                intent.putExtra("source", source);
                intent.putExtra("bookid", bookid);
                // 打开文件处理页面
                intent.setClass(EoeEpubReaderActivity.this, EpubReaderActivity.class);
                startActivity(intent);
//                Toast.makeText(EoeEpubReaderActivity.this, "当前的设备宽度是：" + UIHelper.getScreenWidth(EoeEpubReaderActivity.this)
//                        + "   屏幕的Dip是：" + UIHelper.getScreenWidthDip(EoeEpubReaderActivity.this), Toast.LENGTH_LONG).show();
            }
        });
    }
}
