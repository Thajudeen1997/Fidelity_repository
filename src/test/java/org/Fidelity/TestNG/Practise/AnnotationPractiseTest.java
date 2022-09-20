package org.Fidelity.TestNG.Practise;

import org.testng.Reporter;
import org.testng.annotations.*;

public class AnnotationPractiseTest {
	@BeforeSuite
	public void BeforeSuite() {
		System.out.println("BeforeSuite");	
	}
	@BeforeTest
	public void BeforeTest() {
		System.out.println("Before Test");
	}
	@BeforeClass
	public void BeforeClass() {
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void BeforeMethod1() {
		System.out.println("Before Method1");
	}
	@BeforeMethod
	public void BeforeMethod2() {
		System.out.println("Before Method2");
	}
	@Test
	public void Test1() {
		System.out.println("Test1");
	}
	@Test
	public void Test2() {
		System.out.println("Test2");	
	}
	@AfterMethod
	public void AfterMethod1() {
		System.out.println("After Method1");
	}
	@AfterMethod
	public void AfterMethod2() {
		System.out.println("After Method2");
	}
	@AfterTest
	public void AfterTest1() {
		System.out.println("After Test1");
	}
	@AfterTest
	public void AfterTest2() {
		System.out.println("After Test2");
	}
}
