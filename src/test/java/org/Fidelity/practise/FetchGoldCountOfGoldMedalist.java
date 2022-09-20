package org.Fidelity.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import javax.xml.xpath.XPath;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchGoldCountOfGoldMedalist {
	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Regdata.xlsx");
		 Workbook book = WorkbookFactory.create(fis);
		 Sheet sheet = book.getSheet("2DArray");
		 DataFormatter df = new DataFormatter();
		 WebDriverManager.chromedriver().setup();
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 WebDriver driver = new ChromeDriver(options);
		 driver.get("https://www.makemytrip.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 Thread.sleep(3000);
		 try {
		 driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		 WebElement from = driver.findElement(By.xpath("//label[@for='fromCity']"));
		 from.click();
		 driver.findElement(By.xpath(df.formatCellValue(sheet.getRow(5).getCell(1)))).click();
//		 driver.findElement(By.xpath("//label[@for='toCity']")).click();
		 driver.findElement(By.xpath("//span[text()='To']/ancestor::div/descendant::p[text()='Bangkok, Thailand']")).click();
		 //Thread.sleep(3000);
//		 Actions act = new Actions(driver);
		 driver.findElement(By.xpath("//div[@aria-label='Fri Aug 26 2022']/descendant::p[text()='26']")).click();
		 WebElement search = driver.findElement(By.linkText("Search"));
//		 act.moveToElement(search).doubleClick().perform();
		 search.click();
		 //search.click();
//		 
//		 Select s = new Select(from);
//		 s.selectByVisibleText("Mumbai, India");
		 }
		 finally {
		 book.close();
		 }
	}

}
