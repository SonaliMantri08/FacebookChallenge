package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.base.BaseClass;

public class LoginPage extends BaseClass {
	public WebDriverWait wait;

	/************** Initializing Page Objects *************/

	public LoginPage() {
		PageFactory.initElements(driver, this); // driver is pointing to current page/class objects
	}

	/********** PageFactory or Object Repository **********/

	@FindBy(id = "email")
	@CacheLookup
	WebElement email;

	@FindBy(id = "pass")
	@CacheLookup
	WebElement password;

	@FindBy(css = "button[name='login']")
	@CacheLookup
	WebElement loginButton;

	/********************** Actions **********************/

	public String getPageTitle() {
		return driver.getTitle();
	}

	public HomePage userLogin(String email_Id, String user_password) {
		email.sendKeys(email_Id);
		password.sendKeys(user_password);
		loginButton.click();
		
		wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.titleIs("Facebook"));
		
		return new HomePage();
	}
	

}
