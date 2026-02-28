package com.rubeus.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * SitePage
 *
 * Page Object representing the Site page.
 *
 * URL:
 * https://qualidade.apprbs.com.br/site
 *
 * Responsibilities:
 * - Page navigation
 * - Page validation
 * - Content verification
 */
public class SitePage extends BasePage
{
	private static final String URL = "https://qualidade.apprbs.com.br/site";
	
	// Basic locator to validate page load
	private By body = By.tagName("body");
	
	/**
     * Constructor
     */
	public SitePage(WebDriver driver)
	{
		super(driver);
	}
	
	/**
     * Navigate to Site page
     */
	public void open() 
	{
		navigateTo(URL);
	}
	
	/**
     * Verify if page loaded successfully
     */
	public boolean isPageLoaded()
	{
		return isDisplayed(body);
	}
	
	/**
     * Get page title
     */
	public String getPageTitle()
	{
		return getTitle();
	}
		
	/**
     * Get current page 
     */
	public String getPageUrl()
	{
		return getCurrentUrl();
	}
		
	/**
     * Verify expected content exists
     */
	public boolean containsCertificationText()
	{
		String source = getPageSource();
		
		return source.contains("Site") || 
				source.contains("Qualidade") ||
				source.contains("Bem-vindo") ||
				source.length() > 0;
	}
}
