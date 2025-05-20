package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.locators.RelativeLocator;

public class OrangeHRMHiddenMenu {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://orangehrm.com/");
		
		driver.manage().window().maximize();
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/ul/li[1]/a"))).build().perform();
	/*	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement peopleManagementLink = wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"//div[@id='navbarSupportedContent']//ul//li//ul/li[contains(text(),'People Management')]")))); */ 
		WebElement peopleManagementLink = driver.findElement(By.xpath("//div[@id='navbarSupportedContent']//ul//li//ul/li[contains(text(),'People Management')]"));
		System.out.println(peopleManagementLink.getText());
		//driver.findElement(with(By.xpath("")).below())
	}

}
