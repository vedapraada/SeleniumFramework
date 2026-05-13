package Vedaprada.MyProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Vedaprada.PageObjects.LoginPage;

public class E2EFlow {

	public static void main(String[] args) throws InterruptedException {
	String productName = "Sauce Labs Bolt T-Shirt";
		// TODO Auto-generated method stub
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();
	driver.findElement(By.xpath("//button[@data-test = 'add-to-cart-sauce-labs-bolt-t-shirt']")).click();
	Thread.sleep(3000);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0, -100)");
	driver.findElement(By.cssSelector(".shopping_cart_link")).click();
	String ActualProductName = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
	Assert.assertEquals(productName, ActualProductName);
	driver.findElement(By.id("checkout")).click();
	driver.findElement(By.id("first-name")).sendKeys("Test First name");
	driver.findElement(By.id("last-name")).sendKeys("Test Last name");
	driver.findElement(By.id("postal-code")).sendKeys("560098");
	driver.findElement(By.id("continue")).click();
	String ActualProductName2 = driver.findElement(By.cssSelector(".inventory_item_name")).getText();
	Assert.assertEquals(productName, ActualProductName2);
	System.out.println(Double.parseDouble(driver.findElement(By.cssSelector(".summary_tax_label")).getText().split("\\$")[1]));
	js.executeScript("window.scrollBy(0, 200)");
	driver.findElement(By.id("finish")).click();
	driver.findElement(By.id("back-to-products")).click();
	driver.findElement(By.id("react-burger-menu-btn")).click();
	driver.findElement(By.linkText("Logout")).click();

	}

}
