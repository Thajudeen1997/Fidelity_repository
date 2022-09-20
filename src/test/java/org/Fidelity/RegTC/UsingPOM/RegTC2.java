//package org.Fidelity.RegTC.UsingPOM;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//
//import org.Fidelity.GeneralUtility.ExcelUtility;
//import org.Fidelity.GeneralUtility.IConstantPath;
//import org.Fidelity.GeneralUtility.JavaUtility;
//import org.Fidelity.GeneralUtility.WebdriverUtility;
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.Select;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//import pomRepository.ApplyDebitCardPage;
//import pomRepository.ApproveApplicationPage;
//import pomRepository.CommonPage;
//import pomRepository.OpenAccountPage;
//import pomRepository.StaffLoginPage;
//import pomRepository.ViewActiveCustomerPage;
//
//public class RegTC2 {
//	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
//		WebdriverUtility webDriverUtility = new WebdriverUtility();
//		JavaUtility javaUtility = new JavaUtility();
//		ExcelUtility excelUtility  = new ExcelUtility();
//		excelUtility.initializeExcel(IConstantPath.EXCEL_PATH);
//		List<Map<String, String>> commonData = excelUtility.getDataFromExcelUsingListMap("CommonData");
//		WebDriver driver = webDriverUtility.launchingBrowser(commonData, 0);
//		webDriverUtility.openingWebpage(commonData, 0, 10);
//
//		CommonPage commonPage  = new CommonPage(driver);
//		commonPage.ByPassSecurityCheck();
//		OpenAccountPage openAccountPage = new OpenAccountPage(driver);
//		List<Map<String, String>> testData = excelUtility.getDataFromExcelUsingListMap("TestMap");
//		openAccountPage.OpenAccountMethod(testData, 1);
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
//		commonPage.ClickHomeLink();
//		
//		ApplyDebitCardPage applyDebitCardPage = new ApplyDebitCardPage(driver);
//		applyDebitCardPage.ApplyDebitCardMethod(testData, 1, accno);
//		
//		webDriverUtility.explicitWait(10);
//		
//		String text = webDriverUtility.alertGetText();
//		String number = javaUtility.alertGetNoFromPopup(text);
//		String cardNo = javaUtility.getDebitcardNo(number);
//		String cardPin = javaUtility.getDebitcardPin(number);
//		Thread.sleep(4000);
//		webDriverUtility.alertAccept();
//		
//		System.out.println("card no = " + cardNo);
//		System.out.println("card pin=" + cardPin);
//		commonPage.ClickStaffLogin();
//		ViewActiveCustomerPage viewActiveCustomerPage  = new ViewActiveCustomerPage(driver);
//		viewActiveCustomerPage.ViewActiveCustomermethod();
//		
//
//		excelUtility.closingExcel();
//		webDriverUtility.closeBrowser();
//
//	}
//
//}
