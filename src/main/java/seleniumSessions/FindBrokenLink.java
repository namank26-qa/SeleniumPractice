package seleniumSessions;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

public class FindBrokenLink {
	public static WebDriver driver;

	public static void main(String[] args) throws MalformedURLException {
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/broken");
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		for(WebElement e: allLinks) {
			String l= e.getDomAttribute("href");
			verifyLink(l);
		}
		

	}
	
	public static void verifyLink(String url) throws MalformedURLException{
		try {
			URL link = new URL(url);
			HttpURLConnection httpurlconnection = (HttpURLConnection) link.openConnection();
			httpurlconnection.setConnectTimeout(3000);
			int responsecode = httpurlconnection.getResponseCode();
			if(responsecode>=400) {
				System.out.println(url + " - "+ httpurlconnection.getResponseMessage() + "is a broken link");
			}
			else {
				System.out.println(url + " - "+ httpurlconnection.getResponseMessage());
			}
		}
		catch(Exception e){
			System.out.println(url + " - is a broken link");
		}		
	}

}
