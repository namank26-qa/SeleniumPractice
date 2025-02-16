package testngsessions;

import org.testng.annotations.*;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Testngfirstsession {
	
	
	
	@BeforeSuite
	public void beforeSuiteMethod() {
		System.out.println("beforeSuiteMethod");
	}
	
	@BeforeTest
	public void beforeTestMethod() {
		System.out.println("beforeTestMethod");
	}
	
	@BeforeClass
	public void beforeClassMethod() {
		System.out.println("beforeClassMethod");
	}
	
	@BeforeMethod
	public void beforeMethodMethod() {
		System.out.println("beforeMethodMethod");
	}
	
	
	@Test
	public void testMethodA() {
		System.out.println("test method A");
	}
	
	@AfterSuite
	public void AfterSuiteMethod() {
		System.out.println("After SuiteMethod");
	}
	
	@AfterTest
	public void AfterTestMethod() {
		System.out.println("AfterTestMethod");
	}
	
	@AfterClass
	public void AfterClassMethod() {
		System.out.println("AfterClassMethod");
	}
	
	@BeforeMethod
	public void AfterMethodMethod() {
		System.out.println("AfterMethodMethod");
	}
	
	
	@Test
	public void testMethodB() {
		System.out.println("test method B");
	}
	
	@Test
	public void testMethodC() {
		System.out.println("test method C");
	}
	
	

}
