package com.ui.pojo;

public class UserAddress {



	    private String address1;
	    private String city;
	    private String state;
	    private String postcode;
	    private String homePhone;
	    private String mobilePhone;
	    private String addressAlias;
	    private String additionalInformation;

	    public UserAddress() {
	    }

	    public UserAddress(String address1, String city,  String postcode,
	                   String homePhone, String mobilePhone,
	                   String addressAlias, String additionalInformation) {
	        this.address1 = address1;
	        this.city = city;
	       
	        this.postcode = postcode;
	        this.homePhone = homePhone;
	        this.mobilePhone = mobilePhone;
	        this.addressAlias = addressAlias;
	        this.additionalInformation = additionalInformation;
	    }

	    public String getAddress1() {
	        return address1;
	    }

	    public void setAddress1(String address1) {
	        this.address1 = address1;
	    }

	    public String getCity() {
	        return city;
	    }

	    public void setCity(String city) {
	        this.city = city;
	    }

	   

	  

	    public String getPostcode() {
	        return postcode;
	    }

	    public void setPostcode(String postcode) {
	        this.postcode = postcode;
	    }

	    public String getHomePhone() {
	        return homePhone;
	    }

	    public void setHomePhone(String homePhone) {
	        this.homePhone = homePhone;
	    }

	    public String getMobilePhone() {
	        return mobilePhone;
	    }

	    public void setMobilePhone(String mobilePhone) {
	        this.mobilePhone = mobilePhone;
	    }

	    public String getAddressAlias() {
	        return addressAlias;
	    }

	    public void setAddressAlias(String addressAlias) {
	        this.addressAlias = addressAlias;
	    }

	    public String getAdditionalInformation() {
	        return additionalInformation;
	    }

	    public void setAdditionalInformation(String additionalInformation) {
	        this.additionalInformation = additionalInformation;
	    }
	}

