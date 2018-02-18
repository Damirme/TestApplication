package com.propertyfinder.testapplication.features.property_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.data.model.Property;
import com.propertyfinder.testapplication.features.property_list.item.PropertyViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;


public class PropertyAdapter extends RecyclerView.Adapter {

    List<Property> list;
    private final Context context;
    private final Picasso picasso;

    @Inject
    public PropertyAdapter(PropertyListActivity context, Picasso picasso) {
        this.context = context;
        this.picasso = picasso;
        this.list = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PropertyViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((PropertyViewHolder) holder).bind(list.get(position), picasso);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Property> properties) {
        list = properties;
        notifyDataSetChanged();
    }

    public void addList(ImmutableList<Property> propertyList) {
        list.addAll(propertyList);
        notifyDataSetChanged();
    }
}
