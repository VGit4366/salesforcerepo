package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.*;

import testData.FileConstants;

public class ReportManager {
	static ExtentSparkReporter sparkReport;
	
	private ReportManager(){ }
	
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent == null) {
			CreateInstance(FileConstants.REPORTS_FILE_PATH);
		}
		return extent;
	}
	
	private static ExtentReports CreateInstance(String fileName) {
		sparkReport = new ExtentSparkReporter(fileName);
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setDocumentTitle("SFDC Automation Report");
		sparkReport.config().setReportName("SFDC regression test report");
		sparkReport.config().setEncoding("utf-8");
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		extent.setSystemInfo("Automation Tester", "Varsha Murthy");
		return extent;
	}
	
}
