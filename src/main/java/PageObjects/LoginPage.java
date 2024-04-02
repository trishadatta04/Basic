package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent {
	WebDriver driver;

	// this refers to the current class driver
	public LoginPage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement email;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(id = "login")
	WebElement submit;
	String URL = "https://rahulshettyacademy.com/client";
	@FindBy(xpath="//div[contains(@class,'toast-bottom-right toast-container')]")
	WebElement loginError;

	public ProductCatalog Login(String mailId, String pass) {
		email.sendKeys(mailId);
		password.sendKeys(pass);
		submit.click();
		return new ProductCatalog(driver);
	}

	public void goToLoginPage() {
		driver.get(URL);

	}
	public String getLoginError() {
		return loginError.getText();
	}

}
