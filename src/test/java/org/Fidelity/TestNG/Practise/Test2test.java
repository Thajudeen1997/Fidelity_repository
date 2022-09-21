package org.Fidelity.TestNG.Practise;

import org.testng.annotations.Test;

public class Test2test {
	@Test
	public void Test2(){
		System.out.println(Thread.currentThread().getId());
		System.out.println("inside test2.1");
	}
	@Test
	public void Test3() {
		System.out.println(Thread.currentThread().getId());
		System.out.println("inside test2.2");
		String hh = String.format("djjdd'%s'", "123");
		System.out.println(hh);
	}
}
