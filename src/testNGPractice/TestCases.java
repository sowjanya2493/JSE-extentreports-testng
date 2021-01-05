package testNGPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(testNGPractice.Listeners.class)	

public class TestCases {
	
	
	
	//WebDriver driver= new FirefoxDriver();					

	//Test to pass as to verify listeners.	
	WebDriver driver;
	@Test		
	public void Login()				
	{		
		
		System.setProperty("webdriver.gecko.driver", "D:\\Selenium\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		 driver= new FirefoxDriver();	
	    driver.get("http://demo.guru99.com/V4/");					
	    driver.findElement(By.name("uid")).sendKeys("mngr34926");							
	    driver.findElement(By.name("password")).sendKeys("amUpenu");							
	    driver.findElement(By.xpath("//*[@type='submit']")).click();					
	}		

	//Forcefully failed this test as verify listener.		
	@Test		
	public void TestToFail()				
	{		
	    System.out.println("This method to test fail");					
	    Assert.assertTrue(false);			
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
