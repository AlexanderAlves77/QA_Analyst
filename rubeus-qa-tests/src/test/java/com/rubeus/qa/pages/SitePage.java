package com.rubeus.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.rubeus.qa.config.ConfigManager;

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
     * Validate page loaded
     */
    public boolean isPageLoaded()
    {
        return isDisplayed(body);
    }
	
    /**
     * Get current URL
     */
    public String getPageUrl()
    {
        return getCurrentUrl();
    }
    
	/**
     * Navigate to Site page
     */
    public void open()
    {
        navigateTo(config.getBaseUrl() + "/site");
    }
		
	public boolean isHeaderVisible()
	{
		return isVisible(body);
	}
	
	/**
     * Check if expected content exists
     */
    public boolean containsCertificationText()
    {
        String source = getPageSource();

        return source.contains("Site")
                || source.contains("Certificação")
                || source.contains("Certificacao");
    }
}
