package Vedaprada.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Vedaprada.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{
String productName = "Sauce Labs Bolt T-Shirt";	
	
WebDriver driver;

		
	public ProductCatalogue(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	


public void addProductsToCart(String[] productNames)
{
	for(int i = 0; i < productNames.length; i++)
	{
		driver.findElement(By.xpath("//div[text() = '"+productNames[i]+"']/../../..//button")).click();
	}
}




}

	
