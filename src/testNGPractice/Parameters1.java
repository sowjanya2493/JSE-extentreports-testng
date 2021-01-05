package testNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class Parameters1 {
	
	@Test
	@Parameters("Browser")
	public void ParameterTest(String Browser)
	{
	   if(Browser.equals("FireFox"))
	   {
		   System.out.println("FireFox Launched");
	   }else if(Browser.equals("Chrome"))
	   {
		   System.out.println("Chrome driver launched");
	   }
	}

}
