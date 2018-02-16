package com.propertyfinder.testapplication.property_list;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import javax.inject.Inject;

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

    @Provides
    @PropertyListActivityScope
    public RecyclerView.LayoutManager layoutManager(PropertyListActivity context){
        return new LinearLayoutManager(context);
    }

}
