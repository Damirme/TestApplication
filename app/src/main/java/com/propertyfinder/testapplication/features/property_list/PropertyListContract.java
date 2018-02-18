package com.propertyfinder.testapplication.features.property_list;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.data.model.Property;
import com.propertyfinder.testapplication.data.model.SortType;

import java.util.List;

public interface PropertyListContract {
    interface View {
        public void showLoading();
        public void hideLoading();
        public void showNoResult();
        public void hideNoResult();
        public void showList(List<Property> propertyList);
        public void showMore(List<Property> propertyList);
        public void showSortDialog();
    }
    interface Presenter{
        void getList();
        void getSortedList(SortType sortType);
        void getMoreList(SortType sortType, int pageNumber);
        void clickSort();
    }
}
