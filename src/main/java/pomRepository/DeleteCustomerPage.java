package pomRepository;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCustomerPage {
	@FindBy(name = "del_cust") private WebElement deleteCustomerLink;
	@FindBy(name = "Cust_ac_no") private WebElement customerAccountNoTextfield;
	@FindBy(name = "Cust_ac_Id") private WebElement customerIdTextField;
	@FindBy(name = "reason") private WebElement reasonTextField;
	@FindBy(name = "delete") private WebElement deleteButton;
	
	public DeleteCustomerPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void DeleteCustomerLinkClick() {
		deleteCustomerLink.click();;
	}

	public void DeleteCustomerAccountMethod(String AccountNo, String customerId, List<Map<String, String>> data, int index) {
		customerAccountNoTextfield.sendKeys(AccountNo);
		customerIdTextField.sendKeys(customerId);
		reasonTextField.sendKeys(data.get(index).get("deleteRemarks"));
		deleteButton.click();
	}

}
