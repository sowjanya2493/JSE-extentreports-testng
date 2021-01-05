package testNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class TestNGparam {

     @Test
	
	@Parameters({"valueA","valueB"})
	public void Add(int a,int b)
	{
		int total=a+b;
		System.out.println("Addition:"+total);
	}
    @Test
    @Parameters({"valueA","valueB"})
    public void sub(int a,int b)
    {
    	int sub=a-b;
		System.out.println("Subtraction:"+sub);
    }
	
}
