package com.propertyfinder.testapplication.features.property_list;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.data.api.PropertyDataManager;
import com.propertyfinder.testapplication.data.model.Property;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class PropertyListPresenter {
    private PropertyListActivity propertyListActivity;
    private PropertyDataManager propertyDataManager;

    public PropertyListPresenter(PropertyListActivity propertyListActivity,
                                             PropertyDataManager propertyDataManager) {
        this.propertyListActivity = propertyListActivity;
        this.propertyDataManager = propertyDataManager;
    }

    public void loadProperty() {
        propertyListActivity.showLoading(true);
        propertyDataManager.getUsersRepositories(null, 0)
                .subscribe(new Observer<ImmutableList<Property>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        propertyListActivity.showLoading(true);
                    }

                    @Override
                    public void onNext(ImmutableList<Property> propertyList) {
                        propertyListActivity.showLoading(false);
                        propertyListActivity.setList(propertyList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        propertyListActivity.showLoading(false);
                        Timber.d(e);
                    }

                    @Override
                    public void onComplete() {
                        propertyListActivity.showLoading(false);
                    }
                });

    }
}
