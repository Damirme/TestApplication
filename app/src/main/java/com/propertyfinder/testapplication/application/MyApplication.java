package com.propertyfinder.testapplication.application;

import android.app.Activity;
import android.app.Application;

import com.propertyfinder.testapplication.core.ContextModule;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import okhttp3.OkHttpClient;

public class MyApplication extends Application {

    private MyApplicationComponent component;

    public static MyApplication get(Activity activity) {
        return (MyApplication) activity.getApplication();
    }

    @Inject
    Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMyApplicationComponent.builder()
                .contextModule(new ContextModule(this))
                .build();
    }


    public MyApplicationComponent component() {
        return component;
    }
}
