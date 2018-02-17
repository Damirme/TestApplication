package com.propertyfinder.testapplication.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Property implements Parcelable {
    public long id;
    public String imageUrl;
    public int bathroomCount;
    public int bedroomCount;

    public Property(){}

    protected Property(Parcel in) {
        imageUrl = in.readString();
        bathroomCount = in.readInt();
        bedroomCount = in.readInt();
        id = in.readLong();
    }

    public static final Creator<Property> CREATOR = new Creator<Property>() {
        @Override
        public Property createFromParcel(Parcel in) {
            return new Property(in);
        }

        @Override
        public Property[] newArray(int size) {
            return new Property[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(imageUrl);
        dest.writeInt(bathroomCount);
        dest.writeInt(bedroomCount);
        dest.writeLong(id);
    }
}
