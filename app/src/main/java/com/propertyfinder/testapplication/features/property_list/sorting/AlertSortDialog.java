package com.propertyfinder.testapplication.features.property_list.sorting;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.propertyfinder.testapplication.R;


public class AlertSortDialog extends AlertDialog {

    public AlertSortDialog(Context context, SortAdapter adapter) {
        super(context);
        setTitle(R.string.choose_sort_type);
    }


}
