package com.example.myapplication.utils;

import android.graphics.Color;

public class ColorHelper {
    public static int getColor(int i){

        switch (i) {
            case 0:
                return Color.rgb(160, 232, 252);
            case 1:
                return Color.rgb(160, 252, 238);
            case 2:
                return Color.rgb(160, 252, 197);
            case 3:
                return Color.rgb(160, 252, 188);
            case 4:
                return Color.rgb(160, 252, 176);
            case 5:
                return Color.rgb(160, 252, 167);
            case 6:
                return Color.rgb(179, 252, 160);
            case 7:
                return Color.rgb(199, 253, 159);
            case 8:
                return Color.rgb(222, 253, 159);
            case 9:
                return Color.rgb(241, 253, 159);
            case 10:
                return Color.rgb(253, 241, 159);
            case 11:
                return Color.rgb(254, 225, 158);
            case 12:
                return Color.rgb(254, 208, 158);
            case 13:
                return Color.rgb(254, 187, 158);
            default:
                return Color.rgb(254, 158, 158);
        }
    }
}