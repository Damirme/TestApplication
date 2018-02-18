package com.propertyfinder.testapplication.features.property_list;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.data.model.Property;
import com.propertyfinder.testapplication.data.model.SortType;

public interface PropertyListContract {
    interface View {
        public void showLoading();
        public void hideLoading();
        public void showNoResult();
        public void hideNoResult();
        public void showList(ImmutableList<Property> propertyList);
        public void showMore(ImmutableList<Property> propertyList);
        public void showSortDialog();
    }
    interface Presenter{
        void getList();
        void getSotedList(SortType sortType);
        void getMoreList();
        void clickSort();
    }
}
