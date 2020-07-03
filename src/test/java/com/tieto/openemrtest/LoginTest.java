package com.tieto.openemrtest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.tieto.base.WebDriverWrapper;
import com.tieto.pages.DashboardPage;
import com.tieto.pages.LoginPage;


public class LoginTest extends WebDriverWrapper {
	
	@Test(priority =1)
	
	public void validCredentialTest() {
		
		LoginPage loginpage =new LoginPage(driver);
		
		loginpage.enterUsername("admin");
		loginpage.enterPassword("pass");
		loginpage.selectLanguage("English (Indian)");
		loginpage.clickLogin();
		

		DashboardPage dashboard =new DashboardPage(driver);
		dashboard.messageCenter();
		dashboard.getTitle();
		
		
		
		//static page object creation .check LoginPage.java
		
	//	LoginPage.enterUsername(driver, "admin");
	//	LoginPage.enterPassword(driver, "pass");
		//driver.findElement(By.id("authUser")).sendKeys("admin");
		//driver.findElement(By.id("clearPass")).sendKeys("pass");
		
		
	//	Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
	//	selectLang.selectByVisibleText("English (Indian)");
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	//	WebDriverWait wait=new WebDriverWait(driver,40);
	//	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Message Center']")));
		
//		String actualTitle=driver.getTitle();
	   
		//One assertion is must in a testNG method
		//Assert.assertEquals(actualTitle, "OpenEMR");
		
		//to view in output report
		//Reporter.log(actualTitle);
		

	}
	
	
	@Test(priority =2)
	public void invalidCredentialTest() {

		
		driver.findElement(By.id("authUser")).sendKeys("admin123");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
		selectLang.selectByVisibleText("English (Indian)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		//WebDriverWait wait=new WebDriverWait(driver,40);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Message Center']")));s
		
		String actualError=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText();
		
	   
		//One assertion is must in a testNG method
		Assert.assertEquals(actualError.trim(),"Invalid username or password");
		
		//assert true
		Assert.assertTrue(actualError.contains("Invalid username or password"));
		

		}
	
	}
	
	


