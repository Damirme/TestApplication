
package com.propertyfinder.testapplication.property_list.item;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Broker {

    @SerializedName("address")
    private String mAddress;
    @SerializedName("agent_id")
    private long mAgentId;
    @SerializedName("agent_name")
    private String mAgentName;
    @SerializedName("agent_photo")
    private String mAgentPhoto;
    @SerializedName("email")
    private String mEmail;
    @SerializedName("id")
    private long mId;
    @SerializedName("lead_email_receivers")
    private List<String> mLeadEmailReceivers;
    @SerializedName("license")
    private String mLicense;
    @SerializedName("logo")
    private String mLogo;
    @SerializedName("mobile")
    private String mMobile;
    @SerializedName("name")
    private String mName;
    @SerializedName("phone")
    private String mPhone;

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }

    public long getAgentId() {
        return mAgentId;
    }

    public void setAgentId(long agentId) {
        mAgentId = agentId;
    }

    public String getAgentName() {
        return mAgentName;
    }

    public void setAgentName(String agentName) {
        mAgentName = agentName;
    }

    public String getAgentPhoto() {
        return mAgentPhoto;
    }

    public void setAgentPhoto(String agentPhoto) {
        mAgentPhoto = agentPhoto;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(String email) {
        mEmail = email;
    }

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public List<String> getLeadEmailReceivers() {
        return mLeadEmailReceivers;
    }

    public void setLeadEmailReceivers(List<String> leadEmailReceivers) {
        mLeadEmailReceivers = leadEmailReceivers;
    }

    public String getLicense() {
        return mLicense;
    }

    public void setLicense(String license) {
        mLicense = license;
    }

    public String getLogo() {
        return mLogo;
    }

    public void setLogo(String logo) {
        mLogo = logo;
    }

    public String getMobile() {
        return mMobile;
    }

    public void setMobile(String mobile) {
        mMobile = mobile;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

}
