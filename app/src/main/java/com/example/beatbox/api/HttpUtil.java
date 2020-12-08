package com.example.beatbox.api;

import com.example.beatbox.api.intercepts.GetLoginInterceptor;
import com.example.beatbox.api.intercepts.SaveLoginInterceptor;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpUtil {

    private static final String BASE_URL = "https://www.wanandroid.com";

    private static HttpUtil httpUtil;

    private Retrofit retrofit;

    private HttpUtil(){

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new GetLoginInterceptor())
                .addInterceptor(new SaveLoginInterceptor())
                .build();
        retrofit = new Retrofit.Builder()
                .client(client)
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
