package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility{

	private static final By USER_NAME_LOCATOR = By.xpath("(//a[@title='View my customer account']/span)");
	private static final By SEARCH_TEXT_BOX_LOCATOR = By.xpath("(//input[contains(@id,'search_query_top')])");
	private static final By ADD_NEW_ADDRESS_LOCATOR = By.xpath("(//a[@title='Add my first address'])");
	
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	public String getUsername() {
		return getVisibleText(USER_NAME_LOCATOR);
	}
	
	public SearchResultPage searchForAProduct(String productName) {
		enterText(SEARCH_TEXT_BOX_LOCATOR, productName);
		enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
		
		SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		
		return searchResultPage;
	}
	
	public AddressPage goToAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LOCATOR);
		
		return new AddressPage(getDriver());
	}

}
