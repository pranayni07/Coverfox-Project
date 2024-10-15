package coverfoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverfoxBase.BaseClass;

public class Listener extends BaseClass implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log(result.getName()+"TC execution started",true);
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName()+"TC is failed",true);
		try {
			Utility.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
