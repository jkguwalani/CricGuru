package com.example.girish.myapplication.network;

import com.example.girish.myapplication.model.BasicRequest;
import com.example.girish.myapplication.model.BasicResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    @POST("/")
    Call<BasicResponse> getResult(@Body BasicRequest body);
}
