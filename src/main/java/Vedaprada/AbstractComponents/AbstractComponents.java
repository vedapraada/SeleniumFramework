package Vedaprada.AbstractComponents;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Vedaprada.PageObjects.CartPage;

public class AbstractComponents{
	WebDriver driver;
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	@FindBy(css = ".shopping_cart_link")
	WebElement wShoppingCartBtn; 

	public void scroll(int xAxis, int yAxis)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+xAxis+","+yAxis+")");
	}
	
	public CartPage clickOnAddToCartBtn()
	{
		scroll(0, -100);
		wShoppingCartBtn.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}

}
