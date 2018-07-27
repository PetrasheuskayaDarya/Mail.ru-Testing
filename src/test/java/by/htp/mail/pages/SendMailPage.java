package by.htp.mail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMailPage extends AbstractPage {
	private final String BASE_URL = "https://e.mail.ru/compose/";

	@FindBy(xpath = "//child::textarea[attribute::data-original-name='To']")
	private WebElement emailField;

	@FindBy(css = "input[tabindex='7']")
	private WebElement subject;

	@FindBy(xpath = "//*[@id='tinymce']")
	private WebElement inputText;

	@FindBy(xpath = "//child::div[attribute::class='b-toolbar']//child::span[attribute::class='b-toolbar__btn__text']")
	private WebElement buttonSent;

	public SendMailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

	public void CreateNewLetter(String email, String topic, String text) {
		emailField.clear();
		emailField.sendKeys(email);
		subject.sendKeys(topic);
		driver.switchTo().frame(2);
		inputText.click();
		inputText.clear();
		inputText.sendKeys(text);
		driver.switchTo().parentFrame();
		buttonSent.click();
	}

	public WebElement getEmailField() {
		return emailField;
	}

	public WebElement getSubject() {
		return subject;
	}

	public WebElement getInputText() {
		return inputText;
	}

	public WebElement getButtonSent() {
		return buttonSent;
	}

}
