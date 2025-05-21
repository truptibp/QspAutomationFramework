package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.SeleniumUtility;

public class InventoryPage extends SeleniumUtility
{
	//Declaration 
	@FindBy(name="Sauce Labs Fleece Jacket")
	private WebElement productnameLink;
	
	@FindBy(id="shopping_cart_container")
	private WebElement cartcontainerBtn;	
	
	@FindBy(className="product_sort_container")
	private WebElement sortDropDown;
	
	@FindBy(id="react-burger-menu-btn")
	private WebElement menuBtn;
	
	@FindBy(id="logout_sidebar_link")
	private WebElement logoutLink;
	
	//Initialization
	public InventoryPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
			
	
	//Utilization
	public WebElement getProductnameLink() {
		return productnameLink;
	}
	
	public WebElement getCartcontainerBtn() {
		return cartcontainerBtn;
	}
	
	public WebElement getSortDropDown() {
		return sortDropDown;
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getLogoutBtn() {
		return logoutLink;
	}

	//Business Library
	public void clickOnAProduct(WebDriver driver,String productname)
	{
		driver.findElement(By.xpath("//div[text()='"+productname+"']")).click();
	}
	
	public void clickOnCartContainer()
	{
		cartcontainerBtn.click();
	}
	
	public void logoutOfApp()
	{
		menuBtn.click();
		logoutLink.click();
	}
	
	public void clickOnLowestPriceProduct(WebDriver driver,String sortoption,String productname)
	{
		handleDropDown(sortDropDown,sortoption);
		driver.findElement(By.xpath("//div[text()='"+productname+"']")).click();
		
		
	}
}

