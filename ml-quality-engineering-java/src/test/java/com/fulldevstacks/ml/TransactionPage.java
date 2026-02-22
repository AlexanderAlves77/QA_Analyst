package com.fulldevstacks.ml;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TransactionPage 
{
	private WebDriver driver;
	
	// Locators (Example: Fraudulent Transactions Table)
	private By tableRows = By.cssSelector(".transaction-row");
	private By statusBadge = By.id("ml-status-badge");
	
	public TransactionPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public int getTransactionCount()
	{
		return driver.findElements(tableRows).size();
	}
	
	public String getMLStatus()
	{
		return driver.findElement(statusBadge).getText();
	}
}
