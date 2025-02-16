package seleniumSessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

	public static void main(String[] args) {

		BrowserUtil br = new BrowserUtil(); // object reference for BrowserUtil class
		WebDriver driver = br.initDriver("edge");

		br.launchURL("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		ElementUtil el = new ElementUtil(driver); // object reference for ElementUtil class

		// Element Repository of Registration page
		By fname = By.id("input-firstname");
		By lname = By.id("input-lastname");
		By email = By.id("input-email");
		By telephone = By.id("input-telephone");
		By password = By.id("input-password");
		By confirmPassword = By.id("input-confirm");
		By policyCheck = By.name("agree");
		By continueButton = By.xpath("//*[@value='Continue']");
		By pageHeader = By.tagName("h1");

		// calling the generic send keys function
		el.enterText(fname, "Naman");
		el.enterText(lname, "Kumar");
		el.enterText(email, "namank@test.com");
		el.enterText(telephone, "9874563210");
		el.enterText(password, "Test@1234");
		el.enterText(confirmPassword, "Test@1234");
		el.performClick(policyCheck);
		el.performClick(continueButton);
		String successmsg = el.captureText(pageHeader);
		
		System.out.println(successmsg);
//		if(successmsg.contains("Your Account Has Been Created!"))
		
		//close the browser
		br.closeBrowserSession();
	}

}
