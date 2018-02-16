package com.propertyfinder.testapplication.property_list;

import com.propertyfinder.testapplication.application.MyApplicationComponent;

import dagger.Component;

@PropertyListActivityScope
@Component(modules = PropertyListActivityModule.class, dependencies = MyApplicationComponent.class)
public interface PropertyListActivityComponent {
    void injectPropListActivity(PropertyListActivity propListActivity);
}
