package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class ShadowDOMAssignment {
	
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		driver = new ChromeDriver();
		
		//page->DOM->ShadowDOM->iframe->input
		
		driver.get("https://selectorshub.com/iframe-in-shadow-dom/");
		
		driver.manage().window().maximize();
		Thread.sleep(5000);
		String jspath = "return document.querySelector(\"#userName\").shadowRoot.querySelector(\"#pact1\")";
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		WebElement iframeAddress = (WebElement)js.executeScript(jspath);
		
		driver.switchTo().frame(iframeAddress);
		
		WebElement destiny_textbox = driver.findElement(By.id("glaf"));
		destiny_textbox.sendKeys("Success");
		
		
		

	}

}
