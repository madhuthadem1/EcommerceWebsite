package SeleniumAutomation.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumAutomation.pageobjects.HomePage;

public class AddToCartTest extends BaseTest {

	public HomePage homePageObject;
	public Actions keyboardInteraction;

	@Test(retryAnalyzer = Retry.class, enabled = false)
	public void addToCart() throws IOException {
		// TODO Auto-generated method stub
		// LandingPage landingPageElements = launchApplication();
		String userName = "madhu.social01@gmail.com";
		String userPassword = "Java@888";
		landingPage.enterUserName(userName);
		landingPage.enterUserPassword(userPassword);
		landingPage.clickLogin();
		// homePage.signOutButton().isDisplayed();
		// Assert.assertFalse(true);
		// Assert.assertEquals(actual, expected);

	}

	@Test(enabled = false)
	public void goToOrders() throws IOException {
		// TODO Auto-generated method stub
		// LandingPage landingPageElements = launchApplication();
		String userName = "madhu.social01@gmail.com";
		String userPassword = "Java@888";
		landingPage.enterUserName(userName);
		landingPage.enterUserPassword(userPassword);
		landingPage.clickLogin();
	}

	@Test(enabled = false)
	public void placeOrder() {
		homePageObject = new HomePage(driver);
		String userName = "madhu.social01@gmail.com";
		String userPassword = "Java@888";
		landingPage.enterUserName(userName);
		landingPage.enterUserPassword(userPassword);
		landingPage.clickLogin();
		homePageObject.searchForItem("ZARA COAT 3");
		keyboardInteraction = new Actions(driver);
		keyboardInteraction.keyDown(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		homePageObject.addItemToCart("ZARA COAT 3");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) homePageObject.returnElementAddedToCartMessage()));
		assertEquals(homePageObject.getAddedToCartSuccessMessage(), "Product Added To Cart");
	}

	@Test(enabled = true)
	public void navigationTest() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(5000);
		driver.navigate().forward();
		Thread.sleep(5000);
		driver.navigate().refresh();

	}
}