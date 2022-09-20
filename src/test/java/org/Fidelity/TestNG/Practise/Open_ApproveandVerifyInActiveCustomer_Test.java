package org.Fidelity.TestNG.Practise;

import java.util.List;

import org.Fidelity.GeneralUtility.BaseClassForAnnotationRun;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pomRepository.ColumnElements;
import pomRepository.PageTitle;

public class Open_ApproveandVerifyInActiveCustomer_Test extends BaseClassForAnnotationRun {
	@Test
	public void TestCase1() {
		openAccountPage.OpenAccountLink();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.OPEN_ACCOUNT);
		openAccountPage.OpenAccountMethod(testData, 0);
		String openAccountText = webDriverUtility.alertGetText();
		webDriverUtility.alertAccept();
		String appNo = javaUtility.alertGetNoFromPopup(openAccountText);
		commonPage.ClickStaffLogin();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_LOGIN_PAGE);
		staffLoginPage.StaffLoginMethod(commonData, 0);
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_HOME_PAGE);
		approveApplicationPage.ApproveApplicationLinkClick();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.APPROVE_PENDING_ACCOUNT);
		approveApplicationPage.ApproveApplicationMethod(appNo, webDriverUtility);
		String accText = webDriverUtility.AlertHandleAndGetText();
		String accno = javaUtility.alertGetNoFromPopup(accText);
		System.out.println("AccountNumber="+accno);
		staffLoginPage.StaffPageHomeLink();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_HOME_PAGE);
		viewActiveCustomerPage.ViewActiveCustomerLinkClick();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.VIEW_ACTIVE_CUSTOMER_PAGE);
		List<WebElement> columnElements = viewActiveCustomerPage.GetTableColumnElements();
		int count = viewActiveCustomerPage.CheckDataInViewCustomerPage(driver, accno, columnElements, ColumnElements.ACCOUNTNO);
		javaUtility.AssertionCheckTrue(count==1);
		staffLoginPage.StaffPageHomeLink();
		staffLoginPage.getStaffLoginButton().click();
	}

}

