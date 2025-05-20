package InventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
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
public class AddLowestPriceProductToCartTest extends BaseClass
{	

	@Test(groups="RegressionSuite")
	public void tc_01_AddLowestPriceProductToCartTest() throws IOException
	{		

		// Read Data from excel file
		String PRODUCTNAME = fUtil.readDataFromExcel("Products", 4, 3); // Run time data
		String SORTOPTION = fUtil.readDataFromExcel("Products", 4, 2);
		
		// Click on a product
		InventoryPage ip = new InventoryPage(driver);
		ip.clickOnLowestPriceProduct(driver, SORTOPTION, PRODUCTNAME);

		// Click on add to cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Navigate to Cart
		ip.clickOnCartContainer();

		// Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String ProductIncart = cp.captureItemName();
		if (ProductIncart.equals(PRODUCTNAME)) {
			System.out.println("PASS");
			System.out.println(ProductIncart);
		} else {
			System.out.println("FAIL");
		}

	}
	
	@Test()
	public void sample()
	{
		System.out.println("samplev test");
	}

}
