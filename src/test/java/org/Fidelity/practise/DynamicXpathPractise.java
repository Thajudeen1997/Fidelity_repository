package org.Fidelity.practise;

import org.Fidelity.GeneralUtility.ExcelUtility;
import org.Fidelity.GeneralUtility.IConstantPath;
import org.Fidelity.GeneralUtility.JavaUtility;
import org.Fidelity.GeneralUtility.WebdriverUtility;
import org.openqa.selenium.WebDriver;

import pomRepository.CommonPage;
import pomRepository.PageLink;

public class DynamicXpathPractise {
	public static void main(String[] args) {
		WebdriverUtility webDriverUtility = new WebdriverUtility();
		JavaUtility javaUtility = new JavaUtility();
		ExcelUtility excelUtility  = new ExcelUtility();
		excelUtility.initializeExcel(IConstantPath.EXCEL_PATH);
//		WebDriver driver = webDriverUtility.launchingBrowser(excelUtility.getDataFromExcel("CommonData", 4, 1));
//		webDriverUtility.openingWebpage(12, excelUtility.getDataFromExcel("CommonData", 0, 1));

		//CommonPage commonPage  = new CommonPage(driver);
//		commonPage.ByPassSecurityCheck();
//		commonPage.ClickDynamicPathAction(PageLink.OPEN_ACCOUNT);
	}

}
