package com.propertyfinder.testapplication.features.property_list.item;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.propertyfinder.testapplication.R;
import com.propertyfinder.testapplication.data.model.Property;
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
        picasso.load(property.imageUrl)
                .into(imvProperty);
        txvBathCount.setText(imvProperty.getContext().getString(R.string.property_item_bathroom_count, property.bathroomCount));
        txvRoomCount.setText(imvProperty.getContext().getString(R.string.property_item_bedroom_count, property.bedroomCount));
    }
}
