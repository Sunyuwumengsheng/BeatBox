package com.example.beatbox.repository;

import android.annotation.SuppressLint;
import android.os.Build;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.beatbox.api.Api;
import com.example.beatbox.callbacks.HttpCallback;
import com.example.beatbox.model.UserRequest;
import com.example.beatbox.model.UserResponse;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author STY
 * @description 用户操作类
 */
public class UserRepository {

    private static String TAG = "UserRepository";


    private Api api;

    public UserRepository( Api api) {
        this.api = api;
    }

    /**
     * @description登录
     * @param request
     * @param callback
     */
    public void login(UserRequest request, final HttpCallback<UserResponse> callback) {
        Call<UserResponse> call = api.login(request.getUsername(), request.getPassword());
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@Nullable Call<UserResponse> call,  @Nullable  Response<UserResponse> response) {
                callback.success(Objects.requireNonNull(response,"response为空").body());
                Log.d(TAG, Objects.requireNonNull(response.headers().get("Set-Cookie")));
            }

            @Override
            public void onFailure(@Nullable Call<UserResponse> call, @Nullable Throwable t) {
                callback.failure(t);
            }
        });
    }

    /**
     * @description注册
     * @param request
     * @param callback
     */
    public void register(UserRequest request,final HttpCallback<UserResponse> callback){
        Call<UserResponse> call = api.register(request.getUsername(),request.getPassword(),request.getRePassword());
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(@NonNull Call<UserResponse> call, @NonNull Response<UserResponse> response) {
                callback.success(Objects.requireNonNull(response,"response为空").body());
                Log.d(TAG, Objects.requireNonNull(response.headers().get("Set-Cookie")));
            }

            @Override
            public void onFailure(@NonNull Call<UserResponse> call, @NonNull Throwable t) {
                callback.failure(t);
            }
        });

    }


}
