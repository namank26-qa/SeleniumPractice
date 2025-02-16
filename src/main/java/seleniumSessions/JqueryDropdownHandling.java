package seleniumSessions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

public class JqueryDropdownHandling {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google-vignette");

		Thread.sleep(2000);
		String choiceSelection = "multi";
		String choicevalue[] = {"choice 1", "Choice 6 1", "choice 6 2 3", "CHOICE 2 2", "choice 2", "choice 4"};
		By dropdownSelection = By.xpath("//div[@class='comboTreeWrapper']//input[@id='justAnInputBox']");
		By selectionList = By.xpath("//h3[text()='Multi Selection']//following-sibling::div//child::div//span[@class='comboTreeItemTitle']");
		
		selectchoices(dropdownSelection, selectionList, choiceSelection, choicevalue);

	}

	public static WebElement locateElement(By locator) {
		return driver.findElement(locator);
	}

	public static List<WebElement> locateElements(By locator) {
		return driver.findElements(locator);
	}

	public static void performClick(By locator) {
		driver.findElement(locator).click();
	}

	public static void selectchoices(By dropdownselection, By selectionList, String selectionType,
			String... choicevalue) {
		performClick(dropdownselection);
		List<WebElement> choiceList = locateElements(selectionList);

		System.out.println(choiceList.size());

		if (selectionType.equalsIgnoreCase("All")) {
			for (WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);
				e.click();
			}

		} else if (selectionType.equalsIgnoreCase("Single") || selectionType.equalsIgnoreCase("Multi")) {
			for (WebElement e : choiceList) {
				String text = e.getText();
				System.out.println(text);

				for (String s : choicevalue) {
					if (text.equalsIgnoreCase(s)) {
						e.click();
					}
				}
			}
		}
	}

}
