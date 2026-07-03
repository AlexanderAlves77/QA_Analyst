package PilotProject;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TextBaseClass {
	
	WebDriver driver = null;
	Properties prop = null;

	@BeforeMethod
	public void init() 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.get("https://money.rediff.com/index.html");
		
		prop = new Properties();
		
		try {
			FileInputStream fStream = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//sakraworldhospital_bookAppointment.properties");
			prop.load(fStream);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void finish() {
		driver.quit();
	}	
}
