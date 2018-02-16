package com.propertyfinder.testapplication.property_list;

import com.google.gson.annotations.SerializedName;
import com.propertyfinder.testapplication.property_list.item.Property;

import java.util.List;

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
