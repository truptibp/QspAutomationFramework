package genericUtilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This class consists of basic configuration annotations  of Testng.
 */
public class BaseClass 
{
	public JavaUtility jUtil=new JavaUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public FileUtility fUtil=new FileUtility();
	
	public WebDriver driver;
	
	//USed for Listeners
	public static WebDriver sdriver;
	
	@BeforeSuite (alwaysRun=true) //Or (groups={"SmokeSuite","RegressionSuite"})
	public void bsConfig()
	{
		System.out.println("------Database connection successful----------");
	}
	
//	@Parameters("browser") cross browser 
//	@BeforeTest   // use this for Distributed Parallel execution 
	
   @BeforeClass(alwaysRun=true) // this for batch and group execution
	public void bcConfig(/*String PValue*/) throws IOException
	{
		String URL=fUtil.readDataFromPropertfile("url");
		
		//USe it for Cross Browser execution- Its Run time Polymorphism - used for driver here
	//	if(PValue=="edge")
		//{
			//driver=new EdgeDriver();
		//}
		//else if (PValue=="chrome")
		//{
		//	driver=new ChromeDriver();
		//}
	//	else
		//{
		//	driver=new EdgeDriver();
		//}
		driver=new ChromeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlyWait(driver);
		
		driver.get(URL);
		
		//USed for Listeners only
		sdriver=driver;
		
		System.out.println("---------Browser Launch successfull------------");
	}
	
	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME=fUtil.readDataFromPropertfile("username");
		String PASSWORD=fUtil.readDataFromPropertfile("password");
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		System.out.println("----Login To Application successfull----------------");
	}
	
	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		InventoryPage ip=new InventoryPage(driver);
		ip.logoutOfApp();
		
		System.out.println("------------Logout of application--------------");
		
	}
	
	//@AfterTest // use this for distributed parallel execution
	@AfterClass(alwaysRun=true) //this for batch and group execution
	public void acConfig()
	{
		driver.quit();
		
		System.out.println("-----------Browser closure successful--------------");
		
	}
	
	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		
		System.out.println("------------Database closure successful--------------");
		
	}
	

}
