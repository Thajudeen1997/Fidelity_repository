package regression_test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;



public class RegTC1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		try {
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
			System.out.println(appno);
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.findElement(By.linkText("Staff Login")).click();
			driver.findElement(By.name("staff_id")).sendKeys("210001");
			driver.findElement(By.name("password")).sendKeys("password");
			driver.findElement(By.name("staff_login-btn")).click();
			driver.findElement(By.name("apprvac")).click();
			driver.findElement(By.name("application_no")).sendKeys(appno);
			driver.findElement(By.name("search_application")).click();
			driver.findElement(By.name("approve_cust")).click();
			Alert acc = driver.switchTo().alert();
			String accountNo = acc.getText();
			System.out.println(accountNo);
			acc.accept();
			String accno = "";
			for(int i=0; i<accountNo.length(); i++) {
				if(accountNo.charAt(i)>='0'&& accountNo.charAt(i)<='9') {
					accno = accno + accountNo.charAt(i);
				}
			}
			driver.findElement(By.name("home")).click();
			driver.findElement(By.name("viewdet")).click();
			List<WebElement> ColumnElements = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tr/th"));
			List<WebElement> AccountNumberCheck = new ArrayList<WebElement>();
			for(int i=0; i<ColumnElements.size(); i++) {
				String ColumnName = ColumnElements.get(i).getText();
				if(ColumnName.equals("Account No.")) {
					AccountNumberCheck = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td["+(i+1)+"]"));
					break;
				}
			}
			for (WebElement AccounNo : AccountNumberCheck) {
				if(AccounNo.equals(accno)) {
					System.out.println("Testcase Passed");
					break;
				}
			}
			
		}
		finally {
			driver.quit();
		}
	}

}
