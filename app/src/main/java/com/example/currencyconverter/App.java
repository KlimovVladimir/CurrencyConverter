package com.example.currencyconverter;

import android.app.Application;
import android.util.Log;

import com.example.currencyconverter.json.Message;
import com.example.currencyconverter.json.MessagesApi;
import com.example.currencyconverter.json.Valutes;

import java.util.ArrayList;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private static App instance;
    private Retrofit retrofit;
    private MessagesApi messagesApi;
    private Call<Valutes> messages;

    private static final String TAG = "###DEBUG###";

    public Valutes response_json = new Valutes();
    Map<String,Message> valute;

    public boolean initFinish = false;

    public static App getInstance() {
        return instance;
    }
    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.cbr-xml-daily.ru/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        messagesApi = retrofit.create(MessagesApi.class);
        messages = messagesApi.messages();

        messages.enqueue(new Callback<Valutes>() {
            @Override
            public void onResponse(Call<Valutes> call, Response<Valutes> response) {
                response_json.setValute(response.body().getValute());
                valute = response_json.getValute();
                if (response.isSuccessful()) {
                    Log.i(TAG, "Success " + Integer.toString(response.code()));
                } else {
                    Log.i(TAG, "Fail " + Integer.toString(response.code()));
                }
                init();
                initFinish = true;
            }

            @Override
            public void onFailure(Call<Valutes> call, Throwable t) {
                Log.i(TAG, "can't open URL" + t);
            }
        });
    }

    public void init() {

    }
}
