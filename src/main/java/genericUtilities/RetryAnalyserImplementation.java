package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * This class provides implementation to IRetryAnalyser Interface of TestNG.
 */
public class RetryAnalyserImplementation implements IRetryAnalyzer
{
	int count =0;
	int retryCount=3; //Manually analysed

	@Override
	public boolean retry(ITestResult result) {
		
		//0<3 1<3 2<3 3<3NO
		while(count<retryCount)
		{
			count++; //1 2 3
			return true;//retry retry retry
		}
		
		return false;//stop retry
	}
}
