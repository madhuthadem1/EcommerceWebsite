package SeleniumAutomation.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.reporters.jq.TimesPanel;

import SeleniumAutomation.pageobjects.RegisterPage;

public class RegisterPageTests extends BaseTest {
	
	public RegisterPage registerPageObjects;
	public WebDriverWait w;
	public Select occupationDropDown;
	
	@Test(enabled = false)
	public void enterMandatoryFieldsToRegister() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		landingPage.navigateToUserRegistrationPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@Test(enabled = false)
	public void validationForMandatoryFieldsToRegister() throws InterruptedException {
		registerPageObjects	 = new RegisterPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		landingPage.navigateToUserRegistrationPage();
		System.out.println("Navigated to register page");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    registerPageObjects.clickRegister();
	    System.out.println("Clicked register without entering mandatory fields");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	   // Thread.sleep(5000);
	    String message=registerPageObjects.getFirstNameValidationMessage();
	    System.out.println(message);
	   // Thread.sleep(15000);
	    assertEquals(registerPageObjects.getFirstNameValidationMessage(), "*First Name is required");
	    System.out.println(registerPageObjects.getFirstNameValidationMessage());
	}
	
	@Test(enabled = false)
	public void checkDuplicateUserRegistration() {
		registerPageObjects = new RegisterPage(driver);
		landingPage.navigateToUserRegistrationPage();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		registerPageObjects.enterFirstName("Madhu");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		registerPageObjects.enterLastName("Test");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		registerPageObjects.enterEmailID("madhu.social01@gmail.com");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		registerPageObjects.enterPhoneNumber("1231231234");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		occupationDropDown = new Select(driver.findElement(By.xpath("//select[@formcontrolname='occupation']")));
		occupationDropDown.selectByValue("4: Scientist"); //Scientist
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		occupationDropDown.selectByVisibleText("Engineer");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		occupationDropDown.selectByIndex(2); //Student
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		registerPageObjects.selectGender("Male");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		registerPageObjects.enterPassword("Madhu@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		registerPageObjects.confirmPassword("Madhu@123");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		registerPageObjects.confirmEighteenYearOld("yes");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		registerPageObjects.clickRegister();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		w = new WebDriverWait(driver, Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOf(registerPageObjects.returnElementMessageForDuplicateEmailID()));
		assertEquals(registerPageObjects.getValidationMessageForDuplicateEmailID(), "User already exisits with this Email Id!");
	}
	
	@Test(enabled = false)
	public void linkTest() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement value: links) {
			if(value.isEnabled()) {
				System.out.println("URL for Link Text "+value.getText()+" is "+value.getAttribute("href"));
			}
			
		}
	}
	
	@Test(enabled=false)
	public void toolTipTestUsingGetAttribute() {
		driver.get("https://jqueryui.com/tooltip/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		WebElement age=driver.findElement(By.xpath("//input[@id='age']"));
		String ageToolTip=age.getAttribute("title");
		assertEquals(ageToolTip, "We ask for your age only for statistical purposes.");
	}
	
	@Test(enabled=false)
	public void toolTipTestUsingActions() {
		
		driver.get("https://jqueryui.com/tooltip/");
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
	    driver.switchTo().frame(frame);
	    Actions a = new Actions(driver);
	    a.scrollByAmount(0, 150);
		WebElement age=driver.findElement(By.xpath("//input[@id='age']"));
		//getText() works if html is having like <tag> Tool tip message <tag>
		a.moveToElement(age).perform();
		String ageToolTip=age.getText();
		assertEquals(ageToolTip, "We ask for your age only for statistical purposes.");
	}
	
}
