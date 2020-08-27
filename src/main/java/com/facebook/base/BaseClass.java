package com.facebook.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties properties;
	public static String currentDirectory = System.getProperty("user.dir");

	public BaseClass() {
		properties = new Properties();
		try {
			properties.load(new FileInputStream(
					currentDirectory + "//src//main//java//com//facebook//config//config.properties"));
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found Exception");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IO Exception");
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = properties.getProperty("browser");

		if (browserName.equals("chrome")) {
			// code to disable notifications popup
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			
			// instantiating driver
			driver = new ChromeDriver(options);
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(properties.getProperty("url"));
	}
}
