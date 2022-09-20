package org.Fidelity.practise;

import org.Fidelity.GeneralUtility.DataConversion;
import org.Fidelity.GeneralUtility.ExcelUtility;
import org.Fidelity.GeneralUtility.IConstantPath;
import org.Fidelity.GeneralUtility.JavaUtility;
import org.Fidelity.GeneralUtility.WebdriverUtility;
import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;

public class UsingUtilities {
	public static void main(String[] args) {
		JavaUtility javautility = new JavaUtility();
//		WebdriverUtility webdriverutility = new WebdriverUtility();
//		ExcelUtility excelutility = new ExcelUtility();
//		WebDriver driver = webdriverutility.launchingBrowser("chrome");
//		excelutility.initializeExcel(IConstantPath.EXCEL_PATH);
//		webdriverutility.openingWebpage(driver, 12, excelutility.getDataFromExcel("CommonData", 0, 1));
//		excelutility.closingExcel(driver);
//		webdriverutility.alertAccept();
//		 String appno = javautility.alertAppNo(driver);
		 int random = javautility.getRandomNumber(100);
		 System.out.println("Thaju"+ random);
		 System.out.println("Thaju"+ random);
	}

}
