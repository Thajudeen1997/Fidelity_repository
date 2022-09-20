package pomRepository;

import org.Fidelity.GeneralUtility.JavaUtility;
import org.Fidelity.GeneralUtility.WebdriverUtility;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApproveApplicationPage {
	@FindBy(name = "apprvac") private WebElement approveApplicationLink;
	@FindBy(name = "application_no") private WebElement applicationNoField;
	@FindBy(name = "search_application") private WebElement searchApplicationButton;
	@FindBy(name = "approve_cust") private WebElement approveCustomerButton;

	public ApproveApplicationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void ApproveApplicationLinkClick() {
		approveApplicationLink.click();;
	}

	public void ApproveApplicationMethod(String applicationNo, WebdriverUtility webdriverUtility)   {
		applicationNoField.sendKeys(applicationNo);
		searchApplicationButton.click();
		approveCustomerButton.click();
	}

	public void verifyApprovalPopUp(JavaUtility javaUtility,String  actualText) {
		String Expected  = "Successfully";
		javaUtility.verifyAlertMessage(actualText, Expected);
	}
}
