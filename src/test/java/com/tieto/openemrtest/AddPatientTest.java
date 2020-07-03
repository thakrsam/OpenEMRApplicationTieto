package com.tieto.openemrtest;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.tieto.base.WebDriverWrapper;

public class AddPatientTest extends WebDriverWrapper {
	
	
	@Test
	public void createPatientTest()
	{
	
	driver.findElement(By.id("authUser")).sendKeys("admin");
	driver.findElement(By.id("clearPass")).sendKeys("pass");
	Select selectLang = new Select(driver.findElement(By.name("languageChoice")));
	selectLang.selectByVisibleText("English (Indian)");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
   
	//for page object model first complete automation till assertion verification
	
	//fill patient details
	
	//verify
}

}


