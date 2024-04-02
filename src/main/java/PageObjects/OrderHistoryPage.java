package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import AbstractComponents.AbstractComponent;

public class OrderHistoryPage extends AbstractComponent {

	
	String orderedItems = "//td[contains(text(),'REPLACE-ITEM')]";
	public OrderHistoryPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
	}

	public void VerifyOrders(String[] product) {
		for (int i = 0; i < product.length; i++) {
			Assert.assertTrue(driver.findElement(By.xpath(orderedItems.replace("REPLACE-ITEM", product[i].trim()))).isDisplayed());
			
		}
		
		
	}

}
