package tests;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utils.ScreenshotUtil;

public class TestListener implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result)
	{
		ScreenshotUtil.takeScreenshot(result.getName());
	}
}
