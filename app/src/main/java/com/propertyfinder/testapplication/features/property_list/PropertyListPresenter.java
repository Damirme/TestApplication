package com.propertyfinder.testapplication.features.property_list;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.data.api.PropertyDataManager;
import com.propertyfinder.testapplication.data.model.Property;
import com.propertyfinder.testapplication.data.model.SortType;

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
        loadProperty(null, 0);
    }

    public void loadProperty(SortType sortType) {
        loadProperty(sortType.getCode(), 0);
    }


    private void loadProperty(String order, int pageNumber) {
        propertyListActivity.showLoading(true);
        propertyDataManager.getUsersRepositories(order, pageNumber)
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

    public void clickSort() {
        propertyListActivity.showSortDialog();
    }
}
