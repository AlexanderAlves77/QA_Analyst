package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import drivers.DriverManager;

public class LoginPage extends BasePage
{
	private WebDriver driver;
	
	private By username = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	
	public LoginPage()
	{
		this.driver = DriverManager.getDriver();
	}
	
	public void openSite(String url)
	{
		driver.get(url);		
	}
	
	public void login(String user, String pass)
	{
		driver.findElement(username).sendKeys(user);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(loginButton).click();
	}
}
