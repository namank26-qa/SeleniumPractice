package seleniumSessions;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class WebTableHandlingAssignment {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();

		driver.get(
				"https://www.espncricinfo.com/series/new-zealand-vs-sri-lanka-2024-25-1443537/new-zealand-vs-sri-lanka-3rd-t20i-1443545/full-scorecard");

		String playerName = "Bhanuka Rajapaksa";

		Thread.sleep(3000);

		By playerDetails = By.xpath("//span[text()='" + playerName + "']/ancestor::tr//td");

		List<WebElement> playerDetailsList = driver.findElements(playerDetails);

		List<String> playerDetailsText = new ArrayList<String>();

		for (WebElement e : playerDetailsList) {
			String text = e.getText();
			playerDetailsText.add(text);
		}
		System.out.println(playerDetailsText);
	}
}
