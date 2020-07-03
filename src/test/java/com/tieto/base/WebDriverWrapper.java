package com.tieto.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class WebDriverWrapper {

	protected WebDriver driver;

	@Parameters({ "browser" })
	@BeforeMethod
	public void init(@Optional("ch")String browserName)

	{
		System.out.println(browserName);
		
		//firefox
		System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");
		//chrome
		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");

		if (browserName.toLowerCase().equals("ch")) {
			driver = new ChromeDriver();// open chrome driver

		} else if (browserName.toLowerCase().equals("ff")) {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.openemr.io/openemr/interface/login/login.php?site=default");
	}

	@AfterMethod
	public void end() {
		driver.quit();
	}

}
