package com.tieto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DashboardPage {
	
	private By messageCenterLocator= By.xpath("//span[text()='Message Center']");
   private WebDriver driver;
	
	
	public DashboardPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void messageCenter()
	{
		WebDriverWait wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.presenceOfElementLocated(messageCenterLocator));
		
	}

	public void getTitle() {
		String actualTitle=driver.getTitle();
		Assert.assertEquals(actualTitle, "OpenEMR");
		
	}
	
	
}
