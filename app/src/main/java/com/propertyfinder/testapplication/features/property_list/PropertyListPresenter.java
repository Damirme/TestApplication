package com.propertyfinder.testapplication.features.property_list;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.data.api.PropertyDataManager;
import com.propertyfinder.testapplication.data.model.Property;
import com.propertyfinder.testapplication.data.model.SortType;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class PropertyListPresenter implements PropertyListContract.Presenter {
    private PropertyListContract.View propertyListView;
    private PropertyDataManager propertyDataManager;

    public PropertyListPresenter(PropertyListContract.View propertyListView,
                                 PropertyDataManager propertyDataManager) {
        this.propertyListView = propertyListView;
        this.propertyDataManager = propertyDataManager;
    }

    private void loadProperty(String order, int pageNumber) {
        propertyListView.showLoading();
        propertyDataManager.getUsersRepositories(order, pageNumber)
                .subscribe(new Observer<ImmutableList<Property>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        propertyListView.showLoading();
                    }

                    @Override
                    public void onNext(ImmutableList<Property> propertyList) {
                        propertyListView.hideLoading();
                        propertyListView.showList(propertyList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        propertyListView.hideLoading();
                        Timber.d(e);
                    }

                    @Override
                    public void onComplete() {
                        propertyListView.hideLoading();
                    }
                });
    }

    public void clickSort() {
        propertyListView.showSortDialog();
    }

    @Override
    public void getList() {
        loadProperty(null, 0);
    }

    @Override
    public void getSotedList(SortType sortType) {
        loadProperty(sortType.getCode(), 0);
    }

    @Override
    public void getMoreList() {

    }
}
