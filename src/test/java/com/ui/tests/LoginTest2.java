package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

// This class was created before HomePage class was created
public class LoginTest2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		BrowserUtility browserUtility = new BrowserUtility(driver);
		
		browserUtility.gotoWebsite("http://automationpractice.pl/index.php?");
		browserUtility.maximizeWindow();
		
		By signInLinkLocator = By.xpath("//a[contains(text(),\"Sign\")]");
		browserUtility.clickOn(signInLinkLocator);
		
		By emailTextBoxLocator = By.id("email");
		browserUtility.enterText(emailTextBoxLocator, "solih48913@gamebcs.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		browserUtility.enterText(passwordTextBoxLocator, "Pass1234");
		
		By submitLoginButtonLocator = By.id("SubmitLogin");
		browserUtility.clickOn(submitLoginButtonLocator);
		
	}

}
