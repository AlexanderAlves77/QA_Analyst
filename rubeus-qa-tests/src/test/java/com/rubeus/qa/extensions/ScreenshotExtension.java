package com.rubeus.qa.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import com.rubeus.qa.base.BaseTest;
import com.rubeus.qa.report.ExtentTestManager;
import com.rubeus.qa.utils.TestUtils;


/**
 * ScreenshotExtension
 *
*
 * Captures screenshot and attaches to ExtentReport on test failure.
 */
public class ScreenshotExtension implements AfterTestExecutionCallback
{
	@Override
	public void afterTestExecution(ExtensionContext context) throws Exception 
	{
		boolean testFailed = context.getExecutionException().isPresent();
		
		if (testFailed) 
		{
			Object testInstance = context.getRequiredTestInstance();
			
			if (testInstance instanceof BaseTest) 
			{
				WebDriver driver = ((BaseTest) testInstance).getDriver();
				String screenshotPath = TestUtils.takeScreenshot(driver);
				
				if (screenshotPath != null) 
				{
					ExtentTestManager.fail(context.getExecutionException().get().getMessage());
					ExtentTestManager.attachScreenshot(screenshotPath);
				}								
			}
		}
	}
}
