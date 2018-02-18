package com.propertyfinder.testapplication.data.api;

import com.propertyfinder.testapplication.core.network.PropertyService;
import com.propertyfinder.testapplication.data.api.response.PropertyList;
import com.propertyfinder.testapplication.data.api.response.PropertyResponse;
import com.propertyfinder.testapplication.data.model.Property;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Manipulating Property data
 */
public class PropertyDataManager {
    PropertyService mPropertyService;

    public PropertyDataManager(PropertyService propertyService) {
        mPropertyService = propertyService;
    }

    /**
     * Convert data from response to the data that app needs
     */
    public Observable<List<Property>> getProperties(String order, int pageNumber) {
        return mPropertyService.getPropertyList(order, pageNumber)
                .map(new Function<PropertyList, List<Property>>() {
                    @Override
                    public List<Property> apply(PropertyList propertyListResponse) {
                        List<Property> properties = new ArrayList<>();
                        for (PropertyResponse propertyResponse : propertyListResponse.getResult()) {
                            Property property = new Property();
                            property.id = propertyResponse.getId();
                            property.imageUrl = propertyResponse.getThumbnail();
                            property.bathroomCount = propertyResponse.getBathrooms();
                            property.bedroomCount = propertyResponse.getBedrooms();
                            properties.add(property);
                        }
                        return properties;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

}
