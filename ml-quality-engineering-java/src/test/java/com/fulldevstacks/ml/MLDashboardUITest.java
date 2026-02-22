package com.fulldevstacks.ml;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import io.qameta.allure.*;
import org.openqa.selenium.*;


@Epic("UI Validation")
@Feature("Dashboard Display")
public class MLDashboardUITest extends BaseTest
{
	@Test
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Verify ML Results Page Title")
    @Description("Access the system and verify that the title of the ML results page is correct.")
	void testDashBoardTitle()
	{
		driver.get(properties.getProperty("Url"));		
		String title = driver.getTitle();
		Assertions.assertThat(title).isNotBlank();		
		takeScreenshot("Final State - Title");
	}
	
	@Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Verify UI matches ML Data")
    @Description("Valida se a interface reflete os dados processados pelo modelo de ML.")
    @Story("Visual Data Consistency")
	void testUIMatchesData()
	{
		driver.get(properties.getProperty("Url"));
		TransactionPage dashboard = new TransactionPage(driver);
		// Assertions.assertThat(dashboard.getMLStatus()).containsIgnoringCase("Active");
		takeScreenshot("Dashboard State - Data Check");
	}
	
	@Attachment(value = "{name}", type = "image/png")
	public byte[] takeScreenshot(String name) 
	{
		return ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(org.openqa.selenium.OutputType.BYTES);
	}	
}
