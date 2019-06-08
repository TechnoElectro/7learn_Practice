package com.example.myapplication.utils;

import android.content.Context;
import android.graphics.Typeface;
import java.util.Locale;

public class FontGuid {

private  Typeface mEnglish;
private  Typeface mFarsi;

private static FontGuid fontGuid_instance = null;
    public static FontGuid getInstance(Context context) {
        if(fontGuid_instance == null)
            fontGuid_instance = new FontGuid(context);
        return  fontGuid_instance;
    }

    public FontGuid(Context context) {
        mEnglish = Typeface.createFromAsset(context.getAssets(), "fonts/english_bold.ttf");
        mFarsi = Typeface.createFromAsset(context.getAssets(), "fonts/farsi_bold.ttf");
    }

    public  Typeface getFont(){

        if (Locale.getDefault().getLanguage().equals("en")) {
            return mEnglish;

        } else if (Locale.getDefault().getLanguage().equals("fa")) {
            return mFarsi;
        }
        else {
            return mEnglish;
        }
    }
}
