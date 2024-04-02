package Selenium;

import org.testng.Assert;
import org.testng.annotations.Test;
import Selenium.TestComponents.BaseTest;

public class ErrorValidationsTest extends BaseTest {
	@Test(retryAnalyzer = ExtentReports.TestComponents.Retry.class)
	public void failedTest() {
		loginpage.Login("trisha.datta@capgemini.com", "Trisha");
		Assert.assertEquals(loginpage.getLoginError(), "Incorrect");
		;
	}
}
