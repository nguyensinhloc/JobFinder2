package com.example.jobfindernew;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
public interface AuthApi {

    @FormUrlEncoded
    @POST("login") // Đặt đúng endpoint của bạn
    Call<User> login(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register") // Đặt đúng endpoint của bạn
    Call<Void> register(@Field("email") String email, @Field("password") String password);
}
