package com.propertyfinder.testapplication.core;

import android.content.Context;

import com.propertyfinder.testapplication.core.application.ApplicationContext;
import com.propertyfinder.testapplication.core.application.MyApplicationScope;

import dagger.Module;
import dagger.Provides;

@Module
@MyApplicationScope
public class ContextModule {
    private final Context context;

    public ContextModule(Context context) {
        this.context = context.getApplicationContext();
    }

    @Provides
    @MyApplicationScope
    @ApplicationContext
    public Context context(){
        return context;
    }
}
