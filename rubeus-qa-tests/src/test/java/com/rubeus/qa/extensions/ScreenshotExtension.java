package com.rubeus.qa.extensions;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.WebDriver;

import com.rubeus.qa.base.BaseTest;
import com.rubeus.qa.utils.TestUtils;


/**
 * ScreenshotExtension
 *
 * JUnit 5 extension to capture screenshot on test failure.
 *
 * This is the professional and correct way to integrate screenshots.
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
				TestUtils.takeScreenshot(driver);
			}
		}
	}
}
