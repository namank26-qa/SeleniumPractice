package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

public class GoogleSearch {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		By textbox_search = By.name("q");
		By suggestionsList = By.xpath("//ul[@class='G43f7e']/li//div[@class='wM6W7d']//span");

		performSearch(textbox_search, suggestionsList, "speaker", "rajya");

		driver.quit();
	}
	
	public static WebElement locateElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static List<WebElement> locateElements(By locator) {
		return driver.findElements(locator);
	}
	
	public static void performSearch(By textbox_search,By suggestionsList, String wordtosearch, String suggestionpick) throws InterruptedException {
		locateElement(textbox_search).sendKeys(wordtosearch);
		
		Thread.sleep(4000);
		
		List<WebElement> searchList = locateElements(suggestionsList);
		System.out.println(searchList.size());
		
		for (WebElement s : searchList) {
			String text = s.getText();
			if (text.contains(suggestionpick)) {
				s.click();
				break;
			}
		}
		
		
	}

}
