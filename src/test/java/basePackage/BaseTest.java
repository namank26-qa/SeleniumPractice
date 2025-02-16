package basePackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;



public class BaseTest {

	protected WebDriver driver;
	
	@Parameters({"url","browser"})
	@BeforeTest
	public void setup(String url, String browser) {
		
		
		
		switch (browser.trim().toLowerCase()) {
		case "chrome": {
			
			driver = new ChromeDriver();
			break;
		}
		case "firefox": {
			driver = new FirefoxDriver();
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + browser);
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		//driver.get("https://www.google.com/");
		driver.get(url);
		
	}
	
	@AfterTest
	public void teardown() {
		driver.quit();
		
	}
}
