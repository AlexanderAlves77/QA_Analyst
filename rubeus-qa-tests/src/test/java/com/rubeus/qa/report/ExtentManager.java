package com.rubeus.qa.report;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


/**
 * ExtentManager
 *
 * Responsible for managing ExtentReports instance.
 */
public class ExtentManager 
{
	private static ExtentReports extent;
	private static final DateTimeFormatter TIMESTAMP_FORMAT = 
			DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
	
	public static ExtentReports getInstance()
	{
		if (extent == null) 
			createInstance();
		
		return extent;
	}
	
	private static void createInstance()
	{
		String timeStamp = LocalDate.now().format(TIMESTAMP_FORMAT);
		
		String reportPath = Paths.get("test-output",
				"ExtentReport_" + timeStamp + ".html")
				.toString();
		
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
		
		sparkReporter.config().setReportName("Rubeus QA Automation Report"); 
		sparkReporter.config().setDocumentTitle("Automation Test Result"); 
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Project", "Rubeus QA");
		extent.setSystemInfo("Tester", "Alexander Alves");
		extent.setSystemInfo("Environment", "QA");
	}
}
