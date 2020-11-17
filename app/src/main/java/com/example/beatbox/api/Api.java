package com.example.beatbox.api;

import com.example.beatbox.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * @author STY
 */
public interface Api {
    /**
     * @param username
     * @param password
     * @return
     * @descrabtion 登录接口
     */
    @FormUrlEncoded
    @POST("user/login")
    Call<UserResponse> login(@Field("username") String username, @Field("password") String password);

    @FormUrlEncoded
    @POST("user/register")
    Call<UserResponse> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String rePassword);
}
