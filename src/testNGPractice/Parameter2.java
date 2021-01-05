package testNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameter2 {
	
	@Test
	@Parameters({"FirstName","SecondName","LastName"})
	public void Full(String A,String B,String C)
	{
		String FullName=A+B+" "+C;
		System.out.println(FullName);
	}

}
