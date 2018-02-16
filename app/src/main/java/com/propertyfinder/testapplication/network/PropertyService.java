package com.propertyfinder.testapplication.network;

import com.propertyfinder.testapplication.property_list.PropertyList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PropertyService {
    @GET("mobileapi")
    Call<PropertyList> getPropertyList(
            @Query("order") String order,
            @Query("page") int pageNumber
    );
}
