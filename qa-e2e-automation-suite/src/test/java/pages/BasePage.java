package pages;

import org.openqa.selenium.WebDriver;

import drivers.DriverManager;

public class BasePage 
{
	protected WebDriver driver;
	
	public BasePage()
	{
		driver = DriverManager.getDriver();
	}
}
