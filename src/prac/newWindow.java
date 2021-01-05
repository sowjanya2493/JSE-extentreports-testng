package prac;


import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.safari.SafariDriver.WindowType;


public class newWindow {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/intl/en-GB/gmail/about/#");
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/ul[1]/li[3]/a")).click();
		//driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL+"t");
		//System.out.println(driver.getTitle());
		
//		List<WebElement> list=  driver.findElements(By.tagName("a"));
//		System.out.println("list of links="+list.size());
		
		
		
		Thread.sleep(1000);
		String pwindow=driver.getWindowHandle();
		System.out.println("parentwindw="+pwindow);
		
		
		Set<String> allwindows=driver.getWindowHandles();
		
		System.out.println("allwindows="+allwindows);
		driver.switchTo().window(pwindow);
//		Iterator<String> allw=allwindows.iterator();
//		String pw=allw.next();
		
		
		int x=driver.manage().window().getPosition().getX();
		System.out.println("x axis="+x);
		
		
		int y=driver.manage().window().getPosition().getY();
		
		System.out.println("y axis="+y);
		
			}
	
	

}
