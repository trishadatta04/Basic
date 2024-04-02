package Selenium;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckOut;
import PageObjects.OrderConfirmPage;
import PageObjects.OrderHistoryPage;
import PageObjects.ProductCatalog;
import Selenium.TestComponents.BaseTest;

public class SubmitOrder extends BaseTest {
	public String[] prod = { "ADIDAS", "ZARA" };

	@Test
	public void SubmitOrderTest() throws InterruptedException, IOException {

		ProductCatalog productcatalog = loginpage.Login("trisha.datta@capgemini.com", "Trisha04");
		Thread.sleep(1000);

		productcatalog.selectProds(prod);
		Thread.sleep(1000);

		CartPage cartpage = productcatalog.goToCartPage();
		CheckOut checkoutpage = cartpage.clickOnCheckout();

		checkoutpage.SelectCountry("India");
		OrderConfirmPage orderconfirm = checkoutpage.clickOnPlaceOrder();
		Assert.assertEquals(orderconfirm.ConfirmationMassage(), "THANKYOU FOR THE ORDER.");
		System.out.println(orderconfirm.ConfirmationMassage());

	}

	@Test(dependsOnMethods = { "SubmitOrderTest" })
	public void OrderHistory() throws InterruptedException {
		ProductCatalog productcatalog = loginpage.Login("trisha.datta@capgemini.com", "Trisha04");
		Thread.sleep(1000);
		OrderHistoryPage orderHistory = productcatalog.goToOrders();
		orderHistory.VerifyOrders(prod);
		System.out.println("Sucessfully verified the orders");
	}

	@Test(groups = "Smoke")
	public void SignOut() throws InterruptedException {
		ProductCatalog productcatalog = loginpage.Login("trisha.datta@capgemini.com", "Trisha04");
		Thread.sleep(1000);
		productcatalog.Signout(singout);
		System.out.println("Sucessfully Singout");

	}

	

	@DataProvider
	public void Data() {
		// refer section 21
	}

}
