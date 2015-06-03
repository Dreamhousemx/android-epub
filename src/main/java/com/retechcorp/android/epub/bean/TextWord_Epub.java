package com.retechcorp.android.epub.bean;

/**
 * Created by mx on 14/12/17.
 * 每页文本
 */
public class TextWord_Epub {

    private String text;

    private float textX;

    private float textY;

    private int charNum;

    public TextWord_Epub() {
    }

    public TextWord_Epub(String text, float textX, float textY, int charNum) {
        this.text = text;
        this.textX = textX;
        this.textY = textY;
        this.charNum = charNum;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getTextX() {
        return textX;
    }

    public void setTextX(float textX) {
        this.textX = textX;
    }

    public float getTextY() {
        return textY;
    }

    public void setTextY(float textY) {
        this.textY = textY;
    }

    public int getCharNum() {
        return charNum;
    }

    public void setCharNum(int charNum) {
        this.charNum = charNum;
    }
}
