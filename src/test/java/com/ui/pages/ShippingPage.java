package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {

	private static final By SHIPPING_PAGE_TERMS_OF_SERVICE_CHECKBOX_LOCATOR = By.id("uniform-cgv");
	private static final By SHIPPING_PAGE_PROCEED_TO_CHECKOUT_LOCATOR = By.name("processCarrier");
	
	public ShippingPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public PaymentsPage goToPaymentsPage() {
		clickOn(SHIPPING_PAGE_TERMS_OF_SERVICE_CHECKBOX_LOCATOR);
		clickOn(SHIPPING_PAGE_PROCEED_TO_CHECKOUT_LOCATOR);
		return new PaymentsPage(getDriver());
	}

}
