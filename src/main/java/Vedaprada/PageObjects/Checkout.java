package Vedaprada.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vedaprada.AbstractComponents.AbstractComponents;

public class Checkout extends AbstractComponents{
	
	
WebDriver driver;
		
	public Checkout(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(id = "first-name")
WebElement wFirstName;

@FindBy(id = "last-name")
WebElement wLasttName;

@FindBy(id = "postal-code")
WebElement wPostalCode;

@FindBy(id = "continue")
WebElement wcontinueBtn;


public CheckoutOverview performCheckout()
{
	driver.findElement(By.id("first-name")).sendKeys("Test First name");
	driver.findElement(By.id("last-name")).sendKeys("Test Last name");
	driver.findElement(By.id("postal-code")).sendKeys("560098");
	driver.findElement(By.id("continue")).click();
	CheckoutOverview checkoutoverview = new CheckoutOverview(driver);
	return checkoutoverview;

}



}

	
