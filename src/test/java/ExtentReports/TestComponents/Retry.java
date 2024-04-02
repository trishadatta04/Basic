package ExtentReports.TestComponents;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	
	int count =0;
	int maxrun =1;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxrun) {
			count++;
			return true;
		}
		return false;
	}

}
