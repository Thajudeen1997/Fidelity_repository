package pomRepository;

import java.util.List;
import java.util.Map;

import org.Fidelity.GeneralUtility.JavaUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyDebitCardPage {
	@FindBy(xpath = "//li[text()='Apply Debit Card']") private WebElement applyDebitCardLink;
	@FindBy(name = "holder_name") private WebElement accountHolderNameTextField;
	@FindBy(name = "dob") private WebElement dateOfBirthCalendar;
	@FindBy(name = "pan") private WebElement panNoTextField;
	@FindBy(name = "mob") private WebElement mobileNoTextField;
	@FindBy(name = "acc_no") private WebElement accountNoTextField;
	@FindBy(name = "dbt_crd_submit") private WebElement debitCardSubmitButton;
	
	public ApplyDebitCardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ApplyDebitCardMethod(List<Map<String, String>> data, int index, String accno) {
		accountHolderNameTextField.sendKeys(data.get(index).get("name"));
		dateOfBirthCalendar.click();
		dateOfBirthCalendar.sendKeys(data.get(index).get("dob"));
		panNoTextField.sendKeys(data.get(index).get("pan"));
		mobileNoTextField.sendKeys(data.get(index).get("mobileno"));
		accountNoTextField.sendKeys(accno);
		debitCardSubmitButton.click();
	}
	public String getDebitCardNo(String popUpText) {
		JavaUtility javaUtility = new JavaUtility();
		String text = javaUtility.alertGetNoFromPopup(popUpText);
		return javaUtility.getDebitcardNo(text);
	}
	public void DebitCardPageVerification(JavaUtility javaUtility, String currentPageTitle) {
		String debitCardPageTitle = "Apply Debit Card";
		javaUtility.AssertionCheckTrue(debitCardPageTitle.equals(currentPageTitle));
		
	}
}
