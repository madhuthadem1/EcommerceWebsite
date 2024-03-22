package SeleniumAutomation.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Utils {
	
	WebDriver driver;
	WebDriverWait wait;
	public void waitForElement(WebElement element, long durationInSeconds) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSeconds));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}

}
