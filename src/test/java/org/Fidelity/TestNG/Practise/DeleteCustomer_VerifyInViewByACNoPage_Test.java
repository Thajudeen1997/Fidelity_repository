package org.Fidelity.TestNG.Practise;

import java.lang.reflect.Method;

import org.Fidelity.GeneralUtility.BaseClassForAnnotationRun;
import org.testng.annotations.Test;

import pomRepository.PageTitle;

public class DeleteCustomer_VerifyInViewByACNoPage_Test extends BaseClassForAnnotationRun {
	@Test
	public void TestCase4() {
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
		String customerId = javaUtility.getCustomerId(accno);
		deleteCustomerPage.DeleteCustomerLinkClick();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.DELETE_CUSTOMER);
		deleteCustomerPage.DeleteCustomerAccountMethod(accno, customerId, testData, 1);
		System.out.println(webDriverUtility.alertGetText());
		webDriverUtility.alertAccept();
		staffLoginPage.StaffPageHomeLink();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_HOME_PAGE);
		viewAccountByAccountNo.ViewCustomerByAccNoLinkClick();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.VIEW_BY_CUSTOMER_ACC_NO);
		viewAccountByAccountNo.ViewCustomerByAccNoMethod(accno);
		System.out.println(webDriverUtility.alertGetText());
		webDriverUtility.alertAccept();
		javaUtility.AssertionContainsTwoString(webDriverUtility.alertGetText(), "Incorrect");
	}
}
