package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import drivers.DriverManager;

public class ScreenshotUtil 
{
	public static void takeScreenshot(String testName)
	{
		File src = (
				(TakesScreenshot) 
				DriverManager.getDriver())
				.getScreenshotAs(OutputType.FILE);
		
		Path dest = Paths.get("screenshots/" + testName + ".png");
		
		try
		{
			Files.createDirectories(dest.getParent());
			
			Files.copy(src.toPath(), dest);
		}
		catch (IOException ex) 
		{
			ex.printStackTrace();
		}
	}
}
