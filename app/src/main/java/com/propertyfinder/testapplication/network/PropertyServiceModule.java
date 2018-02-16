package com.propertyfinder.testapplication.network;

import com.propertyfinder.testapplication.application.MyApplicationScope;
import com.propertyfinder.testapplication.property_list.PropertyListActivityScope;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = NetworkModule.class)
public class PropertyServiceModule {

    @Provides
    @MyApplicationScope
    public PropertyService propertyService(Retrofit retrofit){
        return retrofit.create(PropertyService.class);
    }
}
