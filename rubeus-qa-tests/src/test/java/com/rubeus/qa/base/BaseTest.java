package com.rubeus.qa.base;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.rubeus.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * BaseTest
 *
 * This class is responsible for:
 * - WebDriver initialization
 * - Browser setup
 * - Timeout configuration
 * - Browser teardown
 *
 * All test classes must extend this class.
 */
public class BaseTest 
{
	protected WebDriver driver;
	
	/**
     * Setup method executed before each test
     */
	@BeforeEach
	public void setUp()
	{
		// Setup ChromeDriver automatically
		WebDriverManager.chromedriver().setup();
		
		// Initialize driver
		driver = new ChromeDriver();
		
		// Browser configuration
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
     * Teardown method executed after each test
     */
	@AfterEach 
	public void tearDown()
	{
		if (driver != null) 
			driver.quit();
	}
	
	protected WebDriver getDriver() 
	{
		return driver;
	}
}
