package com.example.myapplication.utils;

import java.util.concurrent.TimeoutException;

public class ExceptionMessageFactory {

    public static String parseException(Exception e) {
        if (e instanceof TimeoutException) {
            return "سرعت اینترنت شما کم است ";
        } else if (e instanceof NullPointerException) {
            return "اختلال در دریافت اطلاعات";
        } else {
            return "دسترسی به اینترنت وجود ندارد";
        }
    }
}
