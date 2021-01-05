package com.example.beatbox.api;

import com.example.beatbox.model.BannerResponse;
import com.example.beatbox.model.HomeMessageResponse;
import com.example.beatbox.model.UserResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

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

    /**
     * @param username
     * @param password
     * @param rePassword
     * @return
     */
    @FormUrlEncoded
    @POST("user/register")
    Call<UserResponse> register(@Field("username") String username, @Field("password") String password, @Field("repassword") String rePassword);

    /**
     * @return
     */
    @GET("banner/json")
    Call<BannerResponse> getBanner();

    @GET("article/list/{pageId}/json")
    Call<HomeMessageResponse> homeMessgae(@Path("pageId") int pageId);
}
