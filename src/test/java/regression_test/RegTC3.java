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

public class RegTC3 {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/REGTC1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		DataFormatter df = new DataFormatter();
		Sheet sheet1 = workbook.getSheet("CommonData");
		Sheet sheet2 = workbook.getSheet("TestData-accopening");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
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
		String text = driver.switchTo().alert().getText();
		System.out.println(text);
		String appno = "";
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i)>='0'&& text.charAt(i)<='9') {
				appno = appno + text.charAt(i);
			}
		}
		System.out.println("AppNo=" + appno);
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
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
//		driver.findElement(By.name("home")).click();
//		driver.findElement(By.name("viewdet")).click();
//		
//		
//		List<WebElement> columnDatas = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td"));
//		String get = null;
//		for(int i =0 ; i<columnDatas.size(); i++) {
//			
//			 String Check = columnDatas.get(i).getText();
//			 if(Check.equals(accno)) {
//				 System.out.println(Check);
//				get = columnDatas.get(i+4).getText();
//				break;
//			 }
//		}
//		System.out.println(get);
		
		driver.findElement(By.name("credit_cust_ac")).click();
		driver.findElement(By.name("customer_account_no")).sendKeys(accno);
		driver.findElement(By.name("credit_amount")).sendKeys(df.formatCellValue(sheet2.getRow(15).getCell(1)));
		driver.findElement(By.name("credit_btn")).click();
		Alert credit = driver.switchTo().alert();
		String credittext = credit.getText();
		System.out.println(credittext);
		credit.accept();
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("viewdet")).click();
		List<WebElement> columnDatas = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td"));
		String get = null;
		for(int i =0 ; i<columnDatas.size(); i++) {
			
			 String Check = columnDatas.get(i).getText();
			 if(Check.equals(accno)) {
				 System.out.println(Check);
				get = columnDatas.get(i+4).getText();
				break;
			 }
		}
		System.out.println(get);
		workbook.close();
		driver.quit();
	}
}
