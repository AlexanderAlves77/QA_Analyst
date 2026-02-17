package com.fulldevstacks.testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.fulldevstacks.base.TestBase;

public class LoginTest extends TestBase
{
	@Test
	public void loginAsBankManager() 
	{
		driver.findElement(By.xpath(OR.getProperty("bmlBtn")));
	}
}
