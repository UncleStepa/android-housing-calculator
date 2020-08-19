//package com.example.housing_calculator.utils;
//
//import okhttp3.OkHttpClient;
//import retrofit2.Retrofit;
//import retrofit2.converter.gson.GsonConverterFactory;
//
//public class RequestControllers {
//
//    String API_BASE_URL = "http://localhost:8080/services/testimony/";
//
//    OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//
//    Retrofit.Builder builder =
//            new Retrofit.Builder()
//                    .baseUrl(API_BASE_URL)
//                    .addConverterFactory(
//                            GsonConverterFactory.create()
//                    );
//
//    Retrofit retrofit =
//            builder
//                    .client(
//                            httpClient.build()
//                    )
//                    .build();
//
//    GitHubClient client =  retrofit.create(GitHubClient.class);
//
//}