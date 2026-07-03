package PilotProject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TextBaseClass {
	
	WebDriver driver = null;

	@BeforeMethod
	public void init() 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.get("hhtps://money.rediff.com/index.html");
	}
	
	@AfterMethod
	public void finish() {
		driver.quit();
	}
}
