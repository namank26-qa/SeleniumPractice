package seleniumSessions;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeTaken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getPageSource());

		driver.get(
				"https://automation.lambdatest.com/share?isThemeEnabled=true&selectedTab=home&shareId=UZPIOJPCTDUBKP90B6ZQFHKFSBUOZ2GM4PKICDZ184DIQ4I60J0D0ZIA3G1YQXTC&themeVersion=v2");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		By timeTakentext = By.xpath("//*[@id='timeTaken']/span[2]");
		By totalTimetakentext = By.xpath("//*[@id='video-container']/div/div/div[2]/span[2]");

		String timeTaken1 = wait.until(ExpectedConditions.presenceOfElementLocated(timeTakentext)).getText();

		String subtimetaken = timeTaken1.substring(0, 2);
		System.out.println(subtimetaken);
		int timetaken1 = Integer.parseInt(subtimetaken);

		String timeTaken2 = wait.until(ExpectedConditions.presenceOfElementLocated(totalTimetakentext)).getText();

		String subtimetaken2 = timeTaken2.substring(2, 4);	
		System.out.println(subtimetaken2);
		int timetaken2 = Integer.parseInt(subtimetaken2);

		if (timetaken1 != timetaken2) {
			System.out.println("Not equal time");
		}

	}

}
