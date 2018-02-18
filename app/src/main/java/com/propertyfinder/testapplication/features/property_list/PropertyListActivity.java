package com.propertyfinder.testapplication.features.property_list;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.R;
import com.propertyfinder.testapplication.core.BaseActivity;
import com.propertyfinder.testapplication.core.application.MyApplication;
import com.propertyfinder.testapplication.data.model.Property;
import com.propertyfinder.testapplication.data.model.SortType;
import com.propertyfinder.testapplication.features.property_list.sorting.SortAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PropertyListActivity extends BaseActivity implements PropertyListContract.View, PropertyAdapter.OnFooterAppearListener {
    private PropertyListActivityComponent component;

    int pageNumber = 0;
    SortType sortType;

    @BindView(R.id.progressBar)
    View progressBar;

    @BindView(R.id.rcvList)
    RecyclerView recyclerView;

    @BindView(R.id.fabSort)
    FloatingActionButton fabSort;


    @Inject
    PropertyListContract.Presenter propertyListPresenter;
    @Inject
    PropertyAdapter propertyAdapter;
    @Inject
    RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_list);
        ButterKnife.bind(this);

        initUI();
        propertyListPresenter.getList();
        fabSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                propertyListPresenter.clickSort();
            }
        });
    }

    private void initUI() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(propertyAdapter);
    }

    @Override
    public void initComponent() {
        component = DaggerPropertyListActivityComponent.builder()
                .myApplicationComponent(MyApplication.get(this).component())
                .propertyListActivityModule(new PropertyListActivityModule(this))
                .build();
        component.injectPropListActivity(this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
        recyclerView.setVisibility(!show ? View.VISIBLE : View.GONE);
    }

    public void showSortDialog() {
        final SortAdapter sortAdapter = new SortAdapter(this);
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle(R.string.choose_sort_type)
                .setAdapter(sortAdapter, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        sortType = sortAdapter.getItem(which);
                        pageNumber = 0;
                        propertyListPresenter.getSortedList(sortType);
                    }
                })
                .create();

        alertDialog.show();
    }

    @Override
    public void showLoading() {
        showLoading(true);
    }

    @Override
    public void hideLoading() {
        showLoading(false);
    }

    @Override
    public void showNoResult() {

    }

    @Override
    public void hideNoResult() {

    }

    @Override
    public void showList(List<Property> propertyList) {
        propertyAdapter.setList(propertyList);
    }

    @Override
    public void showMore(List<Property> propertyList) {
        propertyAdapter.addList(propertyList);
    }

    @Override
    public void OnFooterAppear() {
        propertyListPresenter.getMoreList(sortType, ++pageNumber);
    }
}
