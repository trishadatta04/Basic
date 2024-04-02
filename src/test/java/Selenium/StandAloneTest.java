package Selenium;

import java.time.Duration;
import java.util.List;
//JAVA STREAMS USED IN PLACE OF FOR LOOPS 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {
	@Test
	public void StandAlone() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//passing the driver as argument so that the login class can use the driver methods , a constructor is created in the login class 
		
		driver.get("https://rahulshettyacademy.com/client");
		Actions action = new Actions(driver);
		//login
		action.moveToElement(driver.findElement(By.id("userEmail"))).click().sendKeys("trisha.datta@capgemini.com").build().perform();
		action.moveToElement(driver.findElement(By.id("userPassword"))).click().sendKeys("Trisha04").build().perform();
		action.moveToElement(driver.findElement(By.id("login"))).click().build().perform();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		Thread.sleep(2000);
		
		List<WebElement>items = driver.findElements(By.xpath("//div[@class='col-lg-4 col-md-6 col-sm-10 offset-md-0 offset-sm-1 mb-3 ng-star-inserted']"));
		
		
		//JAVA STREAM & LAMBDA FUNCTION
		WebElement product1 = items.stream().filter(it-> 
		it.findElement(By.tagName("b")).getText().equalsIgnoreCase("zara coat 3")).findAny().orElse(null);
		product1.findElement(By.xpath("//button[@class='btn w-10 rounded']")).click();
		
		WebElement toast = driver.findElement(By.id("toast-container"));
		//EXPLICIT WAIT
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(toast));
		System.out.println(toast.getText());
		wait.until(ExpectedConditions.invisibilityOf(toast));
		
		
		//click on cart
		driver.findElement(By.xpath("//button[contains(@routerlink,'cart')]")).click();
		
		//find if the element is present in cart or not
		List<WebElement> itemsAdded = driver.findElements(By.xpath("//div[@class='cartSection']"));
		System.out.print("No of items added to cart " + itemsAdded.size());
		//to check whether the element is added to cart or not
		Assert.assertTrue(itemsAdded.stream().filter(itm->
		itm.findElement(By.tagName("h3")).getText().equalsIgnoreCase("Zara coat 3" )).findFirst().isPresent());
	//ANOTHER WAY TO CHECK IS USING .anyMatch in place of filter - both works the same
		Assert.assertTrue(itemsAdded.stream().anyMatch(itm->
		itm.findElement(By.tagName("h3")).getText().equalsIgnoreCase("Zara coat 3")));
		
		//proceed to checkout JAVASCRIPT EXECUTOR 
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement checkout = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));

		js.executeScript("arguments[0].click();", checkout);

		js.executeScript("window.scrollBy(0,100)");

		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".action__submit")));

		
		
		/**WebElement cart = driver.findElement(By.xpath("//li[@class='totalRow']/button"));
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		action.scrollToElement(cart).click().build().perform();
		
		Thread.sleep(2000);
		//Handle auto suggestive dropdowns
		/**wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//input[@placeholder='Select Country']"))));
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		Thread.sleep(2000);

		wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//button[contains(@class,'ta-item')]"))));
		List <WebElement> dropdown = driver.findElements(By.xpath("//button[contains(@class,'ta-item')]"));
		for(WebElement i : dropdown) {
			if(i.getText().equalsIgnoreCase("India")) {
				i.click();			}
		}
		**/
		
		
		
		Actions a = new Actions(driver);
		Thread.sleep(1000);
    a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();

    wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".ta-results")));

    driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();

    driver.findElement(By.cssSelector(".action__submit")).click();

    Thread.sleep(2000);

    String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();

    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    driver.quit();

}
		
		
}
