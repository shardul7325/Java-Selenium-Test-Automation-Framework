package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Problems with the below code
 * 1. hardCoding of links
 * 2. Duplicacy of code
 * 3. TestData is attached to the script
 * 4. Naming convention is not followed
 * 5. Exception Handling is not done
 * 6. Synchronization is not done (findElement() method is not synchrnized, need to add explicitWait() at the minimum for synchronization)
 * 7. No Assertion present
 * 8. No Abstraction present
 */

public class LoginTestOld {

	public static void main(String[] args) {
		WebDriver wd = new ChromeDriver(); // launches a Browser Window!! A Browser Session is created.
		wd.get("http://automationpractice.pl/index.php?");
		// maximize the browser window
		wd.manage().window().maximize();
		By signInLinkLocator = By.xpath("//a[contains(text(),\"Sign\")]");
		WebElement signInLinkWebElement = wd.findElement(signInLinkLocator);
		signInLinkWebElement.click();
		
		By emailTextBoxLocator = By.id("email");
		WebElement emailTextBWebElement = wd.findElement(emailTextBoxLocator);
		emailTextBWebElement.sendKeys("solih48913@gamebcs.com");
		
		By passwordTextBoxLocator = By.id("passwd");
		WebElement passwordTextBWebElement = wd.findElement(passwordTextBoxLocator);
		passwordTextBWebElement.sendKeys("Pass1234");
		
		By submitLoginButtonLocator = By.id("SubmitLogin");
		WebElement submitLoginButtonWebElement = wd.findElement(submitLoginButtonLocator);
		submitLoginButtonWebElement.click();
		
	}

}
