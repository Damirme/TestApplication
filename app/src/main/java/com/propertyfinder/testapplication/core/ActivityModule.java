package com.propertyfinder.testapplication.core;

import android.app.Activity;
import android.content.Context;

import com.propertyfinder.testapplication.core.application.MyApplicationScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private final Activity context;

    public ActivityModule(Activity context) {
        this.context = context;
    }

    @Provides
    @MyApplicationScope
    @Named("activity_context")
    public Context context() {
        return context;
    }
}
