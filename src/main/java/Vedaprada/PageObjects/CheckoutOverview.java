package Vedaprada.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Vedaprada.AbstractComponents.AbstractComponents;

public class CheckoutOverview extends AbstractComponents{
	
	
WebDriver driver;

		
	public CheckoutOverview(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css = ".inventory_item_name")
List<WebElement> productsInCheckoutPage;

@FindBy(css = ".summary_total_label")
WebElement wTotalPrice;

@FindBy(css = ".summary_tax_label")
WebElement wTax;

@FindBy(id = "finish")
WebElement finishBtn;

public double[] getPricesOfCartProducts(String[] productNames)
{
	double[] price = new double[productNames.length];
	for(int i = 0; i < productNames.length; i++)
	{
		price[i] = Double.parseDouble(driver.findElement(By.xpath("//div[@class = 'cart_item_label']//div[text() = '"+productNames[i]+"']/../..//div[@class='inventory_item_price']")).getText().split("\\$")[1]);
	}
	return price;
}

public boolean verifyPriceTotal(String[] productNames, double[] price)
{
	double sum = 0.0;
	String expectedTotalPrice = wTotalPrice.getText().split("\\$")[1];
	String taxAmount = wTax.getText().split("\\$")[1];
	
	for(int i = 0; i < productNames.length; i++)
	{
		sum = sum + price[i];
	}
	sum = sum + Double.parseDouble(taxAmount);
	if(sum == Double.parseDouble(expectedTotalPrice))
	return true;
	return false;
	
}

public void clickOnFinishBtn()
{
	finishBtn.click();
}

}

	
