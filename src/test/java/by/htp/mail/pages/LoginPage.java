package by.htp.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {

	private final String BASE_URL = "https://mail.ru/login";

	@FindBy(xpath = "//input[@name='Login']")
	private WebElement inputLogin;

	@FindBy(xpath = "//input[@name='Password']")
	private WebElement inputPassword;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement buttonSubmit;

	@FindBy(xpath = "//iframe[@class='ag-popup__frame__layout__iframe']")
	private WebElement iframeOnLoginPage;
	
	@FindBy(xpath = "//span[@id='PH_authMenu_button']/i[@id='PH_user-email']")
	private WebElement LoggedInUserName;

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void login(String username, String password) {
		driver.switchTo().frame(iframeOnLoginPage);
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
	}

	public String getTextUserName() {
		return LoggedInUserName.getText();

	}

}
