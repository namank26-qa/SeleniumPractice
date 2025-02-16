package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PseudoElement {
	public static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		
		String jspath = "return window.getComputedStyle(document.querySelector(\"label[for='input-firstname']\"), '::before').getPropertyValue('content')";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String asterisk_identifier = js.executeScript(jspath).toString();
		
		System.out.println(asterisk_identifier);
		if(asterisk_identifier.contains("*")) {
			System.out.println("The field is mandatory");
		}

	}

}
