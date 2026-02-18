package com.fulldevstacks.testcases;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.fulldevstacks.base.TestBase;

public class BankManagerLoginTest extends TestBase
{
	@Test
	public void loginAsBankManager() throws InterruptedException 
	{
		try {
			log.info("Clicking on Bank Manager Login button");
			String locator = OR.getProperty("bmlBtn");	
			driver.findElement(By.cssSelector(locator)).click();
			
			// Check if the Add Customer button appears (login successful)
			Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addcustbtn"))), "Login not successfully");
			log.info("Login successfully executed");
			
		} catch (NoSuchElementException e) {
			log.error("Element not found: " + e.getMessage());
			throw e;
		} catch (Exception e) {
			log.error("Test failed: " + e.getMessage());
			throw e;
		}
	}
	
	
}
