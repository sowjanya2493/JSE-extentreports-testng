package testNGPractice;

import org.testng.Assert;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderTest
{

	@DataProvider
	public Object[][]dpmethod()
	{
		return new Object[][] {{1,2,3},{4,5,6}};
		
	}
	@Test(dataProvider="dpmethod")
	public void fTest(int a,int b,int result)
	{
		int sum=a+b;
		System.out.println("Given parameters are: "+sum);
		Assert.assertEquals(result, sum);
	}
}
