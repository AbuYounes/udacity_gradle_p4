package com.udacity.gradle.builditbigger.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {
    public static final String ENDPOINT = "http://192.168.1.7:8080/_ah/api/myApi/v1/";
    private static MyService sService;

    public static MyService get() {
        if (sService == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            sService = retrofit.create(MyService.class);
        }
        return sService;
    }
}
