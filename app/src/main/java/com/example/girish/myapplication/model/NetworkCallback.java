package com.example.girish.myapplication.model;

import retrofit2.Response;


public interface NetworkCallback<T> {
    public abstract void onSuccess(Response<T> response);

    public abstract void onFailure(Throwable throwable, int failureCode);
}
