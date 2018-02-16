package com.propertyfinder.testapplication.property_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.propertyfinder.testapplication.property_list.item.Property;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;


public class PropertyAdapter extends RecyclerView.Adapter {

    List<Property> list;

    @Inject
    Picasso picasso;

    @Inject
    Context context;

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void populate(List<Property> properties) {
        list = properties;
        notifyDataSetChanged();
    }
}
