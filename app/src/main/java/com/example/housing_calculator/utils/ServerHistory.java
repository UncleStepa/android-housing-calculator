package com.example.housing_calculator.utils;

import com.example.housing_calculator.model.responses.ResponseSaveTestimony;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ServerHistory {
    @GET("services/testimony/get/old/testimony/{date}")
    public Call<ResponseSaveTestimony> getHistoryTestimony(@Path("date") String date);
}
