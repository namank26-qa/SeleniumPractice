package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowserPractice {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
		String browser = "chrome";
		
		switch(browser.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		default: 
			System.out.println("Provide correct browser name");
			throw new RuntimeException("====Invalid Browser====");
		}
		
		driver.get("");
		
		 

	}

}
