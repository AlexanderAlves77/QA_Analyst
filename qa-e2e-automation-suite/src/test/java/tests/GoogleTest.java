package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;


public class GoogleTest extends BaseTest
{
	@Test
	public void openGoogleTest()
	{
		driver.get("https://www.google.com");
		
		String title = driver.getTitle();
		
		System.out.println("Title: " + title);
		
		Assert.assertTrue(title.contains("Google"));
	}
}
