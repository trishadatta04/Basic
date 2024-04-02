package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class OrderConfirmPage extends AbstractComponent {
	WebDriver driver;
	@FindBy(css = ".hero-primary")
	WebElement orderConfirmStatus;

	// this refers to the current class driver
	public OrderConfirmPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public String ConfirmationMassage() {

		String text = orderConfirmStatus.getText();
		return text;

	}
}
