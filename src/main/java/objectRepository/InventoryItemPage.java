package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage 
{
	@FindBy(xpath="//button[text()='Add to cart']")
	private WebElement addTocartBtn;
	
	public WebElement getAddTocartBtn() {
		return addTocartBtn;
	}

	public InventoryItemPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	public void clickOnAddToCartBtn()
	{
		addTocartBtn.click();
	}
	
}
