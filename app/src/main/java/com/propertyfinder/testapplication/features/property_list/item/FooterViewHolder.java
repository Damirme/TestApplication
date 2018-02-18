package com.propertyfinder.testapplication.features.property_list.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;


public class FooterViewHolder extends RecyclerView.ViewHolder {
    public FooterViewHolder(View itemView) {
        super(new ProgressBar(itemView.getContext()));
    }
}
