package com.ui.pojo;

public class AddressPOJO {

	private String companyName;
	private String addressLine1;
	private String addressLine2;
	private String city;
	private String postalCode;
	private String homePhoneNumber;
	private String mobilePhoneNumber;
	private String otherInformation;
	private String addressAlias;
	private String state;
	
	public AddressPOJO(String companyName, String addressLine1, String addressLine2, String city, String postalCode,
			String homePhoneNumber, String mobilePhoneNumber, String otherInformation, String addressAlias,
			String state) {
		super();
		this.companyName = companyName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.postalCode = postalCode;
		this.homePhoneNumber = homePhoneNumber;
		this.mobilePhoneNumber = mobilePhoneNumber;
		this.otherInformation = otherInformation;
		this.addressAlias = addressAlias;
		this.state = state;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public String getAddressAlias() {
		return addressAlias;
	}

	public String getState() {
		return state;
	}

	@Override
	public String toString() {
		return "AddressPOJO [companyName=" + companyName + ", addressLine1=" + addressLine1 + ", addressLine2="
				+ addressLine2 + ", city=" + city + ", postalCode=" + postalCode + ", homePhoneNumber="
				+ homePhoneNumber + ", mobilePhoneNumber=" + mobilePhoneNumber + ", otherInformation="
				+ otherInformation + ", addressAlias=" + addressAlias + ", state=" + state + "]";
	}

}
