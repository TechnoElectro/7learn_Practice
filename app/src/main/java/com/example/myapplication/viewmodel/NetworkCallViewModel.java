package com.example.myapplication.viewmodel;

import android.content.Context;

import com.example.myapplication.model.WordCount;
import com.example.myapplication.network.ApiService;
import com.example.myapplication.utils.TextHelper;

import java.util.List;

public class NetworkCallViewModel {
    private ApiService apiService;
    private UiCallBack uiCallBack;
    private TextHelper textHelper;

    public NetworkCallViewModel(Context context) {
        apiService = new ApiService(context);
        uiCallBack = (UiCallBack) context;

    }

    public void getCharAt10Position() {
        apiService.GetTextFromApi(new ApiService.OnResponseReceived() {
            @Override
            public void onRecipesReceived(String text) {
                uiCallBack.charAtPosition10CallBack(TextHelper.getCharAtPosition(text));
            }

            @Override
            public void onError(String message) {
                uiCallBack.onErrorDataReceive(message);
            }
        });
    }

    public void getMultipleCharAt10Position() {
        apiService.GetTextFromApi(new ApiService.OnResponseReceived() {
            @Override
            public void onRecipesReceived(String text) {
                uiCallBack.MultipleCharAt10CallBack(TextHelper.getMultipleOf(text));
            }

            @Override
            public void onError(String message) {
                uiCallBack.onErrorDataReceive(message);
            }
        });
    }

    public void getWordsCount() {
        apiService.GetTextFromApi(new ApiService.OnResponseReceived() {
            @Override
            public void onRecipesReceived(String text) {
                uiCallBack.getWordsCountCallBack(TextHelper.getWordCount(text));
            }

            @Override
            public void onError(String message) {
                uiCallBack.onErrorDataReceive(message);
            }
        });
    }

    public interface UiCallBack {
        void charAtPosition10CallBack(Character character);

        void MultipleCharAt10CallBack(char[] characterList);

        void getWordsCountCallBack(List<WordCount> wordCount);

        void onErrorDataReceive(String message);
    }

}
