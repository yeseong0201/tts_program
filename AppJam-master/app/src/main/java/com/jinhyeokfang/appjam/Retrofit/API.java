package com.jinhyeokfang.appjam.Retrofit;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface API {
    @POST("/user/signin")
    @FormUrlEncoded
    Call<ResponseBody> logIn(@Field("id") String id, @Field("pw") String pw);

    @POST("/user/signup")
    @FormUrlEncoded
    Call<ResponseBody> signup(@Field("id") String id, @Field("pw") String pw);


    @POST("/post/create")
    @FormUrlEncoded
    Call<ResponseBody> addDairy(@Field("id") String id, @Field("title") String title, @Field("content") String content);

    @POST("/post/list")
    @FormUrlEncoded
    Call<ResponseBody> loadDairy(@Field("id") String id);

    @POST("/date/list")
    @FormUrlEncoded
    Call<ResponseBody> loadDate(@Field("id") String id, @Field("year") int year, @Field("month") int month, @Field("date") int date);

    @POST("/date/create")
    @FormUrlEncoded
    Call<ResponseBody> addDate(@Field("id") String id, @Field("title") String title, @Field("content") String content, @Field("year") int year, @Field("month") int month, @Field("date") int date);
}
