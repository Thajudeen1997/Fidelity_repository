package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommonPage {
	private WebDriver driver;
	@FindBy(id = "details-button") private WebElement SafetyBypass;
	@FindBy(id = "proceed-link") private WebElement ProceedLink;
	@FindBy(linkText = "Online_Banking_System/") private WebElement OnlineBankingSystem;
	@FindBy(linkText = "Staff Login") private WebElement staffLoginLink;
	@FindBy(linkText = "Home") private WebElement homepageLink;
	private String DynamicXpath = "//li[text()='%s']";
	/**
	 * Elements to check the navigation using the webElements
	 */
	@FindBy(xpath = "//div[@class='online_services']//h4") private WebElement homePageElementForVerification;
	@FindBy(xpath = "//div[@class='form']//label[@class='login']") private WebElement staffLoginPageVerification;
	/**{
	 * This method is used to initialize the element repository
	 * @param driver
	 */
	public CommonPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/**
	 * getters for the elements
	 */
	public String getHomePageElementForVerification() {
		return homePageElementForVerification.getText();
	}
	
	public String StaffLoginPageVerification() {
		return staffLoginPageVerification.getText();
	}
	/**{
	 * This method is used as business library
	 */
	public void ByPassSecurityCheck() {
			SafetyBypass.click();
			ProceedLink.click();
			OnlineBankingSystem.click();
	}
	public void ClickStaffLogin() {
		staffLoginLink.click();
	}
	public void ClickHomeLink() {
		homepageLink.click();
	}
	public void ClickDynamicPathAction(PageLink pageLink) {
		String requiredPath = String.format(DynamicXpath, pageLink.getPageLink());
		driver.findElement(By.xpath(requiredPath)).click();
	}
	public String staffLoginPageTitleMethod(WebDriver driver) {
		return driver.getTitle();
	}
}
