package Vedaprada.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Vedaprada.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	
	
WebDriver driver;
		
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css = ".inventory_item_name")
List<WebElement> productsInCart;

@FindBy(id = "checkout")
WebElement wCheckoutBtn;

public boolean verifyProductsInCartPage(String[] productNames)
{
	boolean ifFound = false;
	for(int i = 0; i<productNames.length; i++)
	{
		if(productNames[i].equalsIgnoreCase(productsInCart.get(i).getText()))
		{
			ifFound = true;
		}
		else
		{
			ifFound = false;
		}
		
	}
	return ifFound;	
}
public Checkout clickOnCheckoutBtn()
{
	wCheckoutBtn.click();
	Checkout checkout = new Checkout(driver);
	return checkout;
}
	
}



	
