package com.propertyfinder.testapplication.property_list;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.propertyfinder.testapplication.R;
import com.propertyfinder.testapplication.application.MyApplication;
import com.propertyfinder.testapplication.network.PropertyService;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyListActivity extends AppCompatActivity {


    Call<PropertyList> propCall;

    private PropertyListActivityComponent component;

    @BindView(R.id.rcvList)
    RecyclerView recyclerView;

    @Inject
    PropertyService propertyService;

//    @Inject
//    PropertyAdapter propertyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prop_list);
        ButterKnife.bind(this);

        component = DaggerPropertyListActivityComponent.builder()
                .myApplicationComponent(MyApplication.get(this).component())
                .propertyListActivityModule( new PropertyListActivityModule(this))
                .build();

        component.injectPropListActivity(this);

        propCall = propertyService.getPropertyList(null, 0);
        propCall.enqueue(new Callback<PropertyList>() {
            @Override
            public void onResponse(Call<PropertyList> call, Response<PropertyList> response) {
//                propertyAdapter.populate(response.body().getmResult());
            }

            @Override
            public void onFailure(Call<PropertyList> call, Throwable t) {
                Toast.makeText(getBaseContext(), R.string.errorOccured, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(propCall != null) {
            propCall.cancel();
        }
    }
}
