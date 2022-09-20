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
//import pomRepository.CommonPage;
//import pomRepository.OpenAccountPage;
//
//public class RegTC3 {
//	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
//		WebdriverUtility webDriverUtility = new WebdriverUtility();
//		JavaUtility javaUtility = new JavaUtility();
//		ExcelUtility excelUtility  = new ExcelUtility();
//		excelUtility.initializeExcel(IConstantPath.EXCEL_PATH);
//		List<Map<String, String>> list = excelUtility.getDataFromExcelUsingListMap("CommonData");
//		WebDriver driver = webDriverUtility.launchingBrowser(list, 0);
//		webDriverUtility.openingWebpage(list, 0, 10);
//		CommonPage commonPage =  new CommonPage(driver);
//		commonPage.ByPassSecurityCheck();
//		OpenAccountPage openAccountPage = new OpenAccountPage(driver);
//		excelUtility
//		openAccountPage.OpenAccountMethod(list, 3);
//		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
//		driver.findElement(By.name("name")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 1, 1));
//
//		WebElement gender = driver.findElement(By.name("gender"));
//		webDriverUtility.selectClass(gender, excelUtility.getDataFromExcel("TestData-accopening", 2, 1));
//
//		driver.findElement(By.name("mobile")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 3, 1));
//		driver.findElement(By.name("email")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 4, 1));
//
//
//
//		WebElement dob = driver.findElement(By.name("dob"));
//
//		dob.click();
//
//		dob.sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 5, 1));
//		driver.findElement(By.name("pan_no")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 6, 1));
//		driver.findElement(By.name("citizenship")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 7, 1));
//		driver.findElement(By.name("homeaddrs")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 8, 1));
//
//		WebElement state = driver.findElement(By.name("state"));
//		webDriverUtility.selectClass(state, excelUtility.getDataFromExcel("TestData-accopening", 9, 1));
//
//		WebElement city = driver.findElement(By.name("city"));
//		webDriverUtility.selectClass(city, excelUtility.getDataFromExcel("TestData-accopening", 10, 1));
//
//		driver.findElement(By.name("pin")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 11, 1));
//		driver.findElement(By.name("arealoc")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 12, 1));
//
//		WebElement acctype = driver.findElement(By.name("acctype"));
//		webDriverUtility.selectClass(acctype, excelUtility.getDataFromExcel("TestData-accopening", 13, 1));
//
//		driver.findElement(By.name("submit")).click();
//		driver.findElement(By.name("cnfrm-submit")).click();
//		webDriverUtility.explicitWait(10);
//		String appAlert = webDriverUtility.alertGetText();
//		System.out.println(appAlert);
//		String AppNo = javaUtility.alertGetNoFromPopup(appAlert);
//		webDriverUtility.alertAccept();
//		driver.findElement(By.linkText("Staff Login")).click();
//		driver.findElement(By.name("staff_id")).sendKeys(excelUtility.getDataFromExcel("CommonData", 1, 1));
//		driver.findElement(By.name("password")).sendKeys(excelUtility.getDataFromExcel("CommonData", 2, 1));
//		driver.findElement(By.name("staff_login-btn")).click();
//		driver.findElement(By.name("apprvac")).click();
//		driver.findElement(By.name("application_no")).sendKeys(AppNo);
//		driver.findElement(By.name("search_application")).click();
//		driver.findElement(By.name("approve_cust")).click();
//		webDriverUtility.explicitWait(10);
//		String accNoAlert = webDriverUtility.alertGetText();
//		System.out.println(accNoAlert);
//		String accno = javaUtility.alertGetNoFromPopup(accNoAlert);
//		webDriverUtility.alertAccept();
//		
//		driver.findElement(By.name("home")).click();
//		driver.findElement(By.name("view_cust_by_ac")).click();
//		driver.findElement(By.name("account_no")).sendKeys(accno);
//		driver.findElement(By.name("submit_view")).click();
//		 String AvlBalInitial = driver.findElement(By.xpath("//label[contains(text(),'Available Balance')]")).getText();
//		 String[] split = AvlBalInitial.split(":");
//		 String keyInitial = split[0].trim();
//		 String valueInitial  =split[1].trim();
//		System.out.println(keyInitial);
//		System.out.println(valueInitial);
//		
////		List<WebElement> columnDatas = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td"));
////		String get = null;
////		for(int i =0 ; i<columnDatas.size(); i++) {
////			
////			 String Check = columnDatas.get(i).getText();
////			 if(Check.equals(accno)) {
////				 System.out.println(Check);
////				get = columnDatas.get(i+4).getText();
////				break;
////			 }
////		}
//		
//		//System.out.println(get);
//		
//		driver.findElement(By.name("home")).click();
//		driver.findElement(By.name("credit_cust_ac")).click();
//		driver.findElement(By.name("customer_account_no")).sendKeys(accno);
//		driver.findElement(By.name("credit_amount")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 15, 1));
//		Thread.sleep(2000);
//		driver.findElement(By.name("credit_btn")).click();
//		String creditAlert = webDriverUtility.alertGetText();
//		System.out.println(creditAlert);
//		webDriverUtility.alertAccept();
////		driver.findElement(By.name("home")).click();
////		driver.findElement(By.name("viewdet")).click();
////		List<WebElement> columnDatas = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td"));
////		String get = null;
////		for(int i =0 ; i<columnDatas.size(); i++) {
////			
////			 String Check = columnDatas.get(i).getText();
////			 if(Check.equals(accno)) {
////				 System.out.println(Check);
////				get = columnDatas.get(i+4).getText();
////				break;
////			 }
////		}
////		System.out.println(get);
//		driver.findElement(By.name("home")).click();
//		driver.findElement(By.name("view_cust_by_ac")).click();
//		driver.findElement(By.name("account_no")).sendKeys(accno);
//		Thread.sleep(2000);
//		driver.findElement(By.name("submit_view")).click();
//		 String AvlBalFinal = driver.findElement(By.xpath("//label[contains(text(),'Available Balance')]")).getText();
//		 String[] split1 = AvlBalFinal.split(":");
//		 String keyFinal = split1[0].trim();
//		 String valueFinal  =split1[1].trim();
//		System.out.println(keyFinal);
//		System.out.println(valueFinal);
//		excelUtility.closingExcel();
//		webDriverUtility.closeBrowser();
//	}
//}
