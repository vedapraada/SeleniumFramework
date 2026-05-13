package Vedaprada.MyProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Vedaprada.PageObjects.CartPage;
import Vedaprada.PageObjects.Checkout;
import Vedaprada.PageObjects.CheckoutOverview;
import Vedaprada.PageObjects.LoginPage;
import Vedaprada.PageObjects.ProductCatalogue;

public class SecretSauce {

	public static void main(String[] args) throws InterruptedException {
	String url = "https://www.saucedemo.com/";
	String[] productNames = {"Sauce Labs Backpack", "Sauce Labs Bike Light", "Sauce Labs Bolt T-Shirt"};
	WebDriver driver = new ChromeDriver();	
	LoginPage loginpage = new LoginPage(driver);
	ProductCatalogue productcatalogue = loginpage.loginApplication(url, "standard_user", "secret_sauce");
	Thread.sleep(3000);	
	productcatalogue.addProductsToCart(productNames);
	CartPage cartpage = productcatalogue.clickOnAddToCartBtn();	
	boolean match = cartpage.verifyProductsInCartPage(productNames);
	Assert.assertTrue(match);
	Checkout checkout = cartpage.clickOnCheckoutBtn();
	CheckoutOverview checkoutoverview = checkout.performCheckout();				
	double[] prices = checkoutoverview.getPricesOfCartProducts(productNames);
	boolean priceMatch = checkoutoverview.verifyPriceTotal(productNames, prices);
	Assert.assertTrue(priceMatch);
	checkoutoverview.clickOnFinishBtn();
	driver.findElement(By.id("back-to-products")).click();
	driver.findElement(By.id("react-burger-menu-btn")).click();
	driver.findElement(By.linkText("Logout")).click();

	}

}
