package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {

	private static final By PRODUCT_SIZE_DROPDOWN_LOCATOR = By.xpath("(//select[contains(@id,'group_1')])");
	
	public ProductDetailPage(WebDriver driver) {
		super(driver);
	}
	
	public ProductDetailPage changeProductSize(Size size) {
		selectFromDropdown(PRODUCT_SIZE_DROPDOWN_LOCATOR, size.toString());
		return this;
	}

}
