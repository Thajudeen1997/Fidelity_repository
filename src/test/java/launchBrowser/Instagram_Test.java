package launchBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Instagram_Test {
	@Test
	public void launchingInstagram() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.instagram.com/accounts/login/?next=https%3A%2F%2Fwww.instagram.com%2F%3Fhl%3Den%26__coig_login%3D1");
		driver.manage().window().maximize();
		driver.quit();
	}

}
