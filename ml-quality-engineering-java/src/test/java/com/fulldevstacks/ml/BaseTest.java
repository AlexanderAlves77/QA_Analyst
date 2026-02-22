package com.fulldevstacks.ml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BaseTest 
{
	protected WebDriver driver;
	protected Properties properties;
	
	@BeforeAll
	static void setupClass()
	{		
		WebDriverManager.chromedriver().setup();	
	}
	
	@BeforeEach
	void setupTest() throws IOException
	{
		properties = new Properties();
		
		try (FileInputStream fis = new FileInputStream("src/test/resources/environment.properties")) 
		{
			properties.load(fis);
		}		
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	@AfterEach 
	void tearDown() 
	{
		if (driver != null) {
			driver.quit();
		}
	}
}
