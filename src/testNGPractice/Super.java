package testNGPractice;

import org.testng.annotations.Test;

public class Super 
{

	@Test
	public void openBrowser()
	{
		System.out.println("browser opened");
	}
	
}
 class grp extends Super
{
	@Test(dependsOnMethods="openBrowser")
	public void login()
	{
		System.out.println("login to website");
	}
}
