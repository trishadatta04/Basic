package ExtentReports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo {
	ExtentReports extent;
	WebDriver driver = new ChromeDriver();
	
	@BeforeTest
	public void config() {
		//ExtentReports , ExtentSparkReporter
		String path = System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Trisha Datta");
	}
	
	@Test
	public void initialDemo() {
		ExtentTest test =extent.createTest("Test Pass");		
		driver.get("https://rahulshettyacademy.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.close();
		test.addScreenCaptureFromBase64String(title);
		extent.flush();
	}
	@Test
	public void TestFail() {
		ExtentTest test1=extent.createTest("Test Fail");
		
		driver.get("https://rahulshettyacademy.com/");
		String titl = driver.getTitle();
		driver.close();
		test1.fail("Test failed");
		extent.flush();
	}
		
	
}
