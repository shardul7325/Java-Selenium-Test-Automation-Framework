	/*
	 * How to ensure we write good Test Scripts
	 * 1. Test Scripts have to be small
	 * 2. You cannot have conditional statements, loops, try catch in your test methods
	 * 		1st Test Scripts ----> then Test steps
	 * 3. Reduce the use of local variables!!
	 * 4. You should have at least one assertion!!
	 */
package com.ui.tests;

import static com.constants.Browser.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTestDataDriven {

	HomePage homepage;
	
	@BeforeMethod(description = "Load the Homepage of the website")
	public void setupMethod() {
		homepage = new HomePage(CHROME);
	}
	
	@Test(description = "Verifies if the valid user is able to login into the application"
			, groups = {"e2e", "sanity"}
			, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class
			, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user) {
		
		assertEquals(homepage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(), "Shardul Pakhare");
		
	}
	
	@Test(description = "Verifies if the valid user is able to login into the application"
			, groups = {"e2e", "sanity"}
			, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class
			, dataProvider = "LoginTestCSVDataProvider")
	public void loginCSVTest(User user) {
		
		assertEquals(homepage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(), "Shardul Pakhare");
		
	}
	
	@Test(description = "Verifies if the valid user is able to login into the application"
			, groups = {"e2e", "sanity"}
			, dataProviderClass = com.ui.dataProviders.LoginDataProvider.class
			, dataProvider = "LoginTestExcelDataProvider")
	public void loginExcelTest(User user) {
		
		assertEquals(homepage.gotoLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUsername(), "Shardul Pakhare");
		
	}

}
