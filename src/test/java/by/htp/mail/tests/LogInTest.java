package by.htp.mail.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.mail.pages.LoginPage;
import by.htp.mail.steps.Steps;

public class LogInTest {
	private Steps steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void LoginToMailRu()
	{
		steps.loginMailPage(USERNAME, PASSWORD);
	
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
