package by.htp.mail.listener;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import by.htp.mail.driver.DriverSingleton;

public class TestFailCustomListener implements ITestListener {

	int count;

	@Override
	public void onFinish(ITestContext arg0) {
		System.out.println("!!!!!! onFinish");
		Reporter.log("!!!!!!!!!!!!!  onFinish");
	}

	@Override
	public void onStart(ITestContext arg0) {
		System.out.println("!!!!!! onStart");
		Reporter.log("!!!!!!!!!!!!!  onStart");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		System.out.println("!!!!!! onTestFailedButWithinSuccessPercentage");
		Reporter.log("!!!!!!!!!!!!!  onTestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		System.out.println("!!!!!! onTestFailure");
		Reporter.log("!!!!!!!!!!!!!  onTestFailure");
		takeScreenshot();
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		System.out.println("!!!!!! onTestSkipped");
		Reporter.log("!!!!!!!!!!!!!  onTestSkipped");
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		System.out.println("!!!!!! onTestStart");
		Reporter.log("!!!!!!!!!!!!!  onTestStart");
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		System.out.println("!!!!!! onTestSuccess");
		Reporter.log("!!!!!!!!!!!!!  onTestSuccess");
	}

	private void takeScreenshot() {
		count++;
		String filePath = "C://Users/37533/Desktop/logsScreenShot/screenShot";
		String fileExt = ".png";
		String fileName = filePath + count + fileExt;

		Reporter.log("<img src= \"" + fileName +"\">");

		WebDriver driver = DriverSingleton.getDriver();
		File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShot, new File(fileName));
			// return
		} catch (IOException e) {
			System.out.println("Faled to save screenshot: " + e.getLocalizedMessage());
		}
	}

}
