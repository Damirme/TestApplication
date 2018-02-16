package com.propertyfinder.testapplication.property_list;

import android.content.Context;

import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class PropertyListActivityModule {

    private final PropertyListActivity propListActivity;

    public PropertyListActivityModule(PropertyListActivity propListActivity) {
        this.propListActivity = propListActivity;
    }

    @Provides
    @PropertyListActivityScope
    public PropertyListActivity propListActivity() {
        return propListActivity;
    }

}
