package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class contains generic method for selenium tool
 */

public class SeleniumUtility
{
	/**
	 * This method with maximize window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}

	/**
	 * This method will mininize window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	/**
	 * This method is used to add implicitly wait for fixed seconds.(10 secs)
	 * @param driver
	 */
	public void addImplicitlyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	/**
	 * This method is used to explicitly wait for 10 secs for element to be clickable
	 * @param driver
	 */
	public void addExplicitlyWait(WebDriver driver,WebElement element)
	{	
		WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(10));
		w.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	/**
	 * This method will handle DropDown by index
	 * @param element
	 * @param i
	 */
	public void handleDropDown(WebElement element,int i)
	{
		Select s=new Select(element);
		s.selectByIndex(i);		
		
	}
	
	public void handleDropDown(String value,WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);	
		
	}
	
	public void handleDropDown(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);	
		
	}
	
	/**
	 * This method is used to handle mouse and keyboard actions.
	 * @param driver
	 */
	public void handleClickAction(WebDriver driver)
	{
		Actions action =new Actions(driver);
		action.click();
		
	}
	
	/**
	 * This method is used to handle click and hold actions.
	 * @param driver
	 */
	public void handleClickandHoldAction(WebDriver driver)
	{
		Actions action =new Actions(driver);
		action.clickAndHold();
		
	}
	
	/**
	 * This method is used to handle drag and drop actions.
	 * @param driver
	 */
	public void handleDragandDropAction(WebDriver driver,WebElement src,WebElement target)
	{
		Actions action =new Actions(driver);
		action.dragAndDrop(src, target).perform();
		
	}
	
	/**
	 * This method is used to handle mouse hover action
	 * @param driver
	 */
	public void handleMouseHoverActions(WebDriver driver,WebElement target)
	{
		Actions action =new Actions(driver);
		action.moveToElement(target).perform();
		
	}
	
	/**
	 * This method is used to handle double click actions.
	 * @param driver
	 */
	public void handleDoubleClickAction(WebDriver driver)
	{
		Actions action =new Actions(driver);
		action.doubleClick();
		
	}
	
	/**
	 * This method is used to Scroll to element action.
	 * @param driver
	 */
	public void handleScrollAction(WebDriver driver,WebElement element)
	{
		Actions action =new Actions(driver);
		action.scrollToElement(element).perform();
		
	}
	
	/**
	 * This method is used to handle RightClick actions.
	 * @param driver
	 */
	public void handleRightClickAction(WebDriver driver)
	{
		Actions action =new Actions(driver);
		action.contextClick().perform();
		
	}
	
	/**
	 * This method is used to handle frame
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		
	}
	
	/**
	 * This method is used to handle frame by name or Id
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,String framenameOrId)
	{
		driver.switchTo().frame(framenameOrId);
		
	}
	
	/**
	 * This method is used to handle frame by WebElement
	 * @param driver
	 * @param index
	 */
	public void handleFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
		
	}
	
	/**
	 * This method is used to accept the alert pop up
	 * @param driver
	 */
	public void handleAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
		
	}
	
	/**
	 * This method is used to dismiss the alert pop up
	 * @param driver
	 */
	public void handleDismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
		
	}
	
	/**
	 * This method is used to capture the message present in the pop up
	 * @param driver
	 */
	public String handleGettextAlert(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
		
	}
	
	/**
	 * This method is used to pass the text present in the pop up
	 * @param driver
	 */
	public void handleSendkeysAlert(WebDriver driver,String key)
	{
		driver.switchTo().alert().sendKeys(key);
		
	}
	
	/**
	 * This method will switch from one window to another
	 * @param driver
	 * @param WindowID
	 */
	public void handleWindow(WebDriver driver,String WindowID)
	{
		driver.switchTo().window(WindowID);
	}
	
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\ScreenShots\\"+screenShotName+".png");
		FileHandler.copy(scr, dst);
		
		return dst.getAbsolutePath();// for extent report
		
	}
}
