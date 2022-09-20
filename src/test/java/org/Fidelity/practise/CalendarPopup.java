package org.Fidelity.practise;

import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalendarPopup {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String reqDate = "10";
		String reqMonth = "July";
		String reqYear = "2018";
		int reqMonthinNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(reqMonth).get(ChronoField.MONTH_OF_YEAR);		
		int reqYearinNum = Integer.parseInt(reqYear);
		driver.get("https://testleaf.herokuapp.com/pages/Calendar.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("datepicker")).click();
		String date = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		String[] split = date.split(" ");
		String actualMonth = split[0];
		String actualYear = split[1];
		int actualMonthinNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);		
		int actualYearinNum = Integer.parseInt(actualYear);
		while(reqMonthinNum>actualMonthinNum || reqYearinNum>actualYearinNum){
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			date = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			split = date.split(" ");
			actualMonth = split[0];
			actualYear = split[1];
			actualMonthinNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);		
			actualYearinNum = Integer.parseInt(actualYear);
		}
		while(reqMonthinNum<actualMonthinNum || reqYearinNum<actualYearinNum){
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			date = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			split = date.split(" ");
			actualMonth = split[0];
			actualYear = split[1];
			actualMonthinNum = DateTimeFormatter.ofPattern("MMMM").withLocale(Locale.ENGLISH).parse(actualMonth).get(ChronoField.MONTH_OF_YEAR);		
			actualYearinNum = Integer.parseInt(actualYear);
		}
		driver.findElement(By.xpath("//a[text()='"+reqDate+"']")).click();
	}
	

}
