package seleniumSessions;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

public class Amazon_Tab_Switch_Assignment {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new EdgeDriver();

		driver.get("https://www.amazon.com/");
		Thread.sleep(2000);

		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).pause(2000).sendKeys(Keys.TAB).pause(2000).sendKeys(Keys.TAB).pause(2000)
				.sendKeys(Keys.TAB).pause(2000).sendKeys(Keys.TAB).pause(2000).sendKeys("macbook").sendKeys(Keys.ENTER)
				.build().perform();

	}

}
