package regression_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

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
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegTC2 {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		Workbook workbook = null;
		WebDriver driver = null;
		try {
			FileInputStream fis = new FileInputStream("./src/test/resources/REGTC1.xlsx");
			workbook = WorkbookFactory.create(fis);
			DataFormatter df = new DataFormatter();
			Sheet sheet1 = workbook.getSheet("CommonData");
			Sheet sheet2 = workbook.getSheet("TestData-accopening");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(df.formatCellValue(sheet1.getRow(0).getCell(1)));
			driver.manage().window().maximize();
			driver.findElement(By.id("details-button")).click();
			driver.findElement(By.id("proceed-link")).click();
			driver.findElement(By.linkText("Online_Banking_System/")).click();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//li[text()='Open Account']")).click();
			driver.findElement(By.name("name")).sendKeys(df.formatCellValue(sheet2.getRow(1).getCell(1)));
			WebElement gender = driver.findElement(By.name("gender"));
			Select sg = new Select(gender);
			sg.selectByVisibleText(df.formatCellValue(sheet2.getRow(2).getCell(1)));
			driver.findElement(By.name("mobile")).sendKeys(df.formatCellValue(sheet2.getRow(3).getCell(1)));
			driver.findElement(By.name("email")).sendKeys(df.formatCellValue(sheet2.getRow(4).getCell(1)));
			WebElement dob = driver.findElement(By.name("dob"));
			dob.click();
			dob.sendKeys(df.formatCellValue(sheet2.getRow(5).getCell(1)));
			driver.findElement(By.name("pan_no")).sendKeys(df.formatCellValue(sheet2.getRow(6).getCell(1)));
			driver.findElement(By.name("citizenship")).sendKeys(df.formatCellValue(sheet2.getRow(7).getCell(1)));
			driver.findElement(By.name("homeaddrs")).sendKeys(df.formatCellValue(sheet2.getRow(8).getCell(1)));
			WebElement state = driver.findElement(By.name("state"));
			Select ss = new Select(state);
			ss.selectByVisibleText(df.formatCellValue(sheet2.getRow(9).getCell(1)));
			WebElement city = driver.findElement(By.name("city"));
			Select sc = new Select(city);
			sc.selectByVisibleText(df.formatCellValue(sheet2.getRow(10).getCell(1)));
			driver.findElement(By.name("pin")).sendKeys(df.formatCellValue(sheet2.getRow(11).getCell(1)));
			driver.findElement(By.name("arealoc")).sendKeys(df.formatCellValue(sheet2.getRow(12).getCell(1)));
			WebElement acctype = driver.findElement(By.name("acctype"));
			Select sty = new Select(acctype);
			sty.selectByVisibleText(df.formatCellValue(sheet2.getRow(13).getCell(1)));
			driver.findElement(By.name("submit")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("cnfrm-submit")).click();
			Alert appAlert = driver.switchTo().alert();
			String text = appAlert.getText();
			System.out.println(text);
			appAlert.accept();
			String appno = "";
			for(int i=0; i<text.length(); i++) {
				if(text.charAt(i)>='0'&& text.charAt(i)<='9') {
					appno = appno + text.charAt(i);
				}
			}
			System.out.println("AppNo=" + appno);
			Thread.sleep(3000);
			driver.findElement(By.linkText("Staff Login")).click();
			driver.findElement(By.name("staff_id")).sendKeys(df.formatCellValue(sheet1.getRow(1).getCell(1)));
			driver.findElement(By.name("password")).sendKeys(df.formatCellValue(sheet1.getRow(2).getCell(1)));
			driver.findElement(By.name("staff_login-btn")).click();
			driver.findElement(By.name("apprvac")).click();
			driver.findElement(By.name("application_no")).sendKeys(appno);
			driver.findElement(By.name("search_application")).click();
			driver.findElement(By.name("approve_cust")).click();
			Alert accalert = driver.switchTo().alert();
			String alrt = accalert.getText();
			System.out.println(alrt);
			accalert.accept();
			String accno = "";
			for(int i=0; i<alrt.length(); i++) {
				if(alrt.charAt(i)>='0'&& alrt.charAt(i)<='9') {
					accno = accno + alrt.charAt(i);
				}
			}
			System.out.println("accno=" + accno);
			driver.findElement(By.linkText("Home")).click();
			driver.findElement(By.xpath("//li[text()='Apply Debit Card']")).click();;
			driver.findElement(By.name("holder_name")).sendKeys(df.formatCellValue(sheet2.getRow(1).getCell(1)));
			WebElement debitdob = driver.findElement(By.name("dob"));
			debitdob.click();
			debitdob.sendKeys(df.formatCellValue(sheet2.getRow(5).getCell(1)));
			driver.findElement(By.name("pan")).sendKeys(df.formatCellValue(sheet2.getRow(6).getCell(1)));
			driver.findElement(By.name("mob")).sendKeys(df.formatCellValue(sheet2.getRow(3).getCell(1)));
			driver.findElement(By.name("acc_no")).sendKeys(accno);
			driver.findElement(By.name("dbt_crd_submit")).click();
			Alert debalert = driver.switchTo().alert();
			String card = debalert.getText();
			debalert.accept();
			String debitcarddetails = "";
			String cardno ="";
			String cardpin ="";
			for(int i=0; i<card.length(); i++) {
				if(card.charAt(i)>='0'&& card.charAt(i)<='9') {
					debitcarddetails= debitcarddetails + card.charAt(i);
				}
			}
			for(int i =0; i<debitcarddetails.length(); i++) {
				if(i<=11) {
					cardno = cardno + debitcarddetails.charAt(i);
				}
				if(i>11) {
					cardpin = cardpin + debitcarddetails.charAt(i);
				}
			}
			System.out.println("card no = " + cardno);
			System.out.println("card pin=" + cardpin);
			driver.findElement(By.linkText("Staff Login")).click();
			driver.findElement(By.name("viewdet")).click();
			List<WebElement> ColumnElements = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tr/th"));
			List<WebElement> Debitcardcheck = new ArrayList<WebElement>();
			for(int i=0; i<ColumnElements.size(); i++) {
				String ColumnName = ColumnElements.get(i).getText();
				if(ColumnName.equals("Debit Card No.")) {
					Debitcardcheck = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td["+(i+1)+"]"));
					break;
				}
			}
			for(int i =0; i<Debitcardcheck.size(); i++) {
				if((Debitcardcheck.get(i).getText()).equals(cardno)) {
					System.out.println("TestCase Passed");
					break;
				}
			}
		}
		finally {
			workbook.close();
			driver.quit();
		}
	}

}
