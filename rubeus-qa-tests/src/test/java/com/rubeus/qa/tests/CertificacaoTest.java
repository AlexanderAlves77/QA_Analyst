package com.rubeus.qa.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.rubeus.qa.base.BaseTest;

/**
 * CertificacaoTest
 *
 * Automated tests for the Certificacao page:
 * https://qualidade.apprbs.com.br/certificacao
 *
 * Test coverage:
 * - Page accessibility
 * - Page title validation
 * - URL validation
 * - Page load confirmation
 */
public class CertificacaoTest extends BaseTest
{
	private static final String URL = "https://qualidade.apprbs.com.br/certificacao";
	
	/**
     * Test if the Certificacao page loads successfully
     */
	@Test 
	public void testPageLoadsSuccessfully() 
	{
		driver.get(URL);;
		
		String currentUrl = driver.getCurrentUrl();
		
		assertEquals(URL, currentUrl, "The page URL is incorrect or did not load properly.");
	}
	
	/**
     * Test if the page title is present
     */
	@Test 
	public void testPageTitleIsNotEmpty() 
	{
		driver.get(URL);;
		
		String title = driver.getTitle();
		
		assertTrue(title != null && !title.isEmpty(), "The page title should not be null or empty.");
	}
	
	/**
     * Test if the page source contains expected content
     */
	@Test 
	public void testPageContainsExpectedContent() 
	{
		driver.get(URL);;
		
		String pageSource = driver.getPageSource();
		
		assertTrue(pageSource.contains("Certificação") || 
				pageSource.contains("Certificacao"), 
				"The page does not contain expected certification content.");
	}
}
