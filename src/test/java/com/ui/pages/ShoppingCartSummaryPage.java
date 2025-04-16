package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShoppingCartSummaryPage extends BrowserUtility {

	private static final By SUMMARY_PAGE_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");
	
	public ShoppingCartSummaryPage(WebDriver driver) {
		super(driver);
	}
	
	public ConfirmAddressPage goToConfirmAddressPage() {
		clickOn(SUMMARY_PAGE_PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ConfirmAddressPage(getDriver());
	}

}
