package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ElementUtil {

	private WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
	}

	// method to locate elements
	public WebElement locateElement(By locator) {

		return driver.findElement(locator); //

	}

	// method to enter text field
	public void enterText(By locator, String text) {
		if (text == null || text.equals("")) {
			throw new RuntimeException("====Please provide value for text field====");
		} else {
			locateElement(locator).sendKeys(text);
		}

	}
	
	//method to perform click
	public void performClick(By locator) {
		driver.findElement(locator).click();
	}
	
	//method to capture text label
	
	public String captureText(By locator) {
		return driver.findElement(locator).getText();
	}

}
