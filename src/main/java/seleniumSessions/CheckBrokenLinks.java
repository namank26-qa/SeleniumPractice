package seleniumSessions;

import org.openqa.selenium.By;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBrokenLinks {
	public static WebDriver driver;

	public static void main(String[] args) {		
		
		driver = new ChromeDriver(); //Initialize the driver		
		
		driver.get("https://demoqa.com/links");		//Navigate to webpage

		List<WebElement> linkElements = driver.findElements(By.tagName("a")); //Find all the anchor elements
		
		Set<String> links = new HashSet<>();
		
		for(WebElement element: linkElements) {
			String url = element.getDomAttribute("href");
			links.add(url); //collecting non-duplicate urls
		}
		
		ExecutorService executor = Executors.newFixedThreadPool(50);		
		
		for(String link: links) { //Iterate over all the links	
			executor.submit(()->verifyLink(link));			
		}
		executor.shutdown();
		
		//Driver close
		driver.quit();		
	}
	
	public static void verifyLink(String url) {
		//Open connection with links
		try {
			URL link = new URL(url);
			HttpURLConnection connection = (HttpURLConnection)link.openConnection();
			connection.setConnectTimeout(3000);
			connection.connect();
			
			if(connection.getResponseCode() >= 400) { //Check if the links are responding 400+ status code, if yes then link is broken
				System.out.println(url + "-" +connection.getResponseMessage()+"-"+"is broken");
			}
		} catch (Exception e) {
			System.out.println(url + "is broken");
		}
	}

}
