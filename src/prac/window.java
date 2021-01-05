package prac;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.server.handler.SendKeys;
import org.openqa.selenium.support.ui.Select;

public class window {

	public static void main(String[] args) {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			 WebDriver driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
			driver.get("https://www.facebook.com/r.php");
			String tab=Keys.chord(Keys.CONTROL,"t");
			driver.findElement(By.linkText("Forgotten password?")).sendKeys(tab);
			WebElement list=driver.findElement(By.id("month"));
			Select sc=new Select(list);
			
			List<WebElement> drop=sc.getOptions();
			int size=drop.size();
			System.out.println(size);
			for(int i=0;i<size;i++) {
				String opt=drop.get(i).getText();
			
			System.out.println(opt);
			}
			
		
			
			

	}

}
