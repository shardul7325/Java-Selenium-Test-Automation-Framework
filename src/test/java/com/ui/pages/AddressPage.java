package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.ui.pojo.AddressPOJO;
import com.utility.BrowserUtility;

public class AddressPage extends BrowserUtility {

	private static final By COMPANY_TEXTBOX_LOCATOR = By.xpath("(//input[contains(@id,'company')])");
	private static final By ADDRESS1_TEXTBOX_LOCATOR = By.xpath("(//input[contains(@id,'address1')])");
	private static final By ADDRESS2_TEXTBOX_LOCATOR = By.xpath("(//input[contains(@id,'address2')])");
	private static final By CITY_TEXTBOX_LOCATOR = By.xpath("(//input[contains(@id,'city')])");
	private static final By POSTAL_CODE_TEXTBOX_LOCATOR = By.xpath("(//input[contains(@id,'postcode')])");
	private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.xpath("(//input[contains(@id,'phone')])");
	private static final By MOBILE_NUMBER_TEXTBOX_LOCATOR = By.xpath("(//input[contains(@id,'phone_mobile')])");
	private static final By OTHER_INFORMATION_TEXTAREA_LOCATOR = By.xpath("(//textarea[contains(@id,'other')])");
	private static final By ADDRESS_ALIAS_TEXTBOX_LOCATOR = By.xpath("(//input[contains(@id,'alias')])");
	
	private static final By STATE_DROPDOWN_LOCATOR = By.xpath("(//select[contains(@id,'id_state')])");
	private static final By SAVE_ADDRESS_BUTTON_LOCATOR = By.xpath("(//button[contains(@id,'submitAddress')])");
	private static final By ADDRESS_HEADING_LOCATOR = By.xpath("(//h3)");
	
	private static final By DELETE_ADDRESS_BUTTON_LOCATOR = By.xpath("//a[@title='Delete']");

	
	
	public AddressPage(WebDriver driver) {
		super(driver);
	}
	
	public String saveAddress(AddressPOJO addressPojo) {
		enterText(COMPANY_TEXTBOX_LOCATOR, addressPojo.getCompanyName());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, addressPojo.getAddressLine1());
		enterText(ADDRESS1_TEXTBOX_LOCATOR, addressPojo.getAddressLine2());
		enterText(CITY_TEXTBOX_LOCATOR, addressPojo.getCity());
		enterText(POSTAL_CODE_TEXTBOX_LOCATOR, addressPojo.getPostalCode());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR, addressPojo.getHomePhoneNumber());
		enterText(MOBILE_NUMBER_TEXTBOX_LOCATOR, addressPojo.getMobilePhoneNumber());
		enterText(OTHER_INFORMATION_TEXTAREA_LOCATOR, addressPojo.getOtherInformation());
		clearText(ADDRESS_ALIAS_TEXTBOX_LOCATOR);
		enterText(ADDRESS_ALIAS_TEXTBOX_LOCATOR, addressPojo.getAddressAlias());
		
		selectFromDropdown(STATE_DROPDOWN_LOCATOR, addressPojo.getState());
		
		clickOn(SAVE_ADDRESS_BUTTON_LOCATOR);
		
		return getVisibleText(ADDRESS_HEADING_LOCATOR);
	}
	
	public void deleteUserAddress() {
		clickOn(DELETE_ADDRESS_BUTTON_LOCATOR);
		acceptAlert();
	}

}
