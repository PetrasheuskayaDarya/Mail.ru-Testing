package by.htp.mail.tests;

import static org.testng.Assert.fail;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.mail.driver.DriverSingleton;
import by.htp.mail.pages.LoginPage;
import by.htp.mail.steps.Steps;

public class LogInTest {
	private Steps steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";

	@BeforeClass(description = "Init browser", groups = {"login"})
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(groups = {"login"})
	public void LoginToMailRu() {
		steps.loginMailPage(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn("tathtp@mail.ru"));
		//DriverSingleton.getDriver().get(url прописать);
		fail();
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
