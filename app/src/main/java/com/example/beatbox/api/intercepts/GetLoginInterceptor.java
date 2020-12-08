package com.example.beatbox.api.intercepts;

import androidx.annotation.NonNull;
import com.example.beatbox.global.GlobalData;
import com.example.beatbox.mmkv.MmkvTools;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;

public class GetLoginInterceptor implements Interceptor {
    @NonNull
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Builder builder = request.newBuilder();
        String cookie = MmkvTools.getInstance().getString(GlobalData.COOKIE,null);
        if (cookie != null){
            builder.addHeader("cookie",cookie);
        }

        return chain.proceed(builder.build());
    }
}
