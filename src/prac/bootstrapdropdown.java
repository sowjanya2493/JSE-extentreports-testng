package prac;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class bootstrapdropdown {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
		
		driver.get("http://www.way2automation.com/");
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse-1\"]/ul/li[3]/a")).click();
		List<WebElement> optin=driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li//a"));
		int sze=optin.size();
		System.out.println(optin);
		
		for(int i=0;i<sze;i++) {
			String opt=optin.get(i).getText();
			System.out.println(opt);
		}

	}

}
