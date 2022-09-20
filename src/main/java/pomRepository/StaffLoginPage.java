package pomRepository;

import java.util.List;
import java.util.Map;

import org.Fidelity.GeneralUtility.JavaUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StaffLoginPage {
	
	@FindBy(name = "staff_id") private WebElement staffIdTextField;
	@FindBy(name = "password") private WebElement passwordTextField;
	@FindBy(name = "staff_login-btn") private WebElement staffLoginButton;
	@FindBy(name = "home") private WebElement staffPageHomeButton;
	@FindBy(name = "logout_btn") private WebElement staffLogOutButton;
	//page verification elements
	@FindBy(xpath = "//div[@class='welcome']//label") private WebElement StaffLoginPageVerification;
	
	public StaffLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	

	public WebElement getStaffLoginButton() {
		return staffLoginButton;
	}


	public void StaffLoginMethod(List<Map<String, String>>staffLoginData, int index) {
		staffIdTextField.sendKeys(staffLoginData.get(index).get("Staff ID"));
		passwordTextField.sendKeys(staffLoginData.get(index).get("password"));
		staffLoginButton.click();
	}
	public void StaffPageHomeLink() {
		staffPageHomeButton.click();
	}
	public void StaffLogOutMethod() {
		staffLogOutButton.click();
	}
	public String StaffHomePageHeadText() {
		return "Welcome Sean Smith";
	}
	
}
