package com.example.currencyconverter.json;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MessagesApi {
    @GET("daily_json.js")
    Call<Valutes> messages();
}
