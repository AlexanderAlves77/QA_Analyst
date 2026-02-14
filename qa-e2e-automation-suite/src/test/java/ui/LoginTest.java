package ui;

import base.BaseTest;
import config.ConfigManager;
import drivers.DriverManager;
import pages.LoginPage;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest
{
	@Test
	public void loginTest()
	{
		DriverManager.getDriver();
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.openSite(ConfigManager.getBaseUrl());
		
		loginPage.login("Admin", "admin123");		
		
	}
}
