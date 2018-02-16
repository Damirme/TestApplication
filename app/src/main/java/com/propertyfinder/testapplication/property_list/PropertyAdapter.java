package com.propertyfinder.testapplication.property_list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.propertyfinder.testapplication.R;
import com.propertyfinder.testapplication.property_list.item.Property;
import com.propertyfinder.testapplication.property_list.item.PropertyViewHolder;
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

    public void populate(List<Property> properties) {
        list = properties;
        notifyDataSetChanged();
    }
}
