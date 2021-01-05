package testNGPractice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PriorityTest {
	
	
	@Test(priority=1)
	public void method1()
	{
		
		
		System.out.println("Method1:");
		Assert.assertTrue(false);
		
	}
	@Test(priority=0)
	public void method2()
	{
		
		System.out.println("Method2:");
	}
	@Test(dependsOnMethods="method1")
	public void method3()
	{
		
		System.out.println("Method3:");
	}

}
