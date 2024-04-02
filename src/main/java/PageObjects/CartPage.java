package PageObjects;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	

	// this refers to the current class driver
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='cartSection']")
	List<WebElement> cartSection;
	@FindBy(xpath = "//*[contains(text(),'Checkout')]")
	WebElement checkout;

	/**
	 * public boolean verifyProduct(String[] product) { for (int i = 0; i <
	 * product.length; i++) { boolean prod = cartSection.stream() .anyMatch(itm ->
	 * itm.findElement(By.tagName("h3")).getText().contains(product)); return prod;
	 * }
	 * 
	 * }
	 **/

	public CheckOut clickOnCheckout() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkout);
		return new CheckOut(driver);

	}

}
