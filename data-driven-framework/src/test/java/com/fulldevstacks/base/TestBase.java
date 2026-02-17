package com.fulldevstacks.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class TestBase 
{
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	
	@BeforeSuite
	public void setUp()
	{
		if (driver == null) 
		{			
			try 
			{
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
				config.load(fis);
				
				fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
				OR.load(fis);
			}
			catch (FileNotFoundException ex) {
				ex.printStackTrace();
			}				
			catch (IOException ex) {
				ex.printStackTrace();
			}
			
			String browser = config.getProperty("browser");		
			
			if (browser.equals("firefox"))
			{
				driver = new FirefoxDriver();
			}
			else if (browser.equals("chrome"))
			{
				driver = new ChromeDriver();
			}
			else if (browser.equals("ie"))
			{
				driver = new InternetExplorerDriver();
			}
			
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			
			// SOLUÇÃO: Usar Duration
			int waitTime = Integer.parseInt(config.getProperty("implicitly.wait"));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitTime));
		}
	}
	
	@AfterSuite
	public void tearDown()
	{
		if (driver != null) {
			driver.quit();
		}
	}
}
