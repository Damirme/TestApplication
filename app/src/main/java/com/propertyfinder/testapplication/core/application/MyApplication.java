package com.propertyfinder.testapplication.core.application;

import android.app.Activity;
import android.app.Application;

import com.propertyfinder.testapplication.core.ContextModule;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

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
