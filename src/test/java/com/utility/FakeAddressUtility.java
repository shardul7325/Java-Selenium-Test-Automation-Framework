package com.utility;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.ui.pojo.AddressPOJO;

public class FakeAddressUtility {

	public static void main(String[] args) {
		getFakeAddress();
	}
	
	public static AddressPOJO getFakeAddress() {
		
		Faker faker = new Faker(Locale.US);
		
		return new AddressPOJO(faker.company().name(), faker.address().buildingNumber()
				, faker.address().streetAddress(), faker.address().cityName()
				, faker.numerify("#####").substring(0, 5), faker.phoneNumber().cellPhone()
				, faker.phoneNumber().cellPhone(), "other"
				, "Office Address", faker.address().state());
	}
}
