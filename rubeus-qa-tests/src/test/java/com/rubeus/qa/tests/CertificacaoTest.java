package com.rubeus.qa.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;

import com.rubeus.qa.base.BaseTest;
import com.rubeus.qa.pages.CertificacaoPage;
import com.rubeus.qa.utils.TestUtils;

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
	@BeforeEach 
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
	@Test
	public void testCertificationContentExists() 
	{
		assertTrue(certificacaoPage.containsCertificationText(),
				"Certification content was not found on the page.");
	}
	
	@Test 
	public void validateCertificationPage() 
	{
		String screenshotPath = null;
		
		try 
		{
			assertTrue(certificacaoPage.isPageLoaded());
			
			assertEquals("https://qualidade.apprbs.com.br/certificacao", 
					certificacaoPage.getPageUrl());
			
			assertNotNull(certificacaoPage.getTitle());			
			assertFalse(certificacaoPage.getTitle().isEmpty());
			
			assertTrue(certificacaoPage.containsCertificationText());
			
			screenshotPath = TestUtils.takeScreenshot(driver, "certificacao_success",
					"validateCertificacaoPage_success");
			
			qaReport.addTestResult(
					"Certificação",
                    "Page loaded successfully",
                    "Melhoria",
                    "Utilidade",
                    "Baixa",
                    "Certification page loaded successfully with correct URL, title and content.",
				    screenshotPath
			);		
		}
		catch (AssertionError | Exception ex)
		{
			screenshotPath = TestUtils.takeScreenshot(driver, "CertificacaoTest",
			        "validateCertificacaoPage_error");
			
			qaReport.addTestResult(
					"Certificação",
                    "Page validation failed",
                    "Correção",
                    "Utilidade",
                    "Alta",
                    "Certification page validation failed: " + ex.getMessage(),
				    screenshotPath
			);
			
			throw ex;
		}
	}
}
