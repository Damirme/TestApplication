package com.propertyfinder.testapplication.data.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortType {
    public static final String PRICE_DECENDING = "pd";
    public static final String PRICE_ACCENDING = "pa";
    public static final String BEDROOM_DECENDING = "bd";
    public static final String BEDROOM_ACCENDING = "ba";


    String name;
    String code;

    public SortType(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getCode() {
        return code;
    }
}
