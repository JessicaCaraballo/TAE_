package com.example.jessi.tae;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Load on 26/02/2018.
 */

public class RetrofitAdapter {

    Retrofit retrofit;

    public RetrofitAdapter(){
    }
    public Retrofit getAdapter(){
        OkHttpClient client = new OkHttpClient();
        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder()
                //.baseUrl("http://10.0.2.2/TAE_WS/")
                .baseUrl("http://wstae.000webhostapp.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
    /*
    public Retrofit getAdapter(){
        retrofit = new Retrofit.Builder()
                .baseUrl("http://worldclockapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    */
}
