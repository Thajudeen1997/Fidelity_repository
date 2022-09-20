package org.Fidelity.TestNG.Practise;

import org.testng.annotations.*;

public class DataProvider1 {
	@Test(dataProvider = "getData")
	public void test(String username, int password) {
		System.out.println(Thread.currentThread().getId());
		System.out.println("City"+ username);
		System.out.println("Pincode"+ password);
		System.out.println();
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData() {
		Object[][] obj = new Object[3][2];
		obj[0][0] = "Bangalore";
		obj[0][1] = 560060;
		obj[1][0] = "Chennai";
		obj[1][1] = 600020;
		obj[2][0] = "cochin";
		obj[2][1] = 460056;
		return obj;
	}

}
