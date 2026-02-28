package com.rubeus.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage
 *
 * This class serves as the foundation for all Page Objects.
 * It provides reusable methods for interacting with web elements.
 *
 * Benefits:
 * - Code reuse
 * - Cleaner tests
 * - Easier maintenance
 * - Professional test architecture
 */
public class BasePage 
{
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected Actions actions;
	
	/**
     * Constructor
     *
     * @param driver WebDriver instance
     */
	public BasePage(WebDriver driver) 
	{
		this.driver = driver; 
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.actions = new Actions(driver);
	}
	
	/**
     * Navigate to a specific URL
     */
	public void navigateTo(String url) 
	{
		driver.get(url);
	}
	
	/**
     * Find element by locator
     */
	protected WebElement find(By locator)
	{
		return driver.findElement(locator);
	}
	
	/**
     * Click element
     */
	protected void click(By locator)
	{
		find(locator).click();
	}
	
	/**
     * Type text into element
     */
	protected void type(By locator, String text)
	{
		WebElement element = find(locator);
		element.clear();
		element.sendKeys(text);
	}
	
	
	 /**
     * Get element text
     */
	protected String getText(By locator)
	{
		return find(locator).getText();
	}
	
	/**
     * Check if element is displayed
     */
	protected boolean isDisplayed(By locator)
	{
		return find(locator).isDisplayed();
	}
	
	 /**
     * Get current page title
     */
	public String getTitle()
	{
		return driver.getTitle();
	}
	
	/**
     * Get current URL
     */
	public String getCurrentUrl()
	{
		return driver.getCurrentUrl();
	}
	
	/**
     * Get page source
     */
	public String getPageSource()
	{
		return driver.getPageSource();
	}
}
