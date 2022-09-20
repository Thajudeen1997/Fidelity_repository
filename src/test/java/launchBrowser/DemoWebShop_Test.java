package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoWebShop_Test {
	@Test
	public void launchingInstagram() {
		//WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.quit();
	}

}
