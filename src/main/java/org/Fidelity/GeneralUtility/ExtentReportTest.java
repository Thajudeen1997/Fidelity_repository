package org.Fidelity.GeneralUtility;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportTest {
	@Test
	public void report() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./testt/extentreport.html");
		spark.config().setDocumentTitle("Online_Banking_AutomationScript_TestReport");
		spark.config().setReportName("Automation_Report");
		spark.config().setTheme(Theme.DARK);
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		ExtentTest test1 = report.createTest("Test 1");
		test1.log(Status.FAIL, "NotPass");
	}
	

}

