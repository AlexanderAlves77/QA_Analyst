package com.rubeus.qa.report;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * ScreenshotManager
 *
 * Responsible for capturing and storing screenshots
 * in an organized folder structure.
 *
 * Folder structure:
 *
 * screenshots/
 *    2026-02-28/
 *        CertificacaoTest/
 *            testPageLoadsSuccessfully_12-30-45.png
 *
 */
public class ScreenshotManager 
{
	private static final String BASE_FOLDER = "screenshots/";
	private static final DateTimeFormatter DATE_FORMAT = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd");
	private static final DateTimeFormatter TIMESTAMP_FORMAT = 
			DateTimeFormatter.ofPattern("HH-mm-ss");
	
	/**
     * Capture screenshot and return file path
     */
	public static String capture(WebDriver driver, String className, String methodName)
	{
		try
		{
			LocalDateTime now = LocalDateTime.now();
			
			String dateFolder = now.format(DATE_FORMAT);
			String timeStamp = now.format(TIMESTAMP_FORMAT);
			
			String directoryPath = BASE_FOLDER + dateFolder + "/" + className + "/";
			
			createDirectory(directoryPath);
			
			String filePath = directoryPath + methodName + "_" + timeStamp + ".png";
			
			File screenshot = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			
			Path destination = Paths.get(filePath);
			
			Files.copy(screenshot.toPath(), destination);
			
			System.out.println("Screenshot saved: " + destination);
			
			return filePath;
			
		}
		catch (IOException ex) 
		{
			System.out.println("Screenshot failed: " + ex.getMessage());
			return null;
		}
	}
	
	private static void createDirectory(String path) throws IOException
	{
		Path diretory = Paths.get(path);
		
		if (!Files.exists(diretory)) 
			Files.createDirectories(diretory);
	}
}
