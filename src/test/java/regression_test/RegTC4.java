package regression_test;

import java.time.Duration;

import javax.swing.Action;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RegTC4 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rmgtestingserver/domain/");
		driver.manage().window().maximize();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.linkText("Online_Banking_System/")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
		driver.findElement(By.name("name")).sendKeys("haris");
		WebElement gender = driver.findElement(By.name("gender"));
		Select sg = new Select(gender);
		sg.selectByVisibleText("Male");
		driver.findElement(By.name("mobile")).sendKeys("6380616096");
		driver.findElement(By.name("email")).sendKeys("haris@gmail.com");
		WebElement dob = driver.findElement(By.name("dob"));
		dob.click();
		dob.sendKeys("07/10/1997");
		driver.findElement(By.name("pan_no")).sendKeys("HARIS12");
		driver.findElement(By.name("citizenship")).sendKeys("Har77");
		driver.findElement(By.name("homeaddrs")).sendKeys("chennai");
		WebElement state = driver.findElement(By.name("state"));
		Select ss = new Select(state);
		ss.selectByVisibleText("California");
		WebElement city = driver.findElement(By.name("city"));
		Select sc = new Select(city);
		sc.selectByVisibleText("Orlando");
		driver.findElement(By.name("pin")).sendKeys("560045");
		driver.findElement(By.name("arealoc")).sendKeys("koyambedu");
		WebElement acctype = driver.findElement(By.name("acctype"));
		Select sty = new Select(acctype);
		sty.selectByVisibleText("Saving");
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
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("apprvac")).click();
		driver.findElement(By.name("application_no")).sendKeys(appno);
		driver.findElement(By.name("search_application")).click();
		Thread.sleep(3000);
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
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("del_cust")).click();
		driver.findElement(By.name("Cust_ac_no")).sendKeys(accno);
		driver.findElement(By.name("Cust_ac_Id")).sendKeys(cusId);
		driver.findElement(By.name("reason")).sendKeys("SuspectList");
		driver.findElement(By.name("delete")).click();
		Alert deleteAC = driver.switchTo().alert();
		String deletepopup = deleteAC.getText();
		deleteAC.accept();
		System.out.println(deletepopup);
		driver.findElement(By.name("home")).click();
		driver.findElement(By.name("view_cust_by_ac")).click();
		driver.findElement(By.name("account_no")).sendKeys(accno);
		driver.findElement(By.name("submit_view")).click();
		Alert con = driver.switchTo().alert();
		String confirmpopup = con.getText();
		System.out.println(confirmpopup);
		if(confirmpopup.equalsIgnoreCase("Customer not found"))
			System.out.println("Testcase passed");
		else
			System.out.println("Testcase failed");
		con.accept();
		Thread.sleep(3000);
		driver.quit();
	}
}
