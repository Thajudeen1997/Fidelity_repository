package org.Fidelity.GeneralUtility;

import org.Fidelity.GeneralUtility.BaseClass;
import org.Fidelity.GeneralUtility.WebdriverUtility;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ITestListenerImplementation implements ITestListener {
	private ExtentReports reports;
	private ExtentTest test;
	public static ExtentTest stest;
	@Override
	public void onTestStart(ITestResult result) {
		test = reports.createTest(result.getMethod().getMethodName());
		stest = test;
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail(result.getMethod().getMethodName()+"fail");
		test.fail(result.getThrowable());
		String path = new WebdriverUtility().screenShott(BaseClass.sdriver);
		test.addScreenCaptureFromBase64String(path);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip(result.getMethod().getMethodName()+"skip");
		test.fail(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentreports.html");
		spark.config().setDocumentTitle("Online_Banking");
		spark.config().setReportName("Test Result");
		spark.config().setTheme(Theme.DARK);
		reports = new ExtentReports();
		reports.attachReporter(spark);
		reports.setSystemInfo("Author", "Thajudeen");
		reports.setSystemInfo("OS", "WINDOWS 10");
		reports.setSystemInfo("Browser", "Chrome");
		
	}

	@Override
	public void onFinish(ITestContext context) {
		reports.flush();
	}

}
