package com.facebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.facebook.base.BaseClass;
import com.facebook.pages.HomePage;
import com.facebook.pages.LoginPage;

public class LoginLogoutTest extends BaseClass {

	
	public static HomePage homePage;
	public static LoginPage loginPage;

	public LoginLogoutTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
	}
	
	
	@Test
	public static void userLoginLogout() {
		
		homePage=loginPage.userLogin("test987.user@gmail.com", "testuser987");

		Assert.assertEquals(loginPage.getPageTitle(), "Facebook", "Actual and expected title mismatch");
		
		homePage.clickLogoutButton();
		
		Assert.assertEquals(homePage.getPageTitle(), "Facebook – log in or sign up", "Actual and expected title mismatch");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
