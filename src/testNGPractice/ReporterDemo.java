package testNGPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class ReporterDemo {
	
	
	    
	    @Test(invocationCount=10)
	    public void testReport(){
	    	
	    	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
	        
	        WebDriver driver=new ChromeDriver();
	        
	        Reporter.log("Browser Opened",true);
	        
	        driver.manage().window().maximize();
	        
	        Reporter.log("Browser Maximized",true);
	        
	        driver.get("http://www.google.com");
	        
	        Reporter.log("Application started",true);
	        
	        driver.quit();
	        
	        Reporter.log("Application closed",true);
	        
	    }
	 
	}


