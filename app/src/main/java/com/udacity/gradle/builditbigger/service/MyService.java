package com.udacity.gradle.builditbigger.service;

import retrofit2.Call;
import retrofit2.http.POST;

public interface MyService {
    @POST("tellJoke")
    Call<Joke> getJoke();
}
