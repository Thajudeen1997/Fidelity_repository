package org.Fidelity.TestNG.Practise;
import java.lang.reflect.Method;
import java.util.List;
import org.Fidelity.GeneralUtility.BaseClassForAnnotationRun;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import pomRepository.ColumnElements;
import pomRepository.PageLink;
import pomRepository.PageTitle;
public class CustomerModuleTest extends BaseClassForAnnotationRun {
	@Test
	public void TestCase1(Method mtd) {
		System.out.println(Thread.currentThread().getId());
		System.out.println(mtd.getName());
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
	}
	@Test
	public void TestCase2(Method mtd) {
		System.out.println(Thread.currentThread().getId());
		System.out.println(mtd.getName());
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
	@Test
	public void TestCase3(Method mtd) {
		System.out.println(Thread.currentThread().getId());
		System.out.println(mtd.getName());
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
	@Test
	public void TestCase4(Method mtd) {
		System.out.println(Thread.currentThread().getId());
		System.out.println(mtd.getName());
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
