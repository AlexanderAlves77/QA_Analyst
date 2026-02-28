package com.rubeus.qa.base;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.rubeus.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * BaseTest
 *
 * Base class for all test classes.
 *
 * Responsibilities:
 * - Setup WebDriver
 * - Configure browser
 * - Teardown WebDriver
 * - Capture screenshot on test failure
 *
 * This follows industry best practices for QA automation.
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
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--start-maximized");
		
		driver = new ChromeDriver(options);
	}
	
	/**
     * Teardown method executed after each test
     */
	@AfterEach 
	public void tearDown()
	{
		if (driver == null) 
			throw new IllegalStateException("Driver not initialized");
		
		driver.quit();
	}
	
	/**
     * Getter for WebDriver
     * Required for extensions and reporting tools
     */
	public WebDriver getDriver() 
	{
		return driver;
	}
}
