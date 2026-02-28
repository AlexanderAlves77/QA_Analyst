package com.rubeus.qa.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rubeus.qa.config.ConfigManager;

/**
 * BasePage
 *
 * Enterprise-level base class for all Page Objects.
 *
 * Provides:
 * - Explicit waits
 * - Safe click and typing
 * - Visibility and clickability checks
 * - Scroll to element
 * - Highlight element (debug)
 * - Retry mechanism
 *
 * Eliminates flaky tests and improves stability.
 */
public class BasePage 
{
	protected WebDriver driver;
	protected WebDriverWait wait;
	protected ConfigManager config;

	private static final int DEFAULT_TIMEOUT = 10;
	private static final int RETRY_COUNT = 2;
	
	/**
     * Constructor
     *
     * @param driver WebDriver instance
     */
	public BasePage(WebDriver driver) 
	{
		this.driver = driver; 
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));
		this.config = ConfigManager.getInstance();
	}
	
	/**
     * Wait for element to be visible
     */
	protected WebElement waitForVisible(By locator)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	 /**
     * Wait for element to be clickable
     */
	protected WebElement waitForClickable(By locator)
	{
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	/**
     * Safe click with retry mechanism
     */
	public void click(By locator)
	{
		retry(() -> {
			WebElement element = waitForClickable(locator);
			highlight(element);
			element.click();
		});
	}
	
	 /**
     * Safe typing
     */
	public void type(By locator, String text)
	{
		retry(() -> {
			WebElement element = waitForClickable(locator);
			highlight(element);
			element.clear();
			element.sendKeys(text);
		});
	}
	
	/**
     * Get element text safely
     */
	protected String getText(By locator)
	{
		return waitForVisible(locator).getText();
	}
	
	 /**
     * Check if element is visible
     */
	protected boolean isVisible(By locator)
	{
		try
		{
			waitForVisible(locator);
			return true;
		}
		catch (TimeoutException ex)
		{
			return false;
		}
	}
	
	/**
     * Scroll to element
     */
	public void scrollTo(By locator)
	{
		WebElement element = waitForVisible(locator);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript(
				"arguments[0].scrollIntoView({behavior:'smooth', block:'center'});",
				element
		);
	}
	
	/**
     * Highlight element (for debugging)
     */
	protected void highlight(WebElement element)
	{
		try
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			
			js.executeScript(
					"arguments[0].style.border='2px solid red'",
					element
			);
		}
		catch (Exception ignored) {}
	}
	
	 /**
     * Retry wrapper for flaky elements
     */
	private void retry(Runnable action) 
	{
		int attempts = 0;
		
		while (attempts <= RETRY_COUNT)
		{
			try 
			{
				action.run();
				return;
			}
			catch (StaleElementReferenceException ex)
			{
				attempts++;
				
				if (attempts > RETRY_COUNT) throw ex;
				
				sleep(500);
			}
			
		}
	}
	
	/**
     * Navigate to Site page
     */
    public void open(String path)
    {
        navigateTo(config.getBaseUrl() + path);
    }
	
	/**
     * Sleep utility
     */
	protected void sleep(long millis) 
	{
		try
		{
			Thread.sleep(millis);
		}
		catch (InterruptedException ex) {}
	}
	
	/**
     * Navigate to URL
     */
    protected void navigateTo(String url)
    {
        driver.get(url);
    }
    
    /**
     * Find element
     */
    protected WebElement find(By locator)
    {
        return driver.findElement(locator);
    }
    
    /**
     * Check if element is displayed
     */
    protected boolean isDisplayed(By locator)
    {
        try
        {
            return find(locator).isDisplayed();
        }
        catch (Exception ex)
        {
            return false;
        }
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
    protected String getPageSource()
    {
        return driver.getPageSource();
    }
}
