package org.Fidelity.practise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HospitalManagement {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rmgtestingserver/domain/");
		driver.manage().window().maximize();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.linkText("Hospital_Management_..>")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//h3[text()='Admin Login']/following-sibling::div//a")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//h2[text()='Manage Doctors']/following-sibling::p/a")).click();
		List<WebElement> header = driver.findElements(By.xpath("//table[@id='sample-table-1']/thead/tr/th"));
		List<WebElement> DoctorList = new ArrayList<WebElement>();
		for(int i=0; i<header.size(); i++) {
			String ColumnName = header.get(i).getText();
			if(ColumnName.equals("Doctor Name")) {
				DoctorList = driver.findElements(By.xpath("//table[@id='sample-table-1']/tbody/tr/td["+(i+1)+"]"));
				System.out.println(i);
				break;
			}
		}

		for (WebElement webElement : DoctorList) {
			System.out.println(webElement.getText());
		}
	}
	

}
