package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class AbstractComponent {
	public WebDriver driver;
	// WebDriverWait wait;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		// wait =new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public void waitforElementToAppear(By findBy) {
		// wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}

	public void waitforElementToDisappear(WebElement ele) {
		// wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void waitforElementToBeClickable(WebElement e) {
		// wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	public void Signout(String string) {
		driver.findElement(By.xpath(string)).click();
	}
	
}
