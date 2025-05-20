package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGPractise 
{
	@Test(invocationCount=2,priority=1)
	public void createsample()
	{
		Assert.fail();
		System.out.println("Create");
	}
	
	@Test(enabled =false)
	public void modifysample()
	{
		System.out.println("Modify");
	} 
	
	@Test(dependsOnMethods="createsample")//skip
	public void deletesample()
	{
		System.out.println("Delete");
	}
	
	
}
