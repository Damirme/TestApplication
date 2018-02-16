package com.propertyfinder.testapplication.property_list.item;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by DamirMailybayev on 2/17/18.
 */

public class PropertyList {

    @SerializedName("total")
    int mTotal;

    @SerializedName("res")
    List<Property> mResult;

    public int getmTotal() {
        return mTotal;
    }

    public List<Property> getmResult() {
        return mResult;
    }
}
