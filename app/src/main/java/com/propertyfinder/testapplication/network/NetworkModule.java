package com.propertyfinder.testapplication.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.propertyfinder.testapplication.application.MyApplicationScope;
import com.propertyfinder.testapplication.core.Constants;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @MyApplicationScope
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();

        return gsonBuilder.create();
    }

    @Provides
    @MyApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson){
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();
    }

    @Provides
    @MyApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor logginInterceptor){
        return new OkHttpClient.Builder()
                .addInterceptor(logginInterceptor)
                .build();
    }

    @Provides
    @MyApplicationScope
    public HttpLoggingInterceptor httpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
