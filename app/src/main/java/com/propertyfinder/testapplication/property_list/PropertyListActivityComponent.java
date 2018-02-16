package com.propertyfinder.testapplication.property_list;

import com.propertyfinder.testapplication.application.MyApplicationComponent;
import com.propertyfinder.testapplication.property_list.PropertyListActivityScope;

import javax.inject.Scope;

import dagger.Component;

/**
 * Created by DamirMailybayev on 2/16/18.
 */

@PropertyListActivityScope
@Component(modules = PropertyModule.class, dependencies = MyApplicationComponent.class)
public interface PropListActivityComponent {
    void injectPropListActivity(PropListActivity propListActivity);

}
