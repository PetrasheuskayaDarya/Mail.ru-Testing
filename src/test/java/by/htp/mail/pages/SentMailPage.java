package by.htp.mail.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SentMailPage extends AbstractPage {
	private final String BASE_URL = "https://e.mail.ru/messages/sent/";

	public SentMailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
	@FindBy(xpath = "//div[@class = 'b-datalist__body']")
	public WebElement listOfEmails; 

	 public boolean GetTitleOfMyEmail() {
		 //List<WebElement> listOfAllEmail = driver.findElements(By.xpath("//div[@class = 'b-datalist__body']/div"));
		 List<WebElement> listOfAllEmail = driver.findElements(By.xpath("div[@class = 'b-datalist__body']/div/div/a/div[4]/div[3]/div/div"));
		 String element;
			for (int i = 0; i < listOfAllEmail.size(); i++) {
				element = listOfAllEmail.get(i).getText();
				if (element.equals("DaryaTest")) {
					return true;
				}
			}
			return false;
	 }

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}

}
