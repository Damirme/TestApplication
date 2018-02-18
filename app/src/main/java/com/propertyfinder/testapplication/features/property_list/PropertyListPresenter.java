package com.propertyfinder.testapplication.features.property_list;

import com.propertyfinder.testapplication.data.api.PropertyDataManager;
import com.propertyfinder.testapplication.data.model.Property;
import com.propertyfinder.testapplication.data.model.SortType;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class PropertyListPresenter implements PropertyListContract.Presenter {
    private PropertyListContract.View propertyListView;
    private PropertyDataManager propertyDataManager;
    int pageNumber;

    public PropertyListPresenter(PropertyListContract.View propertyListView,
                                 PropertyDataManager propertyDataManager) {
        this.propertyListView = propertyListView;
        this.propertyDataManager = propertyDataManager;
    }

    private void loadProperty(SortType sortType) {
        if (pageNumber == 0)
            propertyListView.showLoading();
        propertyDataManager.getProperties(sortType != null ? sortType.getCode() : null, pageNumber)
                .subscribe(new Observer<List<Property>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        if (pageNumber == 0)
                            propertyListView.showLoading();
                    }

                    @Override
                    public void onNext(List<Property> propertyList) {
                        if (pageNumber == 0) {
                            propertyListView.hideLoading();
                            propertyListView.showList(propertyList);
                        } else {
                            propertyListView.showMore(propertyList);
                        }
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
        pageNumber = 0;
        loadProperty(null);
    }

    @Override
    public void getSortedList(SortType sortType) {
        pageNumber = 0;
        loadProperty(sortType);
    }

    @Override
    public void getMoreList(SortType sortType, int pageNumber) {
        this.pageNumber = pageNumber;
        loadProperty(sortType);
    }

}
