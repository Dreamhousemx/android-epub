package com.retechcorp.android.epub.utils;

import android.content.Context;

public class UIHelper {

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int getScreenWidthDip(Context context) {
        int widthPx = UIHelper.getScreenWidth(context);
        int widthDip = UIHelper.px2dip(context, widthPx);
        return widthDip;
    }

    public static int getScreenHeightDip(Context context) {
        int heightPx = UIHelper.getScreenHeight(context);
        int heightDip = UIHelper.px2dip(context, heightPx);
        return heightDip;
    }

    /**
     * 获取设备密度
     *
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().density;
        } else {
            return 1.0f;
        }
    }

    /**
     * 获取设备密度DPI
     *
     * @param context
     * @return
     */
    public static int getDensityDpi(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().densityDpi;
        } else {
            return 120;
        }
    }

    /**
     * 获取屏幕宽度
     *
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        } else {
            return 0;
        }
    }

    /**
     * 获取屏幕高度
     *
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        if (context != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        } else {
            return 0;
        }
    }

}
