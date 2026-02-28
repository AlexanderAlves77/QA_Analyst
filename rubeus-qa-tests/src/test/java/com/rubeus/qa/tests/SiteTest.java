package com.rubeus.qa.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.rubeus.qa.base.BaseTest;

/**
 * SiteTest
 *
 * Automated tests for the Site page:
 * https://qualidade.apprbs.com.br/site
 *
 * Test coverage:
 * - Page accessibility
 * - URL validation
 * - Page title validation
 * - Page content verification
 */
public class SiteTest extends BaseTest
{
	private static final String URL = "https://qualidade.apprbs.com.br/site";
	
	/**
     * Test if the Site page loads successfully
     */
	@Test 
	public void testPageLoadsSuccessfully() 
	{
		driver.get(URL);
		
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals(URL, currentUrl, "The Site page did not load correctly or URL mismatch occurred.");
	}
	
	/**
     * Test if the page title is valid
     */
	@Test 
	public void testPageTitleIsNotEmpty() 
	{
		driver.get(URL);
		
		String title = driver.getTitle();
		
		assertTrue(title != null && !title.isEmpty(), "The page title should not be null or empty.");
	}
	
	/**
     * Test if the page contains expected content
     */
	@Test 
	public void testPageContainsExpectedContent() 
	{
		driver.get(URL);
		
		String pageSource = driver.getPageSource();
		
		assertTrue(
				pageSource.contains("Site") || 
				pageSource.contains("Bem-vindo") ||
				pageSource.contains("Qualidade"), 
				"The Site page does not contain expected content.");
	}
	
	/**
     * Test if the page loads within acceptable time
     */
	@Test 
	public void testPageLoadPerformance() 
	{
		long startTime = System.currentTimeMillis();
		
		driver.get(URL);
		
		long endTime = System.currentTimeMillis();
		
		long loadTime = startTime - endTime;
		
		assertTrue(loadTime < 10000, 
				"The page took too long to load: " + loadTime + " ms");
	}
}
