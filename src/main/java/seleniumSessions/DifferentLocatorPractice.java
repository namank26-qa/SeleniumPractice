package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferentLocatorPractice {
	static WebDriver driver;

	public static void main(String[] args) {

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		By continueButton = By.xpath("//*[@value='Continue']");
		By pageHeader = By.tagName("h1");

		driver.findElement(continueButton).click();
		String header = driver.findElement(pageHeader).getText();
		System.out.println("---->" + header);

	}

}
