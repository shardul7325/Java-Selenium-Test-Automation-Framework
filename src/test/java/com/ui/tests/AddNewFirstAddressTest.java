package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPOJO addressPojo;
	
	@BeforeMethod(description = "Valid first time user logs into the application.")
	public void setup() {
		myAccountPage = homePage.gotoLoginPage().doLoginWith("solih48913@gamebcs.com", "Pass1234");
		addressPojo = FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description = "Verify if the logged in user is able to add a new address or not"
			, groups = {"e2e", "smoke", "sanity"})
	public void addNewAddress() {
		String newAddress = myAccountPage.goToAddressPage().saveAddress(addressPojo);
		Assert.assertEquals(newAddress, addressPojo.getAddressAlias().toUpperCase());
	}
}
