package by.htp.mail.steps;

import org.openqa.selenium.WebDriver;

import by.htp.mail.driver.DriverSingleton;
import by.htp.mail.pages.LoginPage;

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

	public boolean isLoggedIn(String username){

		LoginPage loginPage = new LoginPage(driver);
		String nameOfUser = loginPage.getTextUserName();
		return nameOfUser.equals(username);
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
