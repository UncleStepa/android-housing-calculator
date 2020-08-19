package com.example.housing_calculator.utils;


import com.example.housing_calculator.model.requests.RequestSaveTestimony;
import com.example.housing_calculator.model.responses.ResponseSaveTestimony;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Server {
    @POST("save")
    Call <ResponseSaveTestimony> saveTestimony(@Body RequestSaveTestimony requestSaveTestimony);

}