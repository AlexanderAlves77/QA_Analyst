package com.rubeus.qa.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.rubeus.qa.base.BaseTest;
import com.rubeus.qa.pages.CertificacaoPage;

/**
 * CertificacaoTest
 *
  * Refactored test using Page Object Model (POM).
 *
 * This test validates:
 * - Page accessibility
 * - Page load success
 * - URL correctness
 * - Title validity
 * - Certification content presence
 */
public class CertificacaoTest extends BaseTest
{
	private CertificacaoPage certificacaoPage;
	
	/**
     * Initialize page object before each test
     */
	@Test 
	public void initPage() 
	{
		certificacaoPage = new CertificacaoPage(driver);
		certificacaoPage.open();
	}
	
	/**
     * Test if page loads successfully
     */
    @Test
    public void testPageLoadsSuccessfully()
    {
    	assertTrue(certificacaoPage.isPageLoaded(),
    			"Certificacao page did not load correctly.");
    }
	
	/**
     * Test if URL is correct
     */
	@Test 
	public void testPageUrlIsCorrect() 
	{
		String expectedUrl = "https://qualidade.apprbs.com.br/certificacao";
		
		assertEquals(expectedUrl,
				certificacaoPage.getPageUrl(),
				"Page URL is incorrect.");
	}
	
	/**
     * Test if page title is valid
     */
	@Test 
	public void testPageTitleIsValid() 
	{
		String title = certificacaoPage.getTitle();
		
		assertTrue(title != null &&
				!title.isEmpty(), 
				"Page title should not be null or empty.");
	}
	
	/**
     * Test if certification content exists
     */
	public void testCertificationContentExists() 
	{
		assertTrue(certificacaoPage.containsCertificationText(),
				"Certification content was not found on the page.");
	}
}
