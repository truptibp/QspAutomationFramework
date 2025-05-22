package objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
	@FindBy(className="inventory_item_name")
	private WebElement iteminfo;
	
	@FindBy(xpath="//button[text()='Remove']")
	private WebElement removeBtn;

	public WebElement getIteminfo() {
		return iteminfo;
	}

	public WebElement getRemoveBtn() {
		return removeBtn;
	}
	
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Business library
	/**
	 * This method will capture the product name and return to caller
	 * @return
	 */
	public String captureItemName()
	{
		return iteminfo.getText();
	}
	
	/**
	 * This method will click on remove btn
	 */
	public void clickOnRemoveBtn()
	{
		removeBtn.click();
	}

}
