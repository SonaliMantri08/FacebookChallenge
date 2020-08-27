package com.facebook.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.facebook.base.BaseClass;

public class HomePage extends BaseClass {
	public WebDriverWait wait;

	/************** Initializing Page Objects *************/

	public HomePage() {
		PageFactory.initElements(driver, this); // driver is pointing to current page/class objects
	}

	/********** PageFactory or Object Repository **********/

	@FindBy(id = "userNavigationLabel")
	@CacheLookup
	WebElement userNavigationLabel;

	@FindBy(linkText = "Log Out")
	@CacheLookup
	WebElement logOutOption;

	// driver.findElement(By.xpath("//span[contains(text(),’Log out’)]")).click();

	/********************** Actions **********************/

	/********************** Actions **********************/

	public String getPageTitle() {
		return driver.getTitle();
	}

	public LoginPage clickLogoutButton() {
		userNavigationLabel.click();
		logOutOption.click();
		wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.titleIs("Facebook – log in or sign up"));
		return new LoginPage();
	}

}
