package pomRepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreditCustomerPage {
	@FindBy(name = "home") private WebElement staffHomeLink;
	@FindBy(name = "credit_cust_ac") private WebElement creditCustomerLink;
	@FindBy(name = "customer_account_no") private WebElement creditCustomerAccNoTextField;
	@FindBy(name = "credit_amount") private WebElement creditAmountTextField;
	@FindBy(name = "credit_btn") private WebElement creditButton;
	
	public CreditCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getStaffHomeLink() {
		return staffHomeLink;
	}
	
	public void CreditCustomerLinkClick() {
		creditCustomerLink.click();;
	}

	public void CreditCustomerMethod(String accountNo, int index, List<Map<String, String>> data) {
		creditCustomerAccNoTextField.sendKeys(accountNo);
		creditAmountTextField.sendKeys(data.get(index).get("Credit Amount"));
		creditButton.click();
	}

}
