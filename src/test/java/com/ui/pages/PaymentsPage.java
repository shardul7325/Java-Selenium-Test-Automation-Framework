package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentsPage extends BrowserUtility {

	private static final By PAYMENT_PAGE_PAYMENT_BY_BANK_WIRE_LOCATOR = By.className("bankwire");
	private static final By PAYMENT_PAGE_CONFIRM_ORDER_BUTTON_LOCATOR = By.xpath("//p[@id='cart_navigation']/button");
	private static final By PAYMENT_PAGE_ALERT_SUCCESS_MESSAGE_LOCATOR = By.xpath("//p[contains(@class,'alert-success')]");
	
	public PaymentsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public String selectPaymentByWireAndConfirmOrder() {
		clickOn(PAYMENT_PAGE_PAYMENT_BY_BANK_WIRE_LOCATOR);
		clickOn(PAYMENT_PAGE_CONFIRM_ORDER_BUTTON_LOCATOR);
		return getVisibleText(PAYMENT_PAGE_ALERT_SUCCESS_MESSAGE_LOCATOR);
	}

}
