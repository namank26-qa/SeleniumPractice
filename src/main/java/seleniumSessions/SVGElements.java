package seleniumSessions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SVGElements {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://petdiseasealerts.org/forecast-map");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
		

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
		List<WebElement> statesList = driver.findElements(
				By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @id='regions']/*[name()='g']"));
		System.out.println(statesList.size());
		
		Actions act = new Actions(driver);

		//List<String> statesName = new ArrayList<String>();
		for (WebElement e : statesList) {
			act.moveToElement(e).perform();
			String s = e.getDomAttribute("id");
			//statesName.add(s);
			System.out.println(s);
		}
		//System.out.println(statesName);
	}

}
