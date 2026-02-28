package com.rubeus.qa.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * TestUtils
 *
 * Utility class for test support functions.
 *
 * Features:
 * - Screenshot capture
 * - Evidence generation
 * - File management
 *
 * This is essential for QA automation reporting.
 */
public class TestUtils 
{
	private static final String SCREENSHOT_FOLDER = "screenshots/";
	
	/**
     * Capture screenshot
     *
     * @param driver WebDriver instance
     * @param testName Name of the test
     */
	public static void takeScreenshot(WebDriver driver, String testName)
	{
		try
		{
			createScreenshotDirectory();
			
			File screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			
			String fileName = SCREENSHOT_FOLDER + testName + "_" +
					String.format("%06d", (int)(Math.random() * 1000000)) + ".png";
			
			Path destination = Paths.get(fileName);			
			Files.copy(screenshot.toPath(), destination);
			
			System.out.println("Screenshot saved: " + fileName);
			
		}
		catch (IOException ex) 
		{
			System.out.println("Failed to capture screenshot: " + ex.getMessage());
		}
	}
	
	/**
     * Create screenshot directory if it doesn't exist
     */
	private static void createScreenshotDirectory() throws IOException
	{
		Path path = Paths.get(SCREENSHOT_FOLDER);
		
		if (!Files.exists(path)) 
		{
			Files.createDirectories(path);
		}
	}	
}
