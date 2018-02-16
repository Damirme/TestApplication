package com.propertyfinder.testapplication.network;

import android.content.Context;

import com.propertyfinder.testapplication.application.ApplicationContext;
import com.propertyfinder.testapplication.application.MyApplicationScope;
import com.propertyfinder.testapplication.core.ContextModule;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module(includes = {NetworkModule.class, ContextModule.class})
public class PicassoModule {
    @Provides
    @MyApplicationScope
    public Picasso picasso(@ApplicationContext Context context) {
        return new Picasso.Builder(context)
                .build();
    }
}
