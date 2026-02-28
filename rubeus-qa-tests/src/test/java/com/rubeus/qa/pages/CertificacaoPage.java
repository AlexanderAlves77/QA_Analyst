package com.rubeus.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * CertificacaoPage
 *
 * Page Object representing the Certificacao page.
 *
 * URL:
 * https://qualidade.apprbs.com.br/certificacao
 *
 * Responsibilities:
 * - Page navigation
 * - Element interaction
 * - Page validation
 */
public class CertificacaoPage extends BasePage
{
	private static final String URL = "https://qualidade.apprbs.com.br/certificacao";
	
	// Example locators (will refine as needed)
	private By body = By.tagName("body");
	
	/**
     * Constructor
     */
	public CertificacaoPage(WebDriver driver)
	{
		super(driver);
	}
	
	/**
     * Navigate to Certificacao page
     */
	public void open() 
	{
		navigateTo(URL);
	}
	
	/**
     * Check if page loaded successfully
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
     * Get current page URL
     */
	public String getPageUrl()
	{
		return getCurrentUrl();
	}
		
	/**
     * Check if page contains certification content
     */
	public boolean containsCertificationText()
	{
		String source = getPageSource();
		
		return source.contains("Certificação") || source.contains("Certificacao");
	}	
}
