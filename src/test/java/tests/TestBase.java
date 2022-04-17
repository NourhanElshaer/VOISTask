package tests;

import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestBase 
{
//	public static WebDriver driver ; 
	
	@BeforeMethod
	 void setup(){
			
			String chromePath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		    System.setProperty("webdriver.chrome.driver", chromePath);
	        DesiredCapabilities caps = new DesiredCapabilities();
	        // Add caps here    
	        LocalDriverManager.setWebDriver(new ChromeDriver(caps));
	        LocalDriverManager.getDriver().manage().window().maximize();
	        LocalDriverManager.getDriver().get("https://www.youtube.com/");
} 

	@AfterMethod
	public void stopDriver() throws InterruptedException 
	{		
		LocalDriverManager.getDriver().quit();
//		Thread.sleep(2000);

	}

	
}
