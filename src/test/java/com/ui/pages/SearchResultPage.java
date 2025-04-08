package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[contains(@class,'lighter')]");
	private static final By SEARCH_PRODUCTS_LISTS_LOCATOR = By.xpath("(//h5[contains(@itemprop,'name')])");
	
	public SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}
	
	public boolean isSearchTermPresentInProductList(String searchTerm) {
		List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
		List<String> productNamesList = getAllVisibleText(SEARCH_PRODUCTS_LISTS_LOCATOR);
		
		boolean result = productNamesList.stream()
		.anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase():: contains)));
		
		return result;
	}

}
