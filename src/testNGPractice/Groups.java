package testNGPractice;

import org.testng.annotations.Test;

public class Groups 
{
    @Test(dependsOnGroups="Signin")
    public void viewAcc()
    {
    	System.out.println("View u r DashBoard");
    	
    }
    
    @Test(groups="Signin")
    public void BrowserLaunch()
    {
    	
    System.out.println("Launch the Browser");
   
    }
    @Test(groups="Signin")
    public void login()
    {
    	System.out.println("Login into website");
    }
    @Test(dependsOnMethods="viewAcc")
    public void close()
    {
    	System.out.println("Close the browser");
    }
	
	
	
	
}
