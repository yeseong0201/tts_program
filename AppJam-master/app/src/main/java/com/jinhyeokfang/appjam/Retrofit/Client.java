package com.jinhyeokfang.appjam.Retrofit;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    public static API retrofitService;
    public static final Client INSTANCE;

    public final API getRetrofitService() {
        return retrofitService;
    }

    public final void setRetrofitService(API api) {
        retrofitService = api;
    }

    static {
        INSTANCE = new Client();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient logger = new OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(20L, TimeUnit.SECONDS).writeTimeout(20L, TimeUnit.SECONDS).build();
        Retrofit retrofit = new retrofit2.Retrofit.Builder().baseUrl("http://202.182.123.138").addConverterFactory((Converter.Factory) GsonConverterFactory.create()).client(logger).build();
        retrofitService = retrofit.create(API.class);
    }
}
