package org.Fidelity.TestNG.Practise;

import org.testng.annotations.Test;

public class Test1_Test {
	@Test
	public void Run1() {
		String browser = System.getProperty("browser");
		System.out.println(browser);
		System.out.println(Thread.currentThread().getId());
		System.out.println("inside test1.1");
	}
//	@Test
//	public void Run2() {
//		System.out.println(Thread.currentThread().getId());
//		System.out.println("inside test1.2");
//	}
//	@Test
//	public void Run3() {
//		System.out.println(Thread.currentThread().getId());
//		System.out.println("inside test1.3");
//	}
}


