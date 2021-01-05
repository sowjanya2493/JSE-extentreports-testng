package testNGPractice;

import org.testng.annotations.Test;

public class DependsonMethods
{

	@Test()
	public void Signin()
	{
		System.out.println("This will exicute second(login)");
	}

	
	@Test
	public void OpenBrowser()
	{
		System.out.println("This will exicute first(OpenBrowser)");
	}
	@Test(dependsOnMethods={"Signin","OpenBrowser"})
	public void logout()
	{
		System.out.println("Loggged out successfully");
	}
	
}
