package com.propertyfinder.testapplication.features.property_list;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.propertyfinder.testapplication.core.network.PropertyService;
import com.propertyfinder.testapplication.data.api.PropertyDataManager;

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

    @Provides
    @PropertyListActivityScope
    public PropertyDataManager propertyDataManager(PropertyService propertyService){
        return new PropertyDataManager(propertyService);
    }

    @Provides
    @PropertyListActivityScope
    public PropertyListPresenter propertyListPresenter(PropertyListActivity propertyListActivity, PropertyDataManager propertyDataManager){
        return new PropertyListPresenter(propertyListActivity, propertyDataManager);
    }

}
