package seleniumSessions;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverBasics {

	public static void main(String[] args) {
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		String title = driver.getTitle();
		if(title.equals("Google")) {
			System.out.println("Test passed");
		}
		else {
			System.err.println("Test failed");
		}
		driver.quit();

	}

}
