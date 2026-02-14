package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage
{
	private By title = By.className("title");
	
	public String getTitle()
	{
		return driver.findElement(title).getText();
	}
}
