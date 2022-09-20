//package org.Fidelity.RegTC;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.ArrayList;
//import java.util.List;
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
//
//public class RegTC2 {
//	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
//		WebdriverUtility webDriverUtility = new WebdriverUtility();
//		JavaUtility javaUtility = new JavaUtility();
//		ExcelUtility excelUtility  = new ExcelUtility();
//		excelUtility.initializeExcel(IConstantPath.EXCEL_PATH);
//		WebDriver driver = webDriverUtility.launchingBrowser(excelUtility.getDataFromExcel("CommonData", 4, 1));
//		webDriverUtility.openingWebpage(12, excelUtility.getDataFromExcel("CommonData", 0, 1));
//
//		driver.findElement(By.id("details-button")).click();
//		driver.findElement(By.id("proceed-link")).click();
//		driver.findElement(By.linkText("Online_Banking_System/")).click();
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
//		String accno = javaUtility.alertGetNoFromPopup(accNoAlert);
//		webDriverUtility.alertAccept();
//		driver.findElement(By.linkText("Home")).click();
//		driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();;
//		driver.findElement(By.name("holder_name")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 1, 1));
//		WebElement debitdob = driver.findElement(By.name("dob"));
//		debitdob.click();
//		debitdob.sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 5, 1));
//		
//		driver.findElement(By.name("pan")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 6, 1));
//		driver.findElement(By.name("mob")).sendKeys(excelUtility.getDataFromExcel("TestData-accopening", 3, 1));
//		driver.findElement(By.name("acc_no")).sendKeys(accno);
//		driver.findElement(By.name("dbt_crd_submit")).click();
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
//		driver.findElement(By.linkText("Staff Login")).click();
//		driver.findElement(By.name("viewdet")).click();
//		List<WebElement> ColumnElements = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tr/th"));
//		List<WebElement> Debitcardcheck = new ArrayList<WebElement>();
//		for(int i=0; i<ColumnElements.size(); i++) {
//			String ColumnName = ColumnElements.get(i).getText();
//			if(ColumnName.equals("Debit Card No.")) {
//				Debitcardcheck = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td["+(i+1)+"]"));
//				break;
//			}
//		}
//		for(int i =0; i<Debitcardcheck.size(); i++) {
//			if((Debitcardcheck.get(i).getText()).equals(cardNo)) {
//				System.out.println("TestCase Passed");
//				break;
//			}
//		}
//
//		excelUtility.closingExcel();
//		webDriverUtility.closeBrowser();
//
//	}
//
//}
