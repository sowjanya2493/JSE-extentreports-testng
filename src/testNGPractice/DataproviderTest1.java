package testNGPractice;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class DataproviderTest1 {
	
	@DataProvider(name="data-provider")
	public Object[][]dpmethod(Method m)
	{
		
		return null;
		
	}
	

}
