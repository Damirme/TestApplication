package com.propertyfinder.testapplication.features.property_list.sorting;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.propertyfinder.testapplication.R;
import com.propertyfinder.testapplication.data.model.SortType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import static com.propertyfinder.testapplication.data.model.SortType.PRICE_ACCENDING;
import static com.propertyfinder.testapplication.data.model.SortType.PRICE_DECENDING;
import static com.propertyfinder.testapplication.data.model.SortType.BEDROOM_ACCENDING;
import static com.propertyfinder.testapplication.data.model.SortType.BEDROOM_DECENDING;


public class SortAdapter extends BaseAdapter {
    Map<Integer, SortType> map;

    @Inject
    public SortAdapter(Context context) {
        map = new HashMap<Integer, SortType>();
        map.put(0, new SortType(context.getString(R.string.sort_pd),PRICE_DECENDING));
        map.put(1, new SortType(context.getString(R.string.sort_pa),PRICE_ACCENDING));
        map.put(2, new SortType(context.getString(R.string.sort_bd),BEDROOM_DECENDING));
        map.put(3, new SortType(context.getString(R.string.sort_ba),BEDROOM_ACCENDING));
    }

    @Override
    public int getCount() {
        return map.size();
    }

    @Override
    public SortType getItem(int position) {
        return map.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.select_dialog_item, parent, false);
        ((TextView) view.findViewById(android.R.id.text1)).setText(getItem(position).toString());
        return view;
    }
}
