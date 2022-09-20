package org.Fidelity.practise;

import java.util.List;
import java.util.Map;

import org.Fidelity.GeneralUtility.ExcelUtility;
import org.Fidelity.GeneralUtility.FileUtility;
import org.Fidelity.GeneralUtility.WebdriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ChildBrowserHandling {
	public static void main(String[] args) {
		WebdriverUtility webDriverUtility = new WebdriverUtility();
		FileUtility fileUtility = new FileUtility();
		ExcelUtility excelUtility = new ExcelUtility();
	
		List<Map<String, String>> list = excelUtility.getDataFromExcelUsingListMap("CommonData");
		WebDriver driver   = webDriverUtility.launchingBrowser(list, 0);
		webDriverUtility.maximizingBrowser(driver);
	//	webDriverUtility.openingWebpage("https://ww2.movierulzs.net/captain-2022-telugu/movie-watch-online-free-download-5561.html", 0, 0);
		System.out.println(driver.getWindowHandle());
		driver.findElement(By.linkText("/watchfree.php?title=Captain")).click();
		System.out.println(driver.getWindowHandles());
		excelUtility.closingExcel();
		
	}

}
