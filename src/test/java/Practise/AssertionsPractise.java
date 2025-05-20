package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionsPractise 
{
	@Test(retryAnalyzer=genericUtilities.RetryAnalyserImplementation.class)
	public void sample() //HardAssert Example
	{
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		Assert.assertEquals(0, 1); //line where error has occured.
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
	}

	@Test
	public void samplesoft() //SoftAssert Example
	{
		SoftAssert sa=new SoftAssert();
		
		System.out.println("Step 1");
		System.out.println("Step 2");
		System.out.println("Step 3");
		
		sa.assertEquals(0, 1); //line where actual error has occured.
		
		System.out.println("Step 4");
		System.out.println("Step 5");
		System.out.println("Step 6");
		
		sa.assertAll();// points and logs the error here but error occured at line 32
	}
}
