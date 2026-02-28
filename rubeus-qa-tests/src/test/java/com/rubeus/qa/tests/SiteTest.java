package com.rubeus.qa.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rubeus.qa.base.BaseTest;
import com.rubeus.qa.pages.SitePage;

/**
 * SiteTest
 *
 * Refactored test using Page Object Model (POM).
 *
 * Test coverage:
 * - Page accessibility
 * - Page load validation
 * - URL validation
 * - Title validation
 * - Content validation
 */
public class SiteTest extends BaseTest
{
	private SitePage sitePage;
	
	/**
     * Initialize SitePage before each test
     */
	@BeforeEach 
	public void initPage()
	{
		sitePage = new SitePage(driver);
		sitePage.open();
	}
	
	/**
     * Test if page loads successfully
     */
	@Test 
	public void testPageLoadsSuccessfully() 
	{
		assertTrue(sitePage.isPageLoaded(),
    			"Site page did not load correctly.");
	}
	
	/**
     * Test if URL is correct
     */
	@Test 
	public void testPageUrlIsCorrect() 
	{
		String expectedUrl = "https://qualidade.apprbs.com.br/site";
		
		assertEquals(expectedUrl,
				sitePage.getPageUrl(),
				"Site page URL is incorrect.");
	}
	
	/**
     * Test if page title is valid
     */
	@Test 
	public void testPageTitleIsValid() 
	{
		String title = sitePage.getTitle();
		
		assertTrue(title != null &&
				!title.isEmpty(), 
				"Site page title should not be null or empty.");
	}
	
	/**
     * Test if expected content exists
     */
	@Test 
	public void testExpectedContentExists() 
	{
		assertTrue(sitePage.containsCertificationText(),
				"Expected content was not found on Site page.");
	}
}
