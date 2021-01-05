package extentReportstestNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtentTestReport
{

	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	@BeforeTest
	public void setExtend()
	{
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir"+"/test-output/myReport.html"));
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "windows10");
		extent.setSystemInfo("TesterName", "Surendra");
		extent.setSystemInfo("Browser", "Chrome");
	}
	@AfterTest
	public void endReport()
	{
		extent.flush();
	}
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.apsrtconline.in/oprs-web/");
	}
	
	@Test
	public void titleTest()
	{
		test=extent.createTest("titleTest");
		String Title=driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals(Title, " APSRTC Official Website for Online Bus Ticket Booking");
	}
	
	@Test
	public void logoTest()
	{
		test=extent.createTest("logoTest");
		Boolean logo=driver.findElement(By.xpath("//div[@class='headerLogo']")).isDisplayed();
		Assert.assertTrue(logo);
		
	}
	@Test
	public void loginTest()
	{
		 test=extent.createTest("loginTest");
	     driver.findElement(By.linkText("eTicket Login")).click();
	     driver.findElement(By.id("userName")).sendKeys("suri444");
	     driver.findElement(By.id("password")).sendKeys("Surendra@raju444");
	     driver.findElement(By.id("submitBtn")).click();
	   // Assert.assertEquals(true, true);
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"TestCase Fail"+result.getName() );
			test.log(Status.FAIL,"Test Case Fail"+result.getThrowable());
			
			String screenshotpath=ScreenshotCapture.screenShot(driver,result.getName());
			
			test.addScreenCaptureFromPath(screenshotpath);
			
			
		}else if(result.getStatus()==ITestResult.SKIP)
		{
			
			test.log(Status.SKIP,"TestCase Skipped"+result.getName() );
			
		}else if(result.getStatus()==ITestResult.SUCCESS)
		{
			
			test.log(Status.PASS,"TestCase Passed"+result.getName() );
		}
		
		driver.quit();
	}
	
	/*public static String screenShot(WebDriver driver,String ScreenShotName) throws IOException
	{
		String dateName=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"ScreenShots"+ScreenShotName+dateName+".png";
		File finalDestination=new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}*/
	
	
}
