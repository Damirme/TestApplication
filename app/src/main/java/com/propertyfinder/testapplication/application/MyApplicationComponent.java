package com.propertyfinder.testapplication.application;

import android.app.Application;
import android.content.Context;

import com.propertyfinder.testapplication.core.ActivityModule;
import com.propertyfinder.testapplication.network.NetworkModule;
import com.propertyfinder.testapplication.network.PicassoModule;
import com.propertyfinder.testapplication.network.PropertyService;
import com.propertyfinder.testapplication.network.PropertyServiceModule;
import com.squareup.picasso.Picasso;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

@MyApplicationScope
@Component(modules = {PropertyServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface MyApplicationComponent {

    PropertyService getPropertyService();

    Picasso getPicasso();
}
