package com.propertyfinder.testapplication.property_list.item;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.propertyfinder.testapplication.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PropertyViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.imvProp)
    ImageView imvProperty;

    @BindView(R.id.txvBathCount)
    TextView txvBathCount;

    @BindView(R.id.txvRoomCount)
    TextView txvRoomCount;

    public PropertyViewHolder(ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.prop_item, parent, false));
        ButterKnife.bind(this, itemView);
    }

    public void bind(Property property, Picasso picasso) {
        picasso.load(property.getThumbnail())
                .into(imvProperty);
        txvBathCount.setText(property.getBathrooms() + "");
        txvRoomCount.setText(property.getBedrooms() + "");
    }
}
