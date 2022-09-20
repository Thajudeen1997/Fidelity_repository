package pomRepository;

import java.util.List;
import java.util.Map;

import org.Fidelity.GeneralUtility.ExcelUtility;
import org.Fidelity.GeneralUtility.WebdriverUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenAccountPage {
	@FindBy(xpath = "//li[text()='Open Account']") private WebElement OpenAccountLink;
	@FindBy(name = "name") private WebElement NameTextField;
	@FindBy(name = "gender") private WebElement genderDropDown;
	@FindBy(name = "mobile") private WebElement mobileNoTextField;
	@FindBy(name = "email") private WebElement emailIdTtextField;
	@FindBy(name = "dob") private WebElement dobDropDown;
	@FindBy(name = "pan_no") private WebElement panNoTextField;
	@FindBy(name = "citizenship") private WebElement citizenshipNoTextField;
	@FindBy(name = "homeaddrs") private WebElement homeAddressTextField;
	@FindBy(name = "state") private WebElement stateDropDown;
	@FindBy(name = "city") private WebElement cityDropDown;
	@FindBy(name = "pin") private WebElement areaPinCodeTextField;
	@FindBy(name = "arealoc") private WebElement areaLocalityTextField;
	@FindBy(name = "acctype") private WebElement accountTypeDropDown;
	@FindBy(name = "submit") private WebElement submitButton;
	@FindBy(name = "cnfrm-submit") private WebElement accountConfirmationSubmitButton;
	// element address for navigation page verification
	@FindBy(xpath = "//div[@class='container_regfrm_container_parent']//h3") protected WebElement openAccountPageVerification;
	
	public OpenAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void OpenAccountLink() {
		 OpenAccountLink.click();;
	}


	public String getOpenAccountPageVerification() {
		return openAccountPageVerification.getText();
	}


	public void OpenAccountMethod(List<Map<String,String>> list,int index ) {
		NameTextField.sendKeys(list.get(index).get("name"));
		WebdriverUtility webDriverUtility = new WebdriverUtility();
		webDriverUtility.selectClass(genderDropDown, list.get(index).get("gender"));
		mobileNoTextField.sendKeys(list.get(index).get("mobileno"));
		emailIdTtextField.sendKeys(list.get(index).get("emailid"));
		dobDropDown.click();
		dobDropDown.sendKeys(list.get(index).get("dob"));
		panNoTextField.sendKeys(list.get(index).get("pan"));
		citizenshipNoTextField.sendKeys(list.get(index).get("citino"));
		homeAddressTextField.sendKeys(list.get(index).get("homeadd"));
		webDriverUtility.selectClass(stateDropDown, list.get(index).get("state"));
		webDriverUtility.selectClass(cityDropDown, list.get(index).get("city"));
		areaPinCodeTextField.sendKeys(list.get(index).get("pin"));
		areaLocalityTextField.sendKeys(list.get(index).get("area"));
		webDriverUtility.selectClass(accountTypeDropDown, list.get(index).get("acctype"));
		submitButton.click();
		accountConfirmationSubmitButton.click();
		
	}
	public String OpenAccountHeadText() {
		return "Online Account Opening Form";
	}
	
	
	
	
	
}
