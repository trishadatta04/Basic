package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {

	// this refers to the current class driver
	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']")
	List<WebElement> products;
	@FindBy(id = "toast-container")
	WebElement toastMsg;
	By addToCart = By.xpath("//button[@class='btn w-10 rounded']");
	By productlist = By
			.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']\"");
	By toast = By.id("toast-container");
	String byText = "//*[contains(text(),'textToBeReplaced')]//parent::h5//following-sibling::button[@class='btn w-10 rounded']";

	String cart = "//button[contains(@routerlink,'cart')]";
	By Orders = By.xpath("//button[contains(@routerlink,'myorders')]");

	public List<WebElement> getProductlist(By productlist) {
		// TODO Auto-generated method stub
		// waitforElementToAppear(productlist);

		return products;
	}

	public void selectProds(String[] product) throws InterruptedException {
		for (int i = 0; i < product.length; i++) {
			driver.findElement(By.xpath(byText.replace("textToBeReplaced", product[i].trim()))).click();
			Thread.sleep(1000);
		}

	}

	public CartPage goToCartPage() {
		driver.findElement(By.xpath(cart)).click();
		return new CartPage(driver);
	}

	public OrderHistoryPage goToOrders() {
		driver.findElement(Orders).click();;
		return new OrderHistoryPage(driver);
	}

}
