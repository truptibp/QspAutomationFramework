package Practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.LoginPage;

public class addProductTocartwithGU {

	public static void main(String[] args) throws IOException 
	{
		//Create object of all Utilities
		FileUtility fUtil=new FileUtility();
		JavaUtility jUtil=new JavaUtility();
		SeleniumUtility sUtil=new SeleniumUtility();
		
		//Read common data - Properties file				
		String URL=fUtil.readDataFromPropertfile("url");		
		String USERNAME = fUtil.readDataFromPropertfile("username");
		String PASSWORD = fUtil.readDataFromPropertfile("password");
		
		//Read data from excel file
		FileUtility file=new FileUtility();
		String PRODUCTNAME= file.readDataFromExcel("Products", 1, 2);
		
		//launch the browser
		WebDriver driver=new EdgeDriver();	
				
		//maxmimize the browser		
		sUtil.maximizeWindow(driver);
		
		//call implicitly wait
		sUtil.addImplicitlyWait(driver);
	
		//navigate to swag labs URL i.e Load URL
		driver.get(URL);
		
		/*
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		*/
		
		LoginPage lp=new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		//Click on product link		
		WebElement ele = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']"));
		String productname=ele.getText();
		ele.click();
		
		//add to cart
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		//click shopping cart link
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		
		//Capture screenshot
		String screenshotName = "addProductToCart-"+jUtil.getSystemDate();
		String path = sUtil.captureScreenShot(driver, screenshotName);
		System.out.println(path);
		
		//validate the product
		String productInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (productInCart.equals(productname))
		{
			System.out.println("PASS");
			System.out.println(productInCart);
		}
		else
		{
			System.out.println("FAIL");
			System.out.println(productname);
		}
		//logout
		driver.findElement(By.id("react-burger-menu-btn")).click();						
		driver.findElement(By.id("logout_sidebar_link")).click();			
		
		//driver.quit();
	}
	
	

}
