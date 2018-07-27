package by.htp.mail.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://e.mail.ru/messages/inbox/";

	@FindBy(css = "a[rel='history'] span[class^='b-toolbar__btn']")
	private WebElement buttonWriteEmail;
	
	@FindBy(xpath = ".//*[@id='b-nav_folders']/div/div[2]/a/span")
	private WebElement emailsThatWasSentButton;

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public void ClickOnCreateNewLetter() {
		buttonWriteEmail.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public WebElement getEmailsThatWasSentButton() {
		return emailsThatWasSentButton;
	}

}
