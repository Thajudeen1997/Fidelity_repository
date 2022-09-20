package org.Fidelity.TestNG.Practise;

import java.lang.reflect.Method;

import org.Fidelity.GeneralUtility.BaseClassForAnnotationRun;
import org.testng.annotations.Test;

import pomRepository.PageTitle;

public class CreditCustomer_VerifyInActiveCustomerPage_Test extends BaseClassForAnnotationRun {
	@Test
	public void TestCase3() {
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
		webDriverUtility.explicitWait(10);
		String accText = webDriverUtility.AlertHandleAndGetText();
		String accno = javaUtility.alertGetNoFromPopup(accText);
		System.out.println("AccountNumber="+accno);
		staffLoginPage.StaffPageHomeLink();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_HOME_PAGE);
		creditCustomerPage.CreditCustomerLinkClick();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.CREDIT_CUSTOMER);
		creditCustomerPage.CreditCustomerMethod(accno, 1, testData);
		webDriverUtility.alertAccept();
		creditCustomerPage.getStaffHomeLink().click();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_HOME_PAGE);
		viewAccountByAccountNo.ViewCustomerByAccNoLinkClick();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.VIEW_BY_CUSTOMER_ACC_NO);
		viewAccountByAccountNo.ViewCustomerByAccNoMethod(accno);
		System.out.println(viewAccountByAccountNo.getAmountGetText().getText());
		javaUtility.AssertionContainsTwoString(testData.get(1).get("Credit Amount"), viewAccountByAccountNo.getAmountGetText().getText());
	}
}
