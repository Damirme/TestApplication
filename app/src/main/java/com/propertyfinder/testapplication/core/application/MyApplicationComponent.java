package com.propertyfinder.testapplication.core.application;

import com.propertyfinder.testapplication.core.ActivityModule;
import com.propertyfinder.testapplication.core.network.NetworkModule;
import com.propertyfinder.testapplication.core.network.PicassoModule;
import com.propertyfinder.testapplication.core.network.PropertyService;
import com.propertyfinder.testapplication.core.network.PropertyServiceModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

@MyApplicationScope
@Component(modules = {PropertyServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface MyApplicationComponent {

    PropertyService getPropertyService();

    Picasso getPicasso();
}
