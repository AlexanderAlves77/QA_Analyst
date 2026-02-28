package com.rubeus.qa.base;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;

import com.rubeus.qa.extensions.ScreenshotExtension;
import com.rubeus.qa.report.ExtentTestManager;
import com.rubeus.qa.utils.LoggerManager;
import com.rubeus.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * BaseTest
 *
 * Professional base class for all automation tests.
 *
 * Responsibilities:
 * - Initialize WebDriver
 * - Start ExtentReports test
 * - Handle teardown
 * - Flush report
 */
@ExtendWith(ScreenshotExtension.class)
public abstract class BaseTest 
{
	protected Logger logger = (Logger) LoggerManager.getLogger(this.getClass());
	protected WebDriver driver;
	
	/**
     * Setup method executed before each test
     */
	@BeforeEach
	public void setUp(TestInfo testInfo)
	{
		// Start report test
		String className = testInfo.getTestClass().get().getSimpleName();
		String methodName = testInfo.getTestMethod().get().getName();
		
		String testName = className + " - " + methodName;
		
		ExtentTestManager.startTest(testName);
		logger.info("Starting test: " + testName);
		
		// Setup WebDriver
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--start-maximized");
		
		driver = new ChromeDriver(options);
		
		ExtentTestManager.info("Browser started successfully.");
	}
	
	/**
     * Teardown method executed after each test
     */
	@AfterEach 
	public void tearDown(TestInfo testInfo)
	{
		try 
		{
			ExtentTestManager.pass("Test finished successfully: " + 
					testInfo.getTestMethod().get().getName()
			);
		}
		catch (Exception ex) 
		{
			ExtentTestManager.fail("Test failed: " + ex.getMessage());
		}
		finally
		{
			if (driver != null) 
			{
				driver.quit();
				logger.info("Browser closed");					
			}
			
			ExtentTestManager.flush();
		}		
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
