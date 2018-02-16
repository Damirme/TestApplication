
package com.propertyfinder.testapplication.property_list.item;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Property {

    @SerializedName("agent_license")
    private String mAgentLicense;
    @SerializedName("agent_name")
    private String mAgentName;
    @SerializedName("amenities")
    private List<String> mAmenities;
    @SerializedName("amenities_keys")
    private List<String> mAmenitiesKeys;
    @SerializedName("area")
    private String mArea;
    @SerializedName("bathrooms")
    private long mBathrooms;
    @SerializedName("bedrooms")
    private long mBedrooms;
    @SerializedName("broker")
    private Broker mBroker;
    @SerializedName("broker_name")
    private String mBrokerName;
    @SerializedName("category_id")
    private long mCategoryId;
    @SerializedName("currency")
    private String mCurrency;
    @SerializedName("date_insert")
    private String mDateInsert;
    @SerializedName("date_update")
    private String mDateUpdate;
    @SerializedName("featured")
    private boolean mFeatured;
    @SerializedName("hide_location")
    private boolean mHideLocation;
    @SerializedName("id")
    private long mId;
    @SerializedName("image_count")
    private long mImageCount;
    @SerializedName("lat")
    private double mLat;
    @SerializedName("location")
    private String mLocation;
    @SerializedName("location_id")
    private long mLocationId;
    @SerializedName("long")
    private double mLong;
    @SerializedName("poa")
    private String mPoa;
    @SerializedName("price")
    private String mPrice;
    @SerializedName("price_label")
    private String mPriceLabel;
    @SerializedName("price_period")
    private String mPricePeriod;
    @SerializedName("price_period_raw")
    private String mPricePeriodRaw;
    @SerializedName("price_value")
    private String mPriceValue;
    @SerializedName("price_value_raw")
    private long mPriceValueRaw;
    @SerializedName("rera_permit")
    private String mReraPermit;
    @SerializedName("subject")
    private String mSubject;
    @SerializedName("thumbnail")
    private String mThumbnail;
    @SerializedName("thumbnail_big")
    private String mThumbnailBig;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("type")
    private String mType;
    @SerializedName("type_id")
    private long mTypeId;
    @SerializedName("update")
    private long mUpdate;
    @SerializedName("visited")
    private boolean mVisited;

    public String getAgentLicense() {
        return mAgentLicense;
    }

    public void setAgentLicense(String agentLicense) {
        mAgentLicense = agentLicense;
    }

    public String getAgentName() {
        return mAgentName;
    }

    public void setAgentName(String agentName) {
        mAgentName = agentName;
    }

    public List<String> getAmenities() {
        return mAmenities;
    }

    public void setAmenities(List<String> amenities) {
        mAmenities = amenities;
    }

    public List<String> getAmenitiesKeys() {
        return mAmenitiesKeys;
    }

    public void setAmenitiesKeys(List<String> amenitiesKeys) {
        mAmenitiesKeys = amenitiesKeys;
    }

    public String getArea() {
        return mArea;
    }

    public void setArea(String area) {
        mArea = area;
    }

    public long getBathrooms() {
        return mBathrooms;
    }

    public void setBathrooms(long bathrooms) {
        mBathrooms = bathrooms;
    }

    public long getBedrooms() {
        return mBedrooms;
    }

    public void setBedrooms(long bedrooms) {
        mBedrooms = bedrooms;
    }

    public Broker getBroker() {
        return mBroker;
    }

    public void setBroker(Broker broker) {
        mBroker = broker;
    }

    public String getBrokerName() {
        return mBrokerName;
    }

    public void setBrokerName(String brokerName) {
        mBrokerName = brokerName;
    }

    public long getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(long categoryId) {
        mCategoryId = categoryId;
    }

    public String getCurrency() {
        return mCurrency;
    }

    public void setCurrency(String currency) {
        mCurrency = currency;
    }

    public String getDateInsert() {
        return mDateInsert;
    }

    public void setDateInsert(String dateInsert) {
        mDateInsert = dateInsert;
    }

    public String getDateUpdate() {
        return mDateUpdate;
    }

    public void setDateUpdate(String dateUpdate) {
        mDateUpdate = dateUpdate;
    }

    public boolean getFeatured() {
        return mFeatured;
    }

    public void setFeatured(boolean featured) {
        mFeatured = featured;
    }

    public boolean getHideLocation() {
        return mHideLocation;
    }

    public void setHideLocation(boolean hideLocation) {
        mHideLocation = hideLocation;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public long getImageCount() {
        return mImageCount;
    }

    public void setImageCount(long imageCount) {
        mImageCount = imageCount;
    }

    public double getLat() {
        return mLat;
    }

    public void setLat(double lat) {
        mLat = lat;
    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public long getLocationId() {
        return mLocationId;
    }

    public void setLocationId(long locationId) {
        mLocationId = locationId;
    }

    public double getLong() {
        return mLong;
    }

    public void setLong(double Long) {
        mLong = Long;
    }

    public String getPoa() {
        return mPoa;
    }

    public void setPoa(String poa) {
        mPoa = poa;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getPriceLabel() {
        return mPriceLabel;
    }

    public void setPriceLabel(String priceLabel) {
        mPriceLabel = priceLabel;
    }

    public String getPricePeriod() {
        return mPricePeriod;
    }

    public void setPricePeriod(String pricePeriod) {
        mPricePeriod = pricePeriod;
    }

    public String getPricePeriodRaw() {
        return mPricePeriodRaw;
    }

    public void setPricePeriodRaw(String pricePeriodRaw) {
        mPricePeriodRaw = pricePeriodRaw;
    }

    public String getPriceValue() {
        return mPriceValue;
    }

    public void setPriceValue(String priceValue) {
        mPriceValue = priceValue;
    }

    public long getPriceValueRaw() {
        return mPriceValueRaw;
    }

    public void setPriceValueRaw(long priceValueRaw) {
        mPriceValueRaw = priceValueRaw;
    }

    public String getReraPermit() {
        return mReraPermit;
    }

    public void setReraPermit(String reraPermit) {
        mReraPermit = reraPermit;
    }

    public String getSubject() {
        return mSubject;
    }

    public void setSubject(String subject) {
        mSubject = subject;
    }

    public String getThumbnail() {
        return mThumbnail;
    }

    public void setThumbnail(String thumbnail) {
        mThumbnail = thumbnail;
    }

    public String getThumbnailBig() {
        return mThumbnailBig;
    }

    public void setThumbnailBig(String thumbnailBig) {
        mThumbnailBig = thumbnailBig;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getType() {
        return mType;
    }

    public void setType(String type) {
        mType = type;
    }

    public long getTypeId() {
        return mTypeId;
    }

    public void setTypeId(long typeId) {
        mTypeId = typeId;
    }

    public long getUpdate() {
        return mUpdate;
    }

    public void setUpdate(long update) {
        mUpdate = update;
    }

    public boolean getVisited() {
        return mVisited;
    }

    public void setVisited(boolean visited) {
        mVisited = visited;
    }

}
