package com.propertyfinder.testapplication.data.api;

import android.util.Log;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.core.network.PropertyService;
import com.propertyfinder.testapplication.data.api.response.PropertyList;
import com.propertyfinder.testapplication.data.api.response.PropertyResponse;
import com.propertyfinder.testapplication.data.model.Property;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
/**
 * Manipulating Property data
 * */
public class PropertyDataManager {
    PropertyService mPropertyService;

    public PropertyDataManager(PropertyService propertyService) {
        mPropertyService = propertyService;
    }

    /**
     * Convert data from response to the data that app needs
     * */
    public Observable<ImmutableList<Property>> getUsersRepositories(String order, int pageNumber) {
        return mPropertyService.getPropertyList(order, pageNumber)
                .map(new Function<PropertyList, ImmutableList<Property>>() {
                    @Override
                    public ImmutableList<Property> apply(PropertyList propertyListResponse) {
                        final ImmutableList.Builder<Property> listBuilder = ImmutableList.builder();
                        for (PropertyResponse propertyResponse : propertyListResponse.getResult()) {
                            Property property = new Property();
                            property.id = propertyResponse.getId();
                            property.imageUrl = propertyResponse.getThumbnail();
                            property.bathroomCount = propertyResponse.getBathrooms();
                            property.bedroomCount = propertyResponse.getBedrooms();
                            listBuilder.add(property);
                        }
                        return listBuilder.build();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
