package by.htp.mail.steps;

import org.openqa.selenium.WebDriver;

import by.htp.mail.driver.DriverSingleton;
import by.htp.mail.pages.LoginPage;
import by.htp.mail.pages.MainPage;
import by.htp.mail.pages.SendMailPage;

public class Steps {
	private WebDriver driver;

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void loginMailPage(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username) {
		LoginPage loginPage = new LoginPage(driver);
		String nameOfUser = loginPage.getTextUserName();
		return nameOfUser.equals(username);
	}

	public void sentNewLetter() {
		MainPage mainPage = new MainPage(driver);
		mainPage.ClickOnCreateNewLetter();
	}

	public void CreateNewLetter(String email, String topic, String text) {
		SendMailPage sendMailPage = new SendMailPage(driver);
		sendMailPage.getEmailField().clear();
		sendMailPage.getEmailField().sendKeys(email);
		sendMailPage.getSubject().sendKeys(topic);
		driver.switchTo().frame(2);
		sendMailPage.getInputText().click();
		sendMailPage.getInputText().clear();
		sendMailPage.getInputText().sendKeys(text);
		driver.switchTo().parentFrame();
		sendMailPage.getButtonSent().click();
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
