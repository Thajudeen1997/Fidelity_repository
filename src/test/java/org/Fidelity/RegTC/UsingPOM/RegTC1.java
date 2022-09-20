//package org.Fidelity.RegTC.UsingPOM;
//import java.util.List;
//import java.util.Map;
//import org.Fidelity.GeneralUtility.ExcelUtility;
//import org.Fidelity.GeneralUtility.IConstantPath;
//import org.Fidelity.GeneralUtility.JavaUtility;
//import org.Fidelity.GeneralUtility.WebdriverUtility;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import pomRepository.ApproveApplicationPage;
//import pomRepository.CommonPage;
//import pomRepository.OpenAccountPage;
//import pomRepository.StaffLoginPage;
//import pomRepository.ViewActiveCustomerPage;
//
//public class RegTC1 {
//	public static void main(String[] args)  {
//		WebdriverUtility webDriverUtility = new WebdriverUtility();
//		JavaUtility javaUtility = new JavaUtility();
//		ExcelUtility excelUtility  = new ExcelUtility();
//		excelUtility.initializeExcel(IConstantPath.EXCEL_PATH);
//		List<Map<String, String>> commonData = excelUtility.getDataFromExcelUsingListMap("CommonData");
//		WebDriver driver = webDriverUtility.launchingBrowser(commonData, 0);
//		webDriverUtility.openingWebpage(commonData, 0, 10);
//		CommonPage commonPage  = new CommonPage(driver);
//		commonPage.ByPassSecurityCheck();
//		OpenAccountPage openAccountPage = new OpenAccountPage(driver);
//		List<Map<String, String>> testDataList = excelUtility.getDataFromExcelUsingListMap("TestMap");
//		openAccountPage.OpenAccountMethod(testDataList, 1);
//		webDriverUtility.explicitWait(10);
//		String appAlert = webDriverUtility.alertGetText();
//		String AppNo = javaUtility.alertGetNoFromPopup(appAlert);
//		webDriverUtility.alertAccept();
//		commonPage.ClickStaffLogin();
//		StaffLoginPage staffLoginPage = new StaffLoginPage(driver);
//		staffLoginPage.StaffLoginMethod(commonData, 0);
//		ApproveApplicationPage approveApplicationPage  = new ApproveApplicationPage(driver);
//		approveApplicationPage.ApproveApplicationMethod(AppNo);	
//		webDriverUtility.explicitWait(10);
//		String accAlert = webDriverUtility.alertGetText();
//		String accno = javaUtility.alertGetNoFromPopup(accAlert);
//		webDriverUtility.alertAccept();
//		System.out.println("AccountNumber="+accno);
//		staffLoginPage.StaffPageHomeLink();
//		ViewActiveCustomerPage viewActiveCustomerPage = new ViewActiveCustomerPage(driver);
//		viewActiveCustomerPage.ViewActiveCustomermethod();
//		List<WebElement> columnElements = viewActiveCustomerPage.GetTableColumnElements();
//		viewActiveCustomerPage.CheckDataInViewCustomerPage(driver, accno, columnElements, "Account No.");
//		excelUtility.closingExcel();
//		webDriverUtility.closeBrowser();
//	}
//}
//
//
