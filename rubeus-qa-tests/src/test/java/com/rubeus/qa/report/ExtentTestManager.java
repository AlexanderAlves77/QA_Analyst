package com.rubeus.qa.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


/**
 * ExtentTestManager
 *
 * Responsible for managing test instances within ExtentReports.
 *
 * Uses ThreadLocal to ensure thread safety when running parallel tests.
 */
public class ExtentTestManager 
{
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	private static ExtentReports extent = ExtentManager.getInstance();
	
	 /**
     * Start a new test in the report
     *
     * @param testName Test name
     */
	public static void startTest(String testName) 
	{
		ExtentTest test = extent.createTest(testName);
		extentTest.set(test);
	}
	
	/**
     * Get current test instance
     *
     * @return ExtentTest instance
     */
	public static ExtentTest getTest()
	{
		return extentTest.get();
	}
	
	/**
     * Mark test as PASS
     *
     * @param message Log message
     */
	public static void pass(String message)
	{
		getTest().pass(message);
	}
	
	 /**
     * Mark test as FAIL
     *
     * @param message Log message
     */
	public static void fail(String message)
	{
		getTest().fail(message);
	}
	
	/**
     * Add INFO log
     *
     * @param message Log message
     */
	public static void info(String message)
	{
		getTest().info(message);
	}
	
	/**
     * Flush report (write to file)
     */
	public static void flush()
	{
		extent.flush();
	}
}
