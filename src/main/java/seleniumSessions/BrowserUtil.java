package seleniumSessions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtil {
	private WebDriver driver;

	// method to initialize browser specific driver
	public WebDriver initDriver(String browsername) {

		// cases for different browsers
		switch (browsername.trim().toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
			
		case "edge":
			driver = new EdgeDriver();
			break;

		default:
			System.out.println("Provide correct browser name");
			throw new RuntimeException("====Invalid Browser====");
		}
		return driver;
	}

	// method to launch URL
	public void launchURL(String url) {
		if (url == null) {
			throw new RuntimeException("====Please provide URL====");
		} else {
			driver.get(url);
		}
	}

	// method to retrieve page title
	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;

	}

	// method to close the browser session
	public void closeBrowserSession() {
		driver.quit();
	}
}
