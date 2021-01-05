package prac;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSexecutor {
	static WebDriver driver;

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		driver.get("https://freecrm.co.in/");
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		driver.findElement(By.name("email")).sendKeys("surendragorla@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Surendra@111");
		WebElement loginbtn=driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]"));
		JSutil.flashelement(driver, loginbtn);//highlight the element
		JSutil.drawborder(loginbtn, driver);
		
		
	}
		

	}


