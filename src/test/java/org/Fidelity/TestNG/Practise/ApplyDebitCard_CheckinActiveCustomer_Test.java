package org.Fidelity.TestNG.Practise;

import java.lang.reflect.Method;
import java.util.List;

import org.Fidelity.GeneralUtility.BaseClass;
import org.Fidelity.GeneralUtility.BaseClassForAnnotationRun;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pomRepository.ColumnElements;
import pomRepository.PageLink;
import pomRepository.PageTitle;

public class ApplyDebitCard_CheckinActiveCustomer_Test extends BaseClass {
	@Test
	public void TestCase2Test() {
		commonPage.ClickDynamicPathAction(PageLink.OPEN_ACCOUNT);
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
		staffLoginPage.StaffLogOutMethod();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_LOGIN_PAGE);
		commonPage.ClickHomeLink();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.CUSTOMER_HOME_PAGE);
		commonPage.ClickDynamicPathAction(PageLink.APPLY_DEBIT_CARD);
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.APPLY_DEBIT_CARD);
		applyDebitCardPage.ApplyDebitCardMethod(testData, 1, accno);
		String debitCardAlert = webDriverUtility.alertGetText();
		webDriverUtility.alertAccept();
		String debitCardNo = applyDebitCardPage.getDebitCardNo(debitCardAlert);
		commonPage.ClickStaffLogin();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_LOGIN_PAGE);
		staffLoginPage.StaffLoginMethod(commonData, 0);
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_HOME_PAGE);
		viewActiveCustomerPage.ViewActiveCustomerLinkClick();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.VIEW_ACTIVE_CUSTOMER_PAGE);
		List<WebElement> columnElements = viewActiveCustomerPage.GetTableColumnElements();
		int count = viewActiveCustomerPage.CheckDataInViewCustomerPage(driver, debitCardNo, columnElements, ColumnElements.DEBIT_CARD_NO);
		javaUtility.AssertionCheckTrue(count==1);
	}

}
