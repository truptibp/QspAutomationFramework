package InventoryTests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListnersImplementation.class)
public class AddProductToCartTest extends BaseClass
{
	@Test(groups="SmokeSuite")
	public void tc_01_AddProductToCartTest() throws IOException
	{
		
		//Steps to Read data from excel file 
		FileUtility file=new FileUtility();
		String PRODUCTNAME= file.readDataFromExcel("Products", 1, 2);		
		
		//Click on product link	
		InventoryPage ip=new InventoryPage(driver);
		ip.clickOnAProduct(driver, PRODUCTNAME);
		
		//Click on add to cart
		InventoryItemPage iip=new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();
		
		//Navigate to cart
		ip.clickOnCartContainer();		
		
		//validate the product
		CartPage cp=new CartPage(driver);
		String productIncart = cp.captureItemName();
		
		Assert.assertEquals(productIncart, PRODUCTNAME);
		
		Assert.assertTrue(productIncart.equals(PRODUCTNAME));
		
//		if (productIncart.endsWith(PRODUCTNAME))
//		{
//			System.out.println("PASS");
//			System.out.println(productIncart);
//		}
//		else
//		{
//			System.out.println("FAIL");
//		}
		
		
	}
	
	@Test
	public void sample() 
	{
		Assert.fail();
		System.out.println("Sample");
	}
}
