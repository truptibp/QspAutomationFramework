package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule 1- create seperate pom class for each webpage
{
	//Rule 2- Declaration
	@FindBy(id="user-name")
	private WebElement usernameText;
	
	@FindBy(name="password")
	private WebElement passwordText;
	
	@FindBy(id="login-button")
	private WebElement loginBtn;
	
	//Rule 3-Initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4-Utilization
	public WebElement getUsernameText() {
		return usernameText;
	}

	public WebElement getPasswordText() {
		return passwordText;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
	//Business Library
	/**
	 * This method will perform login Operation.
	 * @param un
	 * @param passwd
	 */
	public void LoginToApp(String un,String passwd)
	{
		usernameText.sendKeys(un);
		passwordText.sendKeys(passwd);
		loginBtn.click();
	}
	
}

