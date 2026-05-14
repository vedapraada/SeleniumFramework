package orangeHRM;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OrangeHRM {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@Test(priority = 1)
	public void openApplication()
	{
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	@Test(priority = 2)
	public void login()
	{
		driver.findElement(By.xpath("//input[@name = 'username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name = 'password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space() = 'Login']")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//div[contains(@class, 'grid-item')])[1]")));
	}
	
	@Test(priority = 3)
	public void verifyLogo()
	{
		Assert.assertTrue(false);
	}
	
	@Test(priority = 4, dependsOnMethods = {"verifyLogo"})
	public void logout()
	{
		driver.close();
	}

}
