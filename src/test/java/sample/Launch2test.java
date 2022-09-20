package sample;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Launch2test {
	@Parameters("BrowserName")
	@Test
	public void test(String BrowserName) {
		WebDriver driver = null;
		if(BrowserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
			
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
//		Thread.sleep(3000);
//		driver.close();
	}
}
