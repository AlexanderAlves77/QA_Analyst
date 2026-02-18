package com.fulldevstacks.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fulldevstacks.base.TestBase;


public class AddCustomerTest extends TestBase
{
	@Test(dataProvider="getData")
	public void addCustomer(String firstName, String lastName, String postCode, String alertText) 
			throws InterruptedException 
	{
		log.info("Starting Add Customer Test with data: " + firstName + ", " + lastName + ", " + postCode);
		
		// Click on Add Customer button
		driver.findElement(By.cssSelector(OR.getProperty("addcustbtn"))).click();
		// Fill the form
		driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
		driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
		driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
		// Submit form
		driver.findElement(By.cssSelector(OR.getProperty("addbtn"))).click();
		
		// Handle alert
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String alertMessage = alert.getText();
		log.info("Alert message: " + alertMessage);
		
		Assert.assertTrue(alertMessage.contains(alertText));		
		alert.accept();
		log.info("Add Customer Test completed successfully");
	}
	
	@DataProvider
	public Object[][] getData() 
	{
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows - 1][cols];
		
		for (int rowNum = 2; rowNum <= rows; rowNum++)
		{
			for (int colNum = 0; colNum < cols; colNum++)
			{
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
}
