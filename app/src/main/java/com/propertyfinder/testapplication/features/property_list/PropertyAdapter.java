package com.propertyfinder.testapplication.features.property_list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.google.common.collect.ImmutableList;
import com.propertyfinder.testapplication.data.model.Property;
import com.propertyfinder.testapplication.features.property_list.item.FooterViewHolder;
import com.propertyfinder.testapplication.features.property_list.item.PropertyViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class PropertyAdapter extends RecyclerView.Adapter {
    public interface OnFooterAppearListener {
        public void OnFooterAppear();
    }

    List<Property> list;
    Picasso picasso;
    OnFooterAppearListener onLoadMoreAppear;

    public static class ViewType {
        static final int ITEM_VIEW = 0;
        static final int LOADER_VIEW = 1;
    }

    public PropertyAdapter(OnFooterAppearListener onLoadMoreAppear, Picasso picasso) {
        this.onLoadMoreAppear = onLoadMoreAppear;
        this.picasso = picasso;
        this.list = new ArrayList<>();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case ViewType.ITEM_VIEW:
                return new PropertyViewHolder(parent);
            case ViewType.LOADER_VIEW:
                return new FooterViewHolder(parent);
            default:
                return new PropertyViewHolder(parent);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PropertyViewHolder) {
            ((PropertyViewHolder) holder).bind(list.get(position), picasso);
        }
        if (holder instanceof FooterViewHolder) {
            onLoadMoreAppear.OnFooterAppear();
        }
    }

    @Override
    public int getItemCount() {
        return list.size() > 0 ? list.size() + 1 : list.size(); //if list is not empty add a footer
    }


    @Override
    public int getItemViewType(int position) {
        if (position == list.size() && position != 0) {
            return ViewType.LOADER_VIEW;
        }
        return ViewType.ITEM_VIEW;
    }

    public void setList(List<Property> properties) {
        list = properties;
        notifyDataSetChanged();
    }

    public void addList(List<Property> propertyList) {
        list.addAll(propertyList);
        notifyDataSetChanged();
    }
}
