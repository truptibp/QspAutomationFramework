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

public class addProductTocart {

	public static void main(String[] args) throws IOException
	{
		//Read common data - Properties file (Notepad)
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String URL = p.getProperty("url");
		String USERNAME = p.getProperty("username");
		String PASSWORD = p.getProperty("password");
		
		//Read data from excel file
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestDataForAutomation.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		Sheet sh = wb.getSheet("Products");
		Row rw = sh.getRow(1);
		Cell cl = rw.getCell(2);
		String PRODUCTNAME = cl.getStringCellValue();
		
		//launch the brower
		WebDriver driver=new EdgeDriver();	
		//maxmimize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//navigate to swag labs
		driver.get(URL);
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();
		
		//Click on product link		
		WebElement ele = driver.findElement(By.xpath("//div[text()='"+PRODUCTNAME+"']"));
		//WebElement ele = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']"));)
		String productname=ele.getText();
		ele.click();
		
		//add to cart
		driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
		//click shopping cart link
		driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();
		
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
		
		driver.quit();
	}

}
