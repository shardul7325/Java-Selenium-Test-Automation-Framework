package com.ui.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.MyAccountPage;
import com.ui.pages.ProductDetailPage;
import com.ui.pages.SearchResultPage;

public class ProductCheckoutTest extends TestBase {

	private static final String SEARCH_TERM = "Printed Summer Dress";
	private SearchResultPage searchResultPage;
	private ProductDetailPage productDetailPage;
	
	@BeforeMethod(description = "User logs in to the application and searched for a product")
	public void setup() {
		searchResultPage = homePage.gotoLoginPage().doLoginWith("solih48913@gamebcs.com", "Pass1234").searchForAProduct(SEARCH_TERM);
	}
	
	@Test(description="Verify if the logged in user is able to buy a dress"
			, groups = {"e2e", "smoke", "sanity"})
	public void checkoutTest() {
		searchResultPage.clickOnProductAtIndex(0).changeProductSize(L);
	}
}
