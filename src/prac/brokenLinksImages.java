package prac;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class brokenLinksImages {
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
		driver.findElement(By.xpath("//*[@id=\"ui\"]/div/div/form/div/div[3]")).click();
		
		
		List<WebElement> links=driver.findElements(By.tagName("a")); //get links of all images and links
		links.addAll(driver.findElements(By.tagName("img")));
		System.out.println("get size of all links and images="+links.size());
		
		List<WebElement> activelinks=new ArrayList<WebElement>();
		
		
		//iterate links:exclude links and images which are not indicated with href attribute
		for(int i=0;i<links.size();i++) {
			if(links.get(i).getAttribute("href")!=null) {
				activelinks.add(links.get(i));
			}
			
		}
		System.out.println("get size of all activelinks="+activelinks.size());

	}

}
