package com.propertyfinder.testapplication.core.network;


import com.propertyfinder.testapplication.data.api.response.PropertyList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PropertyService {
    @GET("mobileapi")
    Observable<PropertyList> getPropertyList(
            @Query("order") String order,
            @Query("page") int pageNumber
    );
}
