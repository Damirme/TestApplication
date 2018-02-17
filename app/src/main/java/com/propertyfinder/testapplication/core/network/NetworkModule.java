package com.propertyfinder.testapplication.core.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.propertyfinder.testapplication.core.Constants;
import com.propertyfinder.testapplication.core.application.MyApplicationScope;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

@Module
public class NetworkModule {

    @Provides
    @MyApplicationScope
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();

        return gsonBuilder.create();
    }

    @Provides
    @MyApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @MyApplicationScope
    public OkHttpClient okHttpClient(HttpLoggingInterceptor logginInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(logginInterceptor)
                .build();
    }

    @Provides
    @MyApplicationScope
    public HttpLoggingInterceptor httpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Timber.tag("network").d(message);
            }
        })
                .setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
