package com.example.beatbox.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtil {

    private static final String BASE_URL = "https://www.wanandroid.com";

    private static HttpUtil httpUtil;

    private Retrofit retrofit;

    private HttpUtil(){
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized HttpUtil getInstance(){
        if (httpUtil == null){
            httpUtil = new HttpUtil();
        }
        return httpUtil;
    }

    public Api getApi(){
        return retrofit.create(Api.class);
    }
}
