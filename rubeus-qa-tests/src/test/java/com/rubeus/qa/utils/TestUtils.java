package com.rubeus.qa.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.lang.StackWalker.StackFrame;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * TestUtils
 *
 * Professional utility class for QA automation support.
 *
 * Features:
 * - Screenshot capture
 * - Automatic test name detection (class + method)
 * - Organized folders by date
 * - Timestamped filenames
 * - CI/CD ready evidence structure
 *
 * Folder structure example:
 *
 * screenshots/
 *   2026-02-28/
 *     SiteTest_accessHomePage_2026-02-28_14-32-10.png
 *
 */
public class TestUtils 
{
	private static final String ROOT_SCREENSHOT_FOLDER = "screenshots";
	private static final DateTimeFormatter DATE_FORMAT = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final DateTimeFormatter TIMESTAMP_FORMAT = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
	
	/**
     * Capture screenshot with automatic test name detection
     *
     * @param driver WebDriver instance
     */
	public static String takeScreenshot(WebDriver driver)
	{
		try
		{
			String className  = getCallingClassName();
			String methodName = getCallingMethodName();
			
			return takeScreenshot(driver, className, methodName);
			
		}
		catch (Exception ex) 
		{
			System.out.println("Failed to capture screenshot: " + ex.getMessage());
			return null;
		}
	}
	
	/**
     * Capture screenshot with explicit class and method name
     */
	public static String takeScreenshot(WebDriver driver, String className, String methodName)
	{
		try
		{
			String dateFolder = LocalDate.now().format(DATE_FORMAT);
			
			Path folderPath = Paths.get(ROOT_SCREENSHOT_FOLDER, dateFolder);
			
			createDirectory(folderPath);
			
			File screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			
			String timeStamp = LocalDateTime.now().format(TIMESTAMP_FORMAT);
			
			String fileName = String.format(
					"%s_%s_%s.png", 
					className,
					methodName,
					timeStamp);
			
			Path destination = folderPath.resolve(fileName);			
			Files.copy(screenshot.toPath(), destination);
			
			System.out.println("Screenshot saved: " + destination.toAbsolutePath());
			
			return destination.toAbsolutePath().toString();
			
		}
		catch (IOException ex) 
		{
			System.out.println("Failed to capture screenshot: " + ex.getMessage());
			return null;
		}
	}
	
	private static void createDirectory(Path path) throws IOException
	{
		if (!Files.exists(path)) 
			Files.createDirectories(path);
	}
	
	/**
     * Get calling class name automatically
     */
	private static String getCallingClassName()
	{
		StackFrame frame = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
				.walk(stream -> stream.skip(2).findFirst().get());
		
		return frame.getDeclaringClass().getSimpleName();
	}
	
	/**
     * Get calling method name automatically
     */
	private static String getCallingMethodName()
	{
		StackFrame frame = StackWalker.getInstance(StackWalker.Option.RETAIN_CLASS_REFERENCE)
				.walk(stream -> stream.skip(2).findFirst().get());
		
		return frame.getMethodName();
	}
}
