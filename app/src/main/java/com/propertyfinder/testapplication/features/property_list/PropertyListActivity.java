package com.propertyfinder.testapplication.features.property_list;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.R;
import com.propertyfinder.testapplication.core.BaseActivity;
import com.propertyfinder.testapplication.core.application.MyApplication;
import com.propertyfinder.testapplication.core.network.PropertyService;
import com.propertyfinder.testapplication.data.api.PropertyDataManager;
import com.propertyfinder.testapplication.data.api.response.PropertyList;
import com.propertyfinder.testapplication.data.api.response.PropertyResponse;
import com.propertyfinder.testapplication.data.model.Property;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class PropertyListActivity extends BaseActivity {
    private PropertyListActivityComponent component;

    @BindView(R.id.progressBar)
    View progressBar;

    @BindView(R.id.rcvList)
    RecyclerView recyclerView;


    @Inject
    PropertyService propertyService;
    @Inject
    PropertyAdapter propertyAdapter;
    @Inject
    RecyclerView.LayoutManager layoutManager;
    @Inject
    PropertyDataManager propertyDataManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_list);
        ButterKnife.bind(this);

        initUI();
        getProperties();
    }

    private void initUI() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(propertyAdapter);
    }

    private void getProperties() {
        propertyDataManager.getUsersRepositories(null, 0)
                .subscribe(new Observer<ImmutableList<Property>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        showLoading(true);
                    }

                    @Override
                    public void onNext(ImmutableList<Property> propertyList) {
                        showLoading(false);
                        setList(propertyList);
                    }

                    @Override
                    public void onError(Throwable e) {
                        showLoading(false);
                    }

                    @Override
                    public void onComplete() {
                        showLoading(false);
                    }
                });

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

    public void setList(ImmutableList<Property> propertyList) {
        propertyAdapter.setList(propertyList);
    }

    public void showLoading(boolean show) {
        progressBar.setVisibility(show ? View.VISIBLE : View.GONE);
//        recyclerView.setVisibility(!show ? View.VISIBLE : View.GONE);
    }
}