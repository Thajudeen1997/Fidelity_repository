package regression_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;

import org.Fidelity.GeneralUtility.ExcelUtility;
import org.Fidelity.GeneralUtility.IConstantPath;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;



public class RegTC1UsingUtilities {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		ExcelUtility data = new ExcelUtility();
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		try {
//			driver.get(data.getDataFromExcel(IConstantPath.EXCEL_PATH,0, 1));
//			driver.manage().window().maximize();
//			driver.findElement(By.id("details-button")).click();
//			driver.findElement(By.id("proceed-link")).click();
//			driver.findElement(By.linkText("Online_Banking_System/")).click();
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			driver.findElement(By.xpath("//li[text()='Open Account']")).click();
//			driver.findElement(By.name("name")).sendKeys(df.formatCellValue(sheet2.getRow(1).getCell(1)));
//			WebElement gender = driver.findElement(By.name("gender"));
//			Select sg = new Select(gender);
//			sg.selectByVisibleText(df.formatCellValue(sheet2.getRow(2).getCell(1)));
//			driver.findElement(By.name("mobile")).sendKeys(df.formatCellValue(sheet2.getRow(3).getCell(1)));
//			driver.findElement(By.name("email")).sendKeys(df.formatCellValue(sheet2.getRow(4).getCell(1)));
//			WebElement dob = driver.findElement(By.name("dob"));
//			dob.click();
//			dob.sendKeys(df.formatCellValue(sheet2.getRow(5).getCell(1)));
//			driver.findElement(By.name("pan_no")).sendKeys(df.formatCellValue(sheet2.getRow(6).getCell(1)));
//			driver.findElement(By.name("citizenship")).sendKeys(df.formatCellValue(sheet2.getRow(7).getCell(1)));
//			driver.findElement(By.name("homeaddrs")).sendKeys(df.formatCellValue(sheet2.getRow(8).getCell(1)));
//			WebElement state = driver.findElement(By.name("state"));
//			Select ss = new Select(state);
//			ss.selectByVisibleText(df.formatCellValue(sheet2.getRow(9).getCell(1)));
//			WebElement city = driver.findElement(By.name("city"));
//			Select sc = new Select(city);
//			sc.selectByVisibleText(df.formatCellValue(sheet2.getRow(10).getCell(1)));
//			driver.findElement(By.name("pin")).sendKeys(df.formatCellValue(sheet2.getRow(11).getCell(1)));
//			driver.findElement(By.name("arealoc")).sendKeys(df.formatCellValue(sheet2.getRow(12).getCell(1)));
//			WebElement acctype = driver.findElement(By.name("acctype"));
//			Select sty = new Select(acctype);
//			sty.selectByVisibleText(df.formatCellValue(sheet2.getRow(13).getCell(1)));
//			driver.findElement(By.name("submit")).click();
//			Thread.sleep(3000);
//			driver.findElement(By.name("cnfrm-submit")).click();
//			String text = driver.switchTo().alert().getText();
//			System.out.println(text);
//			String appno = "";
//			for(int i=0; i<text.length(); i++) {
//				if(text.charAt(i)>='0'&& text.charAt(i)<='9') {
//					appno = appno + text.charAt(i);
//				}
//			}
//			System.out.println(appno);
//			Thread.sleep(3000);
//			driver.switchTo().alert().accept();
//			driver.findElement(By.linkText("Staff Login")).click();
//			driver.findElement(By.name("staff_id")).sendKeys(df.formatCellValue(sheet1.getRow(1).getCell(1)));
//			driver.findElement(By.name("password")).sendKeys(df.formatCellValue(sheet1.getRow(2).getCell(1)));
//			driver.findElement(By.name("staff_login-btn")).click();
//			driver.findElement(By.name("apprvac")).click();
//			driver.findElement(By.name("application_no")).sendKeys(appno);
//			driver.findElement(By.name("search_application")).click();
//			driver.findElement(By.name("approve_cust")).click();
//			WebDriverWait wait  = new WebDriverWait(driver, Duration.ofSeconds(10));
//			wait.until(ExpectedConditions.alertIsPresent());
//			Alert acc = driver.switchTo().alert();
//			String accountNo = acc.getText();
//			System.out.println(accountNo);
//			acc.accept();
//			String accno = "";
//			for(int i=0; i<accountNo.length(); i++) {
//				if(accountNo.charAt(i)>='0'&& accountNo.charAt(i)<='9') {
//					accno = accno + accountNo.charAt(i);
//				}
//			}
//			System.out.println("AccountNumber="+accno);
//			driver.findElement(By.name("home")).click();
//			driver.findElement(By.name("viewdet")).click();
//			List<WebElement> ColumnElements = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tr/th"));
//			List<WebElement> AccountNumberCheck = new ArrayList<WebElement>();
//			for(int i=0; i<ColumnElements.size(); i++) {
//				String ColumnName = ColumnElements.get(i).getText();
//				if(ColumnName.equals("Account No.")) {
//					System.out.println(i);
//					AccountNumberCheck = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td["+(i+1)+"]"));
//					break;
//				}
//			}
//			for(int i =0; i<AccountNumberCheck.size(); i++) {
//				if((AccountNumberCheck.get(i).getText()).equals(accno)) {
//					System.out.println("TestCase Passed");
//					break;
//				}
//			}
//		}
//		finally {
//			workbook.close();
//			driver.quit();

//		}
	}
}

	


