package regression_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegTC4_DataDriven_property {
	public static void main(String[] args) throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/RegTC4.properties");
		Properties property = new Properties();
		property.load(fis);
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(property.getProperty("url"));
		driver.manage().window().maximize();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.linkText("Online_Banking_System/")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		driver.findElement(By.name("name")).sendKeys(property.getProperty("name"));
		WebElement gender = driver.findElement(By.name("gender"));
		Select sg = new Select(gender);
		sg.selectByVisibleText(property.getProperty("gender"));
		driver.findElement(By.name("mobile")).sendKeys(property.getProperty("mobileno"));
		driver.findElement(By.name("email")).sendKeys(property.getProperty("emailid"));
		WebElement dob = driver.findElement(By.name("dob"));
		dob.click();
		dob.sendKeys(property.getProperty("dob"));
		driver.findElement(By.name("pan_no")).sendKeys(property.getProperty("pan"));
		driver.findElement(By.name("citizenship")).sendKeys(property.getProperty("citino"));
		driver.findElement(By.name("homeaddrs")).sendKeys(property.getProperty("homeadd"));
		WebElement state = driver.findElement(By.name("state"));
		Select ss = new Select(state);
		ss.selectByVisibleText(property.getProperty("state"));
		WebElement city = driver.findElement(By.name("city"));
		Select sc = new Select(city);
		sc.selectByVisibleText(property.getProperty("city"));
		driver.findElement(By.name("pin")).sendKeys(property.getProperty("pin"));
		driver.findElement(By.name("arealoc")).sendKeys(property.getProperty("area"));
		WebElement acctype = driver.findElement(By.name("acctype"));
		Select sty = new Select(acctype);
		sty.selectByVisibleText(property.getProperty("acctype"));
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
		driver.findElement(By.name("staff_id")).sendKeys(property.getProperty("staffid"));
		driver.findElement(By.name("password")).sendKeys(property.getProperty("password"));
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
		String cusId ="";
		for(int i=0; i<alrt.length(); i++) {
			if(alrt.charAt(i)>='0'&& alrt.charAt(i)<='9') {
				accno = accno + alrt.charAt(i);
			}
		}
		for(int i =6; i<accno.length(); i++) {
			cusId = cusId+accno.charAt(i);
		}
		System.out.println("accno=" + accno);
		System.out.println("cutomer_ID=" + cusId);
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("del_cust")).click();
		driver.findElement(By.name("Cust_ac_no")).sendKeys(accno);
		driver.findElement(By.name("Cust_ac_Id")).sendKeys(cusId);
		driver.findElement(By.name("reason")).sendKeys(property.getProperty("deleteRemarks"));
		driver.findElement(By.name("delete")).click();
		Alert deleteAC = driver.switchTo().alert();
		String deletepopup = deleteAC.getText();
		deleteAC.accept();
		System.out.println(deletepopup);
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("view_cust_by_ac")).click();
		driver.findElement(By.name("account_no")).sendKeys(accno);
		driver.findElement(By.name("submit_view")).click();
		Alert check = driver.switchTo().alert();
		String checkconfirm = check.getText();
		System.out.println(checkconfirm);
		if(checkconfirm.equalsIgnoreCase("Customer not found"))
			System.out.println("Testcase passed");
		else
			System.out.println("Testcase failed");
		check.accept();
		Thread.sleep(3000);
		
		driver.quit();
	}
}
