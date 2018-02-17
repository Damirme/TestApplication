package com.propertyfinder.testapplication.features.property_list;

import com.propertyfinder.testapplication.core.application.MyApplicationComponent;

import dagger.Component;

@PropertyListActivityScope
@Component(modules = PropertyListActivityModule.class, dependencies = MyApplicationComponent.class)
public interface PropertyListActivityComponent {
    void injectPropListActivity(PropertyListActivity propListActivity);
}
