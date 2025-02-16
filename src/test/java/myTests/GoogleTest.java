package myTests;

import org.testng.Assert;
import org.testng.annotations.*;

import basePackage.BaseTest;

public class GoogleTest extends BaseTest {

	
	@Test
	public void getTitleTest() {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		Assert.assertEquals(actualTitle, "Google");
	}
}
