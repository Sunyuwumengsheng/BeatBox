package com.example.beatbox.repository;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.beatbox.api.Api;
import com.example.beatbox.callbacks.HttpCallback;
import com.example.beatbox.model.BannerResponse;
import com.example.beatbox.model.HomeMessageResponse;
import com.google.gson.Gson;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author STY
 */
public class HomeFragRepository {
    private static final String TAG = "HomeFragRepository";

    private Api api;

    public HomeFragRepository(Api api){
        this.api = api;
    }

    public void getBanner(final HttpCallback<BannerResponse> callback){
        Call<BannerResponse> call = api.getBanner();
        call.enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(@NonNull Call<BannerResponse> call, @NonNull Response<BannerResponse> response) {
                Log.d(TAG,new Gson().toJson(response.body()));
                if (Objects.requireNonNull(response.body()).errorCode == 0){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<BannerResponse> call, @NonNull Throwable t) {
                callback.failure(t);
            }
        });
    }

    public void getMessage(int pageId, final HttpCallback<HomeMessageResponse> callback){
        Call<HomeMessageResponse> call = api.homeMessgae(pageId);
        call.enqueue(new Callback<HomeMessageResponse>() {
            @Override
            public void onResponse(@NonNull Call<HomeMessageResponse> call, @NonNull Response<HomeMessageResponse> response) {
                if (Objects.requireNonNull(response.body()).errorCode == 0){
                    callback.success(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<HomeMessageResponse> call, @NonNull Throwable t) {

            }
        });

    }
}
