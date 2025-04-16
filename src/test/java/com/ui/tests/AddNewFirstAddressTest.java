package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

public class AddNewFirstAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPOJO addressPojo;
	private AddressPage addressPage;
	
	@BeforeMethod(description = "Valid first time user logs into the application.")
	public void setup() {
		myAccountPage = homePage.gotoLoginPage().doLoginWith("warepi1635@ptiong.com", "Pass1234");
		addressPojo = FakeAddressUtility.getFakeAddress();
	}
	
	@Test(description = "Verify if the logged in user is able to add a new address or not"
			, groups = {"e2e", "smoke", "sanity"})
	public void addNewAddress() {
		addressPage = myAccountPage.goToAddressPage();
		String newAddress = addressPage.saveAddress(addressPojo);
		Assert.assertEquals(newAddress, addressPojo.getAddressAlias().toUpperCase());
	}
	
	@AfterMethod(description="Deleting User Address to use the same User for future executions")
	public void deleteUserAddress() {
		addressPage.deleteUserAddress();
	}
}
