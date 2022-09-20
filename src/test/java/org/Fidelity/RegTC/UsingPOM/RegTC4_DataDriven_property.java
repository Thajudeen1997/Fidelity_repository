//package org.Fidelity.RegTC.UsingPOM;
//import java.io.IOException;
//import java.time.Duration;
//import org.Fidelity.GeneralUtility.FileUtility;
//import org.Fidelity.GeneralUtility.IConstantPath;
//import org.Fidelity.GeneralUtility.JavaUtility;
//import org.Fidelity.GeneralUtility.WebdriverUtility;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//public class RegTC4_DataDriven_property {
//	public static void main(String[] args) throws InterruptedException, IOException {
//		FileUtility fileUtility = new FileUtility();
//		WebdriverUtility webDriverUtility = new WebdriverUtility();
//		JavaUtility javaUtility = new JavaUtility();
//		fileUtility.initializePropertyfile(IConstantPath.PROPERTY_PATH);
//		WebDriver driver = webDriverUtility.launchingBrowser("chrome");
//		webDriverUtility.openingWebpage(10, fileUtility.getDataFromPropertFile("url"));
//		driver.findElement(By.id("details-button")).click();
//		driver.findElement(By.id("proceed-link")).click();
//		driver.findElement(By.linkText("Online_Banking_System/")).click();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.xpath("//li[text()='Open Account']")).click();
//		driver.findElement(By.name("name")).sendKeys(fileUtility.getDataFromPropertFile("name"));
//		WebElement gender = driver.findElement(By.name("gender"));
//		webDriverUtility.selectClass(gender, fileUtility.getDataFromPropertFile("Male"));
//		driver.findElement(By.name("mobile")).sendKeys(fileUtility.getDataFromPropertFile("mobileno"));
//		driver.findElement(By.name("email")).sendKeys(fileUtility.getDataFromPropertFile("emailid"));
//		WebElement dob = driver.findElement(By.name("dob"));
//		dob.click();
//		dob.sendKeys(fileUtility.getDataFromPropertFile("dob"));
//		driver.findElement(By.name("pan_no")).sendKeys(fileUtility.getDataFromPropertFile("pan"));
//		driver.findElement(By.name("citizenship")).sendKeys(fileUtility.getDataFromPropertFile("citino"));
//		driver.findElement(By.name("homeaddrs")).sendKeys(fileUtility.getDataFromPropertFile("homeadd"));
//		WebElement state = driver.findElement(By.name("state"));
//		webDriverUtility.selectClass(state, fileUtility.getDataFromPropertFile("state"));
//
//		WebElement city = driver.findElement(By.name("city"));
//		webDriverUtility.selectClass(city, fileUtility.getDataFromPropertFile("city"));
//
//		driver.findElement(By.name("pin")).sendKeys(fileUtility.getDataFromPropertFile("pin"));
//		driver.findElement(By.name("arealoc")).sendKeys(fileUtility.getDataFromPropertFile("area"));
//		WebElement acctype = driver.findElement(By.name("acctype"));
//		webDriverUtility.selectClass(acctype, fileUtility.getDataFromPropertFile("acctype"));
//		driver.findElement(By.name("submit")).click();
//		Thread.sleep(3000);
//		driver.findElement(By.name("cnfrm-submit")).click();
//		String text = webDriverUtility.alertGetText();
//		String appno = javaUtility.alertGetNoFromPopup(text);
//		webDriverUtility.alertAccept();
//		System.out.println("AppNo=" + appno);
//		Thread.sleep(3000);
//		driver.findElement(By.linkText("Staff Login")).click();
//		driver.findElement(By.name("staff_id")).sendKeys(fileUtility.getDataFromPropertFile("staffid"));
//		driver.findElement(By.name("password")).sendKeys(fileUtility.getDataFromPropertFile("password"));
//		driver.findElement(By.name("staff_login-btn")).click();
//		driver.findElement(By.name("apprvac")).click();
//		driver.findElement(By.name("application_no")).sendKeys(appno);
//		driver.findElement(By.name("search_application")).click();
//		driver.findElement(By.name("approve_cust")).click();
//		String accAlert = webDriverUtility.alertGetText();
//		String accno = javaUtility.alertGetNoFromPopup(accAlert);
//		webDriverUtility.alertAccept();
//		String customerId = javaUtility.getCustomerId(accno);
//		System.out.println("accno=" + accno);
//		System.out.println("cutomer_ID=" + customerId);
//		driver.findElement(By.name("home")).click();
//		driver.findElement(By.name("del_cust")).click();
//		driver.findElement(By.name("Cust_ac_no")).sendKeys(accno);
//		driver.findElement(By.name("Cust_ac_Id")).sendKeys(customerId);
//		driver.findElement(By.name("reason")).sendKeys(fileUtility.getDataFromPropertFile("deleteRemarks"));
//		driver.findElement(By.name("delete")).click();
//		String deleteAC = webDriverUtility.alertGetText();
//		webDriverUtility.alertAccept();
//		System.out.println(deleteAC);
//		driver.findElement(By.name("home")).click();
//		driver.findElement(By.name("view_cust_by_ac")).click();
//		driver.findElement(By.name("account_no")).sendKeys(accno);
//		driver.findElement(By.name("submit_view")).click();
//		String checkconfirm = webDriverUtility.alertGetText();
//		webDriverUtility.alertAccept();
//		System.out.println(checkconfirm);
//		if(checkconfirm.equalsIgnoreCase("Customer not found"))
//			System.out.println("Testcase passed");
//		else
//			System.out.println("Testcase failed");
//		webDriverUtility.closeBrowser();
//
//	}
//}
