package by.htp.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage {
	
	private final String BASE_URL = "https://mail.ru";

	@FindBy(xpath = "//input[@id='mailbox:login']")
	private WebElement inputLogin;

	@FindBy(xpath = "//input[@id='mailbox:password']")
	private WebElement inputPassword;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement buttonSubmit;

	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
	}

	public void checkTitleMainPage() {
		String mainPageTitle = mainPage.getTitle();
		
	}

}
