package SeleniumAutomation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import SeleniumAutomation.pageobjects.LandingPage;

public class MouseActionsTest extends BaseTest{
	
	public LandingPage landingPageObject;
	public Actions mouse;
	
	@Test (enabled = false)
	public void clickUsingActions() throws InterruptedException {
		landingPageObject = new LandingPage(driver);
		mouse= new Actions(driver);
	//	mouse.moveToElement(landingPageObject.getRegisterButton()).click().perform();
		mouse.moveToElement(landingPageObject.getRegisterButton()).perform();	
		Thread.sleep(5000);
		mouse.click().perform();
	}
	
	@Test (enabled = false)
	public void doubleClick() throws InterruptedException {
		driver.navigate().to("https://jqueryui.com/tooltip/");
		mouse= new Actions(driver);
		Thread.sleep(5000);
		mouse.doubleClick(driver.findElement(By.xpath("//h1[@class='entry-title']"))).perform();
		Thread.sleep(5000);
		
	}
	
	@Test(enabled=true)
	public void dragObject() {
		driver.navigate().to("https://jqueryui.com/tooltip/");
		mouse= new Actions(driver);
		driver.findElement(By.xpath("//a[normalize-space()='Droppable']")).click();
		WebElement frame = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
		driver.switchTo().frame(frame);
		mouse.dragAndDrop(driver.findElement(By.xpath("//p[normalize-space()='Drag me to my target']")), 
				driver.findElement(By.xpath("//div[@id='droppable']"))).perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[normalize-space()='Draggable']")).click();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
		driver.switchTo().frame(frame2);
		mouse.dragAndDropBy(driver.findElement(By.xpath("//div[@id=\"draggable\"]")), 0, 10).perform();

	//	mouse.keyDown(Keys.TAB).perform();
		
	}

}
