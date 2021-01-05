package prac;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSutil {
	
		static WebDriver driver;

		public static void main(String[] args) throws IOException {
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
			driver=new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
			
			driver.get("https://www.facebook.com/");
			driver.findElement(By.id("email")).sendKeys("9440352516");
			driver.findElement(By.id("pass")).sendKeys("dictionaryraj29$$");
			
			WebElement loginbtn=driver.findElement(By.id("u_0_b"));
			flashelement(driver,loginbtn);//highlight the element
			drawborder(loginbtn, driver);//drwing border
			//clickelementJS(driver, loginbtn);//clicking the element
			System.out.println(gettitlebyjs(driver));
			System.out.println(getpageinnertext(driver));
			
			scrollpagedown(driver);
			WebElement forgetpass=driver.findElement(By.linkText("Forgotten password?"));
			scrollintoview(forgetpass, driver);
			//refreshbrowser(driver);//refreshing browser
		//	generatealert(driver, "there is an issue with login button");
			
	//		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	//		FileUtils.copyFile(src, new File("C:\\Users\\sk\\Desktop\\fb.png"));
			
		}
			

		

	
	public static void flashelement(WebDriver driver,WebElement element) {
	  JavascriptExecutor jse=(JavascriptExecutor)driver;
		
		String bgcolor=element.getCssValue("backgroundColor");
		
		for(int i=0;i<10;i++) {
			changecolor("rgb(255,0,255)", element, driver);
			changecolor(bgcolor, element, driver);
			
		}
		
	}

	public static void changecolor(String color,WebElement element,WebDriver driver) {
		
		  JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].style.backgroundColor='"+color+"'",element);
		
		
		try {
			Thread.sleep(50);
		}catch(InterruptedException e) {
			
		}
		
	}
	
	
	
	
	public static void drawborder(WebElement element,WebDriver driver) {
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].style.border='3px solid green'", element);
		
	}
	
	
	public static void generatealert(WebDriver driver,String message) {
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
		 jse.executeScript("alert('"+message+"')");
	}
	
	public static void clickelementJS(WebDriver driver,WebElement element) {
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
		 jse.executeScript("arguments[0].click();",element);
		
	}
	public static void refreshbrowser(WebDriver driver) {
		 JavascriptExecutor jse=(JavascriptExecutor)driver;
		 jse.executeScript("history.go[0]");
	}
	
	public static String gettitlebyjs(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
		String title=jse.executeScript("return document.title;").toString();
		return title;
	}
	
	
	public static String getpageinnertext(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		String titletxt=jse.executeScript("return document.documentElement.innerText;").toString();
		
		
		
		return titletxt;
		
	}
	
	public static void scrollpagedown(WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
	}
	
	public static void scrollintoview(WebElement element,WebDriver driver) {
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	
}
