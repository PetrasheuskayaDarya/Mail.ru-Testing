package by.htp.mail.steps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.reporters.EmailableReporter;

import by.htp.mail.driver.DriverSingleton;
import by.htp.mail.pages.LoginPage;
import by.htp.mail.pages.MainPage;
import by.htp.mail.pages.SendMailPage;
import by.htp.mail.pages.SentMailPage;

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
	
	public boolean GetTitleOfMyEmail() {
		SentMailPage sentMailPage = new SentMailPage(driver);
		 List<WebElement> listOfAllEmail = driver.findElements(By.xpath("//div[@class='b-datalist__item__body']/a"));
		 String element;
			for (int i = 0; i < listOfAllEmail.size(); i++) {
				element = listOfAllEmail.get(i).getAttribute("data-subject");
				if (element.equals("DaryaTest4")) {
					return true;
				}
			}
			return false;
	 }
	
	public void GoToSentLetterPage() {
		MainPage mainPage = new MainPage(driver);
		mainPage.getEmailsThatWasSentButton().click();
	}

	public String getTitle() {
		return driver.getTitle();
	}
}
