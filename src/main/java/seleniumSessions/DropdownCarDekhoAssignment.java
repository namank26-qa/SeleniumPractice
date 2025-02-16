package seleniumSessions;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebElement;

public class DropdownCarDekhoAssignment {
	
	static WebDriver driver;

	public static void main(String[] args) {
		driver = new ChromeDriver();
		driver.get("https://www.cardekho.com/");
		
		By vehicleTypedropdown = By.xpath("//div[@id='new_budget']//child::input[@id='vehicleTypeName']");
		getElement(vehicleTypedropdown).click();
		
		By vehicleTypeList = By.xpath("//li[contains(@class,'gs_ta_choice')]");
		List<WebElement> vehicleTypeoptions = getElements(vehicleTypeList);
		
		selectVehicleType(vehicleTypeoptions, "Luxury");
		

	}
	
	public static void selectVehicleType(List<WebElement> options, String type) {
		boolean flag = false;
		for(WebElement e: options) {
			String text = e.getText();
			System.out.println(text);
			if(text.contains(type)) {
				e.click();
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println(type + " selected successfully");
		}
		else {
			System.out.println(type + " option not found");
		}
	}
	
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);		
	}
	
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
