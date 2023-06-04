package com.example.movies;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiFactory {

    private static final String BASE_URL = "https://api.kinopoisk.dev/";

    private static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .build();

    //При первом обращении к этой переменной она будет инициализиривана. А затем будет браться уже готовая
    //Это еще одна реализация паттерна Singletone
    //Так можно сделать, когда метод не требует передачи каких-то параметров.
    public static final ApiService apiService = retrofit.create(ApiService.class);
}
