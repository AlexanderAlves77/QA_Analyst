package com.rubeus.qa.utils;

import java.util.logging.Logger;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import com.rubeus.qa.report.ExtentTestManager;


public class LoggerUtils 
{
	private static Logger logger = Logger.getLogger(LoggerUtils.class.getName());
	private static boolean initialized = false;
	
	private LoggerUtils() {}
	
	public static void init() 
	{
		if (initialized) return;
		
		try 
		{
			FileHandler fileHandler = new FileHandler("logs/test.log", true);
			fileHandler.setFormatter(new SimpleFormatter());
			
			logger.addHandler(fileHandler);
			
			initialized = true;
			
		}
		catch (Exception ex) 
		{
			ex.printStackTrace();
		}
	}
	
	public static void info(String message)
	{
		logger.info(message);
		ExtentTestManager.getTest().info(message);
	}
	
	public static void pass(String message)
	{
		logger.info("PASS: " + message);
		ExtentTestManager.getTest().pass(message);
	}
	
	public static void fail(String message)
	{
		logger.severe("FAIL: " + message);
		ExtentTestManager.getTest().fail(message);
	}
	
	public static void warning(String message)
	{
		logger.warning(message);
		ExtentTestManager.getTest().warning(message);
	}
}
