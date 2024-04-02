package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CheckOut extends AbstractComponent {
	WebDriver driver;

	@FindBy(css = ".action__submit")
	WebElement placeOrderButton;
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	WebElement selectCountry;
	By resultDropdown = By.cssSelector(".ta-results");

	// this refers to the current class driver
	public CheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void SelectCountry(String countryName) {

		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitforElementToAppear(resultDropdown);
		selectCountry.click();

	}

	public OrderConfirmPage clickOnPlaceOrder() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		// waitforElementToBeClickable(placeOrderButton);
		js.executeScript("arguments[0].click();", placeOrderButton);

		return new OrderConfirmPage(driver);

	}

}
