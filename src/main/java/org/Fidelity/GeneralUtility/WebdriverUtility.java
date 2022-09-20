package org.Fidelity.GeneralUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This methods consists of all Webdriver methods 
 * @author Faster
 *
 */
public class WebdriverUtility {
	private WebDriver driver = null;
	private JavascriptExecutor js;
	/**
	 * @return 
	 * 
	 */
	public WebDriver launchingBrowser(List<Map<String, String>> data, int index) {

		switch(data.get(index).get("Browser Name")) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser name entered");
		}
		return driver;	
	}
	public WebDriver launchingBrowserUsingParameter(String data) {

		switch(data) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("Invalid Browser name entered");
		}
		return driver;	
	}
	public void maximizingBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitingStatements(WebDriver driver, int longTimeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeOut));

	}
	public Alert explicitWait(int longTimeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(longTimeOut));
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	public void openingWebpage(String browser,List<Map<String, String>> data, int index, int longTimeOut) {
		if(browser.equalsIgnoreCase("chrome")) {
			maximizingBrowser(driver);
			waitingStatements(driver, longTimeOut);
			driver.get(data.get(0).get("url Chrome"));
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			maximizingBrowser(driver);
			waitingStatements(driver, longTimeOut);
			driver.get(data.get(0).get("url Firefox"));
			
		}
		
	}
	public void openingWebpage(List<Map<String, String>> data, int index, int longTimeOut) {
		
			maximizingBrowser(driver);
			waitingStatements(driver, longTimeOut);
			driver.get(data.get(0).get("url Chrome"));
			
		
	}
	public void alertAccept() {
		driver.switchTo().alert().accept();
	}
	public String alertGetText() {
		return driver.switchTo().alert().getText();
	}
	public String AlertHandleAndGetText() {
		Alert alert  = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		return alertText;
		
	}
	public void closeBrowser() {
		driver.quit();
	}
	public void selectClass(WebElement element, String VisibleText) {
		Select s = new Select(element);
		s.selectByVisibleText(VisibleText);
	}
	public void jsInitialization() {
		js = (JavascriptExecutor) driver;
	}
	public void openApplicationUsingjs(String url) {
		js.executeScript("window.location=arguments[0]", url);
	}
	public void sendkeysUsingJS(WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]",element , data );
	}
	public void ScreenShot(WebDriver driver, JavaUtility javaUtility, String className) {
		String currentDate = javaUtility.CurrentDate();
		TakesScreenshot ts =(TakesScreenshot)driver;
		 File src = ts.getScreenshotAs(org.openqa.selenium.OutputType.FILE);
		 File dest = new File("./Screenshot/"+className+"_"+currentDate+".png");
		 try {
			FileHandler.copy(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		 // or FileUtils.FileHandler.copy(src, dest);
	}
	public String screenShott(WebDriver driver) {
		TakesScreenshot ts =(TakesScreenshot)driver;
		String tempPath = ts.getScreenshotAs(OutputType.BASE64);
		return tempPath;
	}
	public String GetCurrentPageTitleMethod() {
		return driver.getTitle();
	}
	
}
