package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {

	private static final By PRODUCT_SIZE_DROPDOWN_LOCATOR = By.xpath("(//select[contains(@id,'group_1')])");
	private static final By ADD_TO_CART_BUTTON_LOCATOR = By.name("Submit");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//a[@title='Proceed to checkout']");
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailPage changeProductSize(Size size) {
		selectFromDropdown(PRODUCT_SIZE_DROPDOWN_LOCATOR, size.toString());
		return this;
	}
	
	public ProductDetailPage addProductToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return this;
	}
	
	public ShoppingCartSummaryPage proceedToCheckout() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		return new ShoppingCartSummaryPage(getDriver());
	}

}
