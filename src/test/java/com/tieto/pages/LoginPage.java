package com.tieto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


//non static page object creation method

public class LoginPage {

	private By userLocator = By.id("authUser");
	private By passLocator = By.id("clearPass");
	private By languageLocator=By.name("languageChoice");
	private By loginLocator = By.xpath("//button[@type='submit']");
			
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUsername(String username) {

		driver.findElement(userLocator).sendKeys(username);
	}

	public void enterPassword(String pass) {

		driver.findElement(passLocator).sendKeys(pass);

	}
	
	//select language
	
	public void selectLanguage(String text)
	{
		Select selectLang = new Select(driver.findElement(languageLocator));
		selectLang.selectByVisibleText(text);
	}

	//select login
	public void clickLogin() {
		
		driver.findElement(loginLocator).click();
		
	}
	
	public void errorMessage()
	{
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	// Static page object method creation
//	
//	
//	private static By userLocator= By.id("authUser");
//	private static By passLocator=By.id("clearPass");
//	
//	public static void enterUsername(WebDriver driver, String username) {
//		driver.findElement(userLocator).sendKeys(username);
//	}
//	
//	
//	public static void enterPassword(WebDriver driver,String pass)
//	{
//	
//	driver.findElement(passLocator).sendKeys(pass);
//
//	}
}
