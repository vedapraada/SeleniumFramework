package Vedaprada.PageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vedaprada.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	
WebDriver driver;
		
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id = "user-name")
WebElement wUserName;

@FindBy(id = "password")
WebElement wPassword;

@FindBy(id = "login-button")
WebElement wLoginBtn;

public ProductCatalogue loginApplication(String url, String userNaname, String password)
{
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	goTo(url);
	wUserName.sendKeys("standard_user");
	wPassword.sendKeys("secret_sauce");
	wLoginBtn.click();
	ProductCatalogue productcatalogue = new ProductCatalogue(driver);
	return productcatalogue;
	
}

public void goTo(String url)
{
	driver.get(url);
}

}

	
