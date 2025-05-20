package genericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation of ITestListeners interface of TestNg	
 */
public class ListnersImplementation implements ITestListener
{

	ExtentReports report;
	ExtentTest test;
	
	@Override
	public void onTestStart(ITestResult result)
	{
		// capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# "+ methodName +" Test script execution started");
		
		//Create Test in extent Report
		test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		// capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# "+ methodName +"-> Test script PASS");
		
		//log the status as PASS in Extent Report
		test.log(Status.PASS, methodName +"-> Test script PASS");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		// capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# "+ methodName +"->Test script FAILED");
		
		//log the status as FAIL in extent report
		test.log(Status.FAIL, methodName +"->Test script FAILED");
		
		//log the exception in Extent Report
		test.log(Status.WARNING, result.getThrowable());
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		//capture screenshot
		JavaUtility j=new JavaUtility();
		SeleniumUtility s=new SeleniumUtility();
		
		//configure screenshot name
		String screenShotName = methodName+"-"+j.getSystemDate();
		
		try {
			String path = s.captureScreenShot(BaseClass.sdriver, screenShotName);
			
			//attach the screenshot to extent report
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result)
	{
		// capture method name
		String methodName = result.getMethod().getMethodName();
		System.out.println("# "+ methodName +"->Test script SKIPPED.");
		
		//capture the exception
		System.out.println(result.getThrowable());
		
		//log the status as SKIP in extent report
		test.log(Status.SKIP, methodName +"->Test script SKIPPED.");
		
		//Log the exception in the Extent report
		test.log(Status.WARNING, result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result)
	{
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		System.out.println("# Test execution Started");
		
		//Basic Configuration of Extent Reports
		ExtentSparkReporter esr= new ExtentSparkReporter(".\\ExtentReports\\Report -"+ new JavaUtility().getSystemDate()+".html");
		esr.config().setDocumentTitle("Swag Labs Execution Report");
		esr.config().setTheme(Theme.DARK);
		esr.config().setReportName("Automation Framework Execution");
		
		//Report Generation
		report = new ExtentReports();
		report.attachReporter(esr);
		report.setSystemInfo("Base Browser", "Microsoft Edge");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Base Environment", "Testing");
		report.setSystemInfo("Reporter Name", "Trupti");
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		System.out.println("# Test execution completed.");
		
		//Report generation Extent report
		report.flush();
		
	}

}
