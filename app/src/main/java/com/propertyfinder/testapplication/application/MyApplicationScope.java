package com.propertyfinder.testapplication.application;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by DamirMailybayev on 2/16/18.
 */

@Scope
@Retention(RetentionPolicy.CLASS)
public @interface ApplicationScope {
}
