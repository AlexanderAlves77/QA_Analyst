package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import config.ConfigManager;

public class DriverManager 
{
	private static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		if (driver == null)
		{
			if (ConfigManager.getBrowser().equals("chrome")) 
			{
				driver = new ChromeDriver();
				
				driver.manage().window().maximize();
			}					
		}
		
		return driver;
	}
	
	public static void quitDriver()
	{
		if (driver != null) 
		{
			driver.quit();
			
			driver = null;
		}
	}
}
