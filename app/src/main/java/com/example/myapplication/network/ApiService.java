package com.example.myapplication.network;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.myapplication.utils.ExceptionMessageFactory;

import org.json.JSONObject;

public class ApiService {
    private RequestQueue requestQueue;

    public ApiService(Context context) {
        requestQueue = Volley.newRequestQueue(context);
        requestQueue.getCache().clear();
    }

    public void GetTextFromApi(final OnResponseReceived onResponseReceived) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                "https://techno-electro.com/Api.php",
                null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        response.optString("text");
                        onResponseReceived.onRecipesReceived(response.optString("text"));
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                onResponseReceived.onError(
                        ExceptionMessageFactory.parseException(error)
                );
            }
        });

        requestQueue.add(request);
    }

    public interface OnResponseReceived {
        void onRecipesReceived(String text);

        void onError(String message);
    }
}
