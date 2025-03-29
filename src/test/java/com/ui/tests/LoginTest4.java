package com.ui.tests;

import static com.constants.Browser.*;
import com.ui.pages.HomePage;

public class LoginTest4 {

	public static void main(String[] args) {
//		WebDriver driver = new ChromeDriver();
		
		HomePage homePage = new HomePage(CHROME);
		String username = homePage.gotoLoginPage().doLoginWith("solih48913@gamebcs.com", "Pass1234").getUsername();
		System.out.println(username);
		
	}

}
