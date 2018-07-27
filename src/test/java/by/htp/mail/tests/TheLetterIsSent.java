package by.htp.mail.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.mail.pages.SendMailPage;
import by.htp.mail.steps.Steps;

public class TheLetterIsSent {
	private Steps steps;
	private final String USERNAME = "tathtp";
	private final String PASSWORD = "Klopik123";
	private final String email = "sviatlana.zakharenka@gmail.com";
	private final String topic = "DaryaTest";
	private final String text = "TestMessage";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}

	@Test
	public void LetterIsSent() {
		steps.loginMailPage(USERNAME, PASSWORD);
		steps.sentNewLetter();
		steps.CreateNewLetter(email, topic, text);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}

}
