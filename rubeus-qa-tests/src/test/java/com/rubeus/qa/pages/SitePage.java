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
	// Basic locator to validate page load
	private By header = By.tagName("h1");
	
	/**
     * Constructor
     */
	public SitePage(WebDriver driver)
	{
		super(driver);
	}
	
		
	public boolean isHeaderVisible()
	{
		return isVisible(header);
	}
}
