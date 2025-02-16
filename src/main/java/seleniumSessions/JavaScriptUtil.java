package seleniumSessions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {

	public WebDriver driver;
	public JavascriptExecutor js;
	
	public JavaScriptUtil(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor)driver;
	}
	
	public String getPageTitlebyJavaScript() {
		return js.executeScript("return document.title;").toString();
	}
	
	public String getPageURLbyJavaScript() {
		return js.executeScript("return document.URL;").toString();
		
	}
	
	public void refreshBrowserbyJavaScript() {
		js.executeScript("history.go(0);");
	}
	
	public void navigateToBackPage() {
		js.executeScript("history.go(-1)");
	}
	
	public void navigateToForwardPage() {
		js.executeScript("history.go(1)");
	}
	
	public void pushalert(String message) {
		js.executeScript("alert("+message+")");
	}
	
	public String allpagetext() {
		return js.executeScript("return document.documentElement.innerText;").toString();
	}
	
	public void scrollPageDown() {
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollPageUp() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public void scrollPageDown(String height) {
		js.executeScript("window.scrollTo(0, '" + height + "')");
	}	

	public void scrollIntoView(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void clickElementByJS(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	
	public void sendKeysByJSUsingId(String id, String value) {
		js.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}
}
