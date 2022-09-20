package org.Fidelity.practise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTableXPath {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rmgtestingserver/domain/");
		driver.manage().window().maximize();
		driver.findElement(By.id("details-button")).click();
		driver.findElement(By.id("proceed-link")).click();
		driver.findElement(By.linkText("Online_Banking_System/")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.linkText("Staff Login")).click();
		driver.findElement(By.name("staff_id")).sendKeys("210001");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("staff_login-btn")).click();
		driver.findElement(By.name("viewdet")).click();
		List<WebElement> ColumnElements = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tr/th"));
		List<WebElement> AccHolderName = new ArrayList<WebElement>();
		for(int i=0; i<ColumnElements.size(); i++) {
			String ColumnName = ColumnElements.get(i).getText();
			if(ColumnName.equals("Customer ID")) {
				AccHolderName = driver.findElements(By.xpath("//div[@class='active_customers_container']/descendant::tbody/tr/td["+(i+1)+"]"));
				break;
			}
		}
		for (WebElement webElement : AccHolderName) {
			System.out.println(webElement.getText());
		}
	}

}
