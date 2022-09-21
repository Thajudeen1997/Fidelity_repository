package org.Fidelity.GeneralUtility;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import pomRepository.ApplyDebitCardPage;
import pomRepository.ApproveApplicationPage;
import pomRepository.CommonPage;
import pomRepository.CreditCustomerPage;
import pomRepository.DeleteCustomerPage;
import pomRepository.OpenAccountPage;
import pomRepository.PageTitle;
import pomRepository.StaffLoginPage;
import pomRepository.ViewActiveCustomerPage;
import pomRepository.ViewCustomerByAccNoPage;

public class BaseClass {
	private ExcelUtility excelUtility;
	protected JavaUtility javaUtility;
	protected WebdriverUtility webDriverUtility;
	protected WebDriver driver;
	protected OpenAccountPage openAccountPage;
	protected ApplyDebitCardPage applyDebitCardPage;
	protected StaffLoginPage staffLoginPage;
	protected ApproveApplicationPage approveApplicationPage;
	protected ViewActiveCustomerPage viewActiveCustomerPage;
	protected ViewCustomerByAccNoPage viewAccountByAccountNo;
	protected List<Map<String, String>> testData;
	protected List<Map<String,String>> commonData;
	protected CommonPage commonPage;
	protected CreditCustomerPage creditCustomerPage;
	protected DeleteCustomerPage deleteCustomerPage;
	protected FileUtility fileUtility;
	public static JavaUtility sjavaUtility;
	public static WebDriver sdriver;

	/**
	 * initialize all utility class
	 * open excel And property file
	 * read common data
	 * create instance of browser (launch browser)
	 * maximize implicit wait
	 * open the application
	 * initialize action, jsexecutor, webdriver wait
	 * create instance for common object repo
	 */
	@BeforeClass
	public void classSetup() {
		// create instance for the generic utility
		excelUtility = new ExcelUtility();
		fileUtility = new FileUtility();
		javaUtility = new JavaUtility();
		sjavaUtility = javaUtility;
		webDriverUtility = new WebdriverUtility();
		//initialize property file and excel file
		excelUtility.initializeExcel(IConstantPath.EXCEL_PATH);	
		commonData = excelUtility.getDataFromExcelUsingListMap("CommonData");

	}
//	@Parameters(value="browser")
	@BeforeMethod
	public void testDataSetup() {
		String browser = System.getProperty("browser");
		driver = webDriverUtility.launchingBrowserUsingParameter(browser);
		sdriver = driver;
		webDriverUtility.openingWebpage(browser, commonData, 0, 10);
		commonPage = new CommonPage(driver);
		// changes done here
		commonPage.ByPassSecurityCheck();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.CUSTOMER_HOME_PAGE);
		webDriverUtility.maximizingBrowser(driver);
		
		openAccountPage = new OpenAccountPage(driver);
		applyDebitCardPage = new ApplyDebitCardPage(driver);
		staffLoginPage = new StaffLoginPage(driver);
		approveApplicationPage = new ApproveApplicationPage(driver);
		viewActiveCustomerPage = new ViewActiveCustomerPage(driver);
		viewAccountByAccountNo = new ViewCustomerByAccNoPage(driver);
		creditCustomerPage = new CreditCustomerPage(driver);
		deleteCustomerPage = new DeleteCustomerPage(driver);
		testData = excelUtility.getDataFromExcelUsingListMap("TestMap");
	}
	@AfterMethod
	public void tearLogins() {
		staffLoginPage.StaffLogOutMethod();
		javaUtility.AssertionPageNavigationVerify(webDriverUtility.GetCurrentPageTitleMethod(), PageTitle.STAFF_LOGIN_PAGE);
		webDriverUtility.closeBrowser();
		javaUtility.AssertAll();
	}
	@AfterClass
	public void classTearDown() {

		excelUtility.closingExcel();

	}
}
