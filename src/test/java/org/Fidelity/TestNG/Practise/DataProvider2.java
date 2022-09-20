package org.Fidelity.TestNG.Practise;

import java.util.List;
import java.util.Map;

import org.Fidelity.GeneralUtility.ExcelUtility;
import org.Fidelity.GeneralUtility.IConstantPath;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {
	@Test(dataProvider = "getData")
	public void test(String username, String password) {
		System.out.println(Thread.currentThread().getId());
		System.out.println("Key---->"+ username);
		System.out.println("Value----->"+ password);
		System.out.println();
	}
	
	@DataProvider(parallel= true)
	public Object[][] getData() {
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.initializeExcel(IConstantPath.EXCEL_PATH);
		String[][] obj = excelUtility.getMultipleData("Object");
		return obj;
	}

}
