package com.rubeus.qa.base;


import java.time.Duration;
import java.lang.reflect.Method;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.apache.logging.log4j.Logger;
import com.rubeus.qa.config.ConfigManager;
import com.rubeus.qa.extensions.ScreenshotExtension;
import com.rubeus.qa.report.ExtentTestManager;
import com.rubeus.qa.report.QAReportGenerator;
import com.rubeus.qa.utils.LoggerManager;
import com.rubeus.qa.utils.LoggerUtils;
import com.rubeus.qa.utils.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * BaseTest
 *
 * Enterprise base test class.
 *
 * Responsibilities:
 *
 * - WebDriver setup and teardown
 * - ConfigManager integration
 * - ExtentReports integration
 * - Logging integration
 * - Screenshot on failure
 *
 * All test classes must extend this class.
 */
@ExtendWith(ScreenshotExtension.class)
public abstract class BaseTest 
{
	protected Logger logger = LoggerManager.getLogger(this.getClass());
	protected static QAReportGenerator qaReport = new QAReportGenerator();
	protected WebDriver driver;
	protected ConfigManager config;
	
	/**
     * Setup method executed before each test
     */
	@BeforeEach
	public void setUp(TestInfo testInfo)
	{
		config = ConfigManager.getInstance();
		
		initializerDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(config.getTimeout()));
		
		driver.manage().window().maximize();
		
		startReporting(testInfo);
		
		LoggerUtils.init();		
		
		logger.info("Browser started successfully.");
	}
	
	/**
     * Initialize WebDriver based on config
     */
	private void initializerDriver() 
	{
		String browser = config.getBrowser();
		
		if (browser.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			
			ChromeOptions options = new ChromeOptions();
			
			if (config.isHeadless()) 
			{
				options.addArguments("--headless=new");
				options.addArguments("--window-size=1920,1080");
			}
			driver = new ChromeDriver(options);
		}
		else 
		{
			throw new RuntimeException("Browser not supported" + browser);
		}
	}
	
	/**
     * Initialize ExtentReports test
     */
	private void startReporting(TestInfo testInfo) 
	{
		String className = testInfo.getTestClass().map(Class::getSimpleName).orElse("UnknownClass");
		String methodName = testInfo.getTestMethod().map(Method::getName).orElse("UnknownTest");
		
		String testName = className + " - " + methodName;
		
		ExtentTestManager.createTest(testName);
		
		logger.info("Starting test: " + testName);
	}
	
	/**
     * Teardown method executed after each test
     */
	@AfterEach 
	public void tearDown(TestInfo testInfo)
	{
		if (!testInfo.getTags().contains("FAILED"))
	    {
	        ExtentTestManager.pass("Test passed");
	    }
		
		if (driver != null) 
		{
			driver.quit();
			logger.info("Browser closed");					
		}
		
		ExtentTestManager.flush();		
	}
	
	/**
     * Getter for WebDriver
     * Required for extensions and reporting tools
     */
	public WebDriver getDriver() 
	{
		return driver;
	}
	
	@AfterAll
	public static void generateFinalReport() 
	{
		try
		{
			qaReport.generatePDF("reports/QA_Report.pdf");
			qaReport.generateExcel("reports/QA_Report.xlsx");
		}
		catch (Exception ex)
	    {
	        System.err.println("Failed to generate QA reports: " + ex.getMessage());
	        ex.printStackTrace();
	    }
	}
	
	// Exemplo: registrar um item após cada teste
	protected void reportTestItem(String page, String item, String type, String classification, 
			String priority, String description)
	{
		String screenshot = TestUtils.takeScreenshot(driver);
		
		qaReport.addItem(new QAReportGenerator.QAItem(
				page, item, type, classification, priority, description, screenshot)
		);
		
		logger.info("QA Item registered: " + item);
	}
}
