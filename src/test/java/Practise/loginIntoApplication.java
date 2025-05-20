package Practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class loginIntoApplication {

	public static void main(String[] args) 
	{
		//launch the brower
		WebDriver driver=new EdgeDriver();	
		//maxmimize the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//navigate to swag labs
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//logout
		driver.findElement(By.id("react-burger-menu-btn")).click();						
		driver.findElement(By.id("logout_sidebar_link")).click();
		
		//driver.quit();
		
	}

}
