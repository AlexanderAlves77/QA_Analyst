package com.rubeus.qa.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.rubeus.qa.base.BaseTest;
import com.rubeus.qa.pages.SitePage;
import com.rubeus.qa.utils.TestUtils;

import static org.junit.jupiter.api.Assertions.*;

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
	
	@Test 
	public void validateSitePage() 
	{
		String screenshotPath = null;
		
		try 
		{
			assertTrue(sitePage.isPageLoaded());
			
			assertEquals("https://qualidade.apprbs.com.br/site", sitePage.getPageUrl());
			
			assertNotNull(sitePage.getTitle());			
			assertFalse(sitePage.getTitle().isEmpty());
			
			assertTrue(sitePage.containsCertificationText());
			
			screenshotPath = TestUtils.takeScreenshot(driver, "site_success",
					"validateSitePage_success");
			
			qaReport.addTestResult(
					"Site",
                    "Page loaded successfully",
                    "Melhoria",
                    "Utilidade",
                    "Baixa",
                    "Site page loaded successfully with correct URL, title and content.",
				    screenshotPath
			);		
		}
		catch (AssertionError | Exception ex)
		{
			screenshotPath = TestUtils.takeScreenshot(driver, "SiteTest",
			        "validateSitePage_error");
			
			qaReport.addTestResult(
					"Site",
                    "Page validation failed",
                    "Correção",
                    "Utilidade",
                    "Alta",
                    "Site page validation failed: " + ex.getMessage(),
				    screenshotPath
			);
			
			throw ex;
		}
	}
}
