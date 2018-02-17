package com.propertyfinder.testapplication.data.api.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PropertyList {

    @SerializedName("total")
    int mTotal;

    @SerializedName("res")
    List<PropertyResponse> mResult;

    public int getTotal() {
        return mTotal;
    }

    public List<PropertyResponse> getResult() {
        return mResult;
    }
}
