package SeleniumAutomation.resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReportObject() {
		
	Date date = new Date();
	//SimpleDateFormat formatter=new SimpleDateFormat("dd MMMM yyyy");
	SimpleDateFormat formatter=new SimpleDateFormat("dd MMM yyyy HH mm ss");
	String fileNameDateFormat=formatter.format(date);	
	String path=System.getProperty("user.dir")+"\\Reports\\Automation Report "+fileNameDateFormat+".html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("UI Automation Report");
	reporter.config().setDocumentTitle("Automation Report");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Test", "Auto");
	//extent.createTest("Test Name");
	
	return extent;
	}

}
