package project.rokomari;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login_To_Checkout extends Base_Driver {

	@Test(priority = 1)
	public void openURL() throws InterruptedException {
		driver.get("https://www.rokomari.com/book");
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test(priority = 2)
	public void verifySignInPage() throws InterruptedException {
		WebElement signin = driver.findElement(By.xpath("//a[normalize-space()='Sign in']"));
		signin.click();
		Thread.sleep(3000);
	}

	@Test(priority = 3)
	public void verifySignInPageWithInvalidCredentials() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200);");
		Thread.sleep(2000);
		WebElement email = driver.findElement(By.xpath("//input[@id='j_username']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='j_password']"));
		WebElement signin_btn = driver.findElement(By.xpath("//button[normalize-space()='Sign In']"));
		

		email.sendKeys("efgh@gmail.com");
		Thread.sleep(2000);
		password.sendKeys("12345");
		Thread.sleep(2000);
		signin_btn.click();
		Thread.sleep(3000);
		String showText = driver.findElement(By.xpath("//div[@id='js--message']//p[2]")).getText();
		Assert.assertEquals(showText, "Wrong email or phone efgh@gmail.com");
		Thread.sleep(2000);
		WebElement closeWarning = driver.findElement(By.xpath("//span[@aria-hidden='true']"));
		closeWarning.click();
		Thread.sleep(3000);
	}

	@Test(priority = 4)
	public void verifySignInPageWithInvalidEmail() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200);");
		Thread.sleep(2000);
		WebElement email_1 = driver.findElement(By.xpath("//input[@id='j_username']"));
		WebElement password_1 = driver.findElement(By.xpath("//input[@id='j_password']"));
		WebElement signin_btn_1 = driver.findElement(By.xpath("//button[normalize-space()='Sign In']"));
		
		
		email_1.sendKeys("efgh@gmail.com");
		Thread.sleep(2000);
		password_1.sendKeys("Rokomari@01");
		Thread.sleep(2000);
		signin_btn_1.click();
		Thread.sleep(2000);
		String showText_1 = driver.findElement(By.xpath("//div[@id='js--message']//p[2]")).getText();	
		Assert.assertEquals(showText_1, "Wrong email or phone efgh@gmail.com");
		Thread.sleep(2000);
		WebElement closeWarning_1 = driver.findElement(By.xpath("//span[@aria-hidden='true']"));
		closeWarning_1.click();
		Thread.sleep(3000);
	}
	@Test(priority = 5)
	public void verifySignInPageWithInvalidPassword() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200);");
		Thread.sleep(2000);
		WebElement email_2 = driver.findElement(By.xpath("//input[@id='j_username']"));
		WebElement password_2 = driver.findElement(By.xpath("//input[@id='j_password']"));
		WebElement signin_btn_2 = driver.findElement(By.xpath("//button[normalize-space()='Sign In']"));
		
		
		email_2.sendKeys("saidurrshovon@gmail.com");
		Thread.sleep(2000);
		password_2.sendKeys("12345");
		Thread.sleep(2000);
		signin_btn_2.click();
		Thread.sleep(2000);
		String showText_2 = driver.findElement(By.xpath("//p[normalize-space()='Wrong email/phone or password']")).getText();	
		Assert.assertEquals(showText_2, "Wrong email/phone or password");
		Thread.sleep(2000);
		WebElement closeWarning_2 = driver.findElement(By.xpath("//span[@aria-hidden='true']"));
		closeWarning_2.click();
		Thread.sleep(3000);
	}
	@Test(priority = 6)
	public void verifySignInPageWithoutCredentials() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200);");
		Thread.sleep(2000);
		WebElement email_3 = driver.findElement(By.xpath("//input[@id='j_username']"));
		WebElement password_3 = driver.findElement(By.xpath("//input[@id='j_password']"));
		WebElement signin_btn_3 = driver.findElement(By.xpath("//button[normalize-space()='Sign In']"));
		
		
		email_3.sendKeys("");
		Thread.sleep(1000);
		password_3.sendKeys("");
		Thread.sleep(1000);
		signin_btn_3.click();
		Thread.sleep(2000);
		String showText_3_email = driver.findElement(By.xpath("//div[@id='js--login-form']//div[1]//div[1]//p[1]")).getText();	
		Assert.assertEquals(showText_3_email, "This field is required!");
		Thread.sleep(1000);
		String showText_3_password = driver.findElement(By.xpath("//div[@id='js--login-form']//div[1]//div[1]//p[1]")).getText();	
		Assert.assertEquals(showText_3_password, "This field is required!");
		Thread.sleep(3000);
	}
	@Test(priority = 7)
	public void verifySignInPageWithValidCredentials() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,200);");
		Thread.sleep(2000);
		WebElement email_4 = driver.findElement(By.xpath("//input[@id='j_username']"));
		WebElement password_4 = driver.findElement(By.xpath("//input[@id='j_password']"));
		WebElement signin_btn_4 = driver.findElement(By.xpath("//button[normalize-space()='Sign In']"));
		
		
		email_4.sendKeys("saidurrshovon@gmail.com");
		Thread.sleep(2000);
		password_4.sendKeys("Rokomari@01");
		Thread.sleep(2000);
		signin_btn_4.click();
		Thread.sleep(3000);
	}
	@Test(priority = 8)
	public void verifyLekhokOption() throws InterruptedException {
		Actions action = new Actions (driver);
		WebElement lekhok = driver.findElement(By.xpath("//a[@id='js--authors']"));
		action.moveToElement(lekhok).perform();
		Thread.sleep(3000);
	}
	@Test(priority = 9)
	public void verifyHumayunAhmedOption() throws InterruptedException {
		WebElement humayunA = driver.findElement(By.xpath("//a[contains(text(),'হুমায়ূন আহমেদ')]"));
		humayunA.click();
		Thread.sleep(3000);
	}
	@Test(priority = 10)
	public void verifyFilter() throws InterruptedException {		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement filter = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Filter']")));
		js.executeScript("arguments[0].scrollIntoView();", filter);
		Thread.sleep(2000);
		
		WebElement somokalinU= driver.findElement(By.xpath("//label[contains(text(),'সমকালীন উপন্যাস')]"));
		somokalinU.click();
		Thread.sleep(2000);
		WebElement filter1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[normalize-space()='Filter']")));
		js.executeScript("arguments[0].scrollIntoView();", filter1);
		Thread.sleep(2000);
		WebElement rochonaSomogra= driver.findElement(By.xpath("//label[contains(text(),'রচনা সংকলন ও সমগ্র')]"));
		rochonaSomogra.click();
		Thread.sleep(3000);
	}
	@Test(priority = 11)
	public void verifyPagination() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,6000);");
		Thread.sleep(2000);
		
		WebElement nextPage= driver.findElement(By.xpath("//body//div//section//a[4]"));
		nextPage.click();
		Thread.sleep(3000);
	}
	@Test(priority = 12)
	public void verifyAddToCart() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement scrollDown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[contains(text(),'হুমায়ূন আহমেদ এর বই সমূহ')]")));
		js.executeScript("arguments[0].scrollIntoView();", scrollDown);
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		WebElement hoverProduct= driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]"));
		action.moveToElement(hoverProduct).perform();
		WebElement addToCart= driver.findElement(By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[1]/section[2]/div[2]/div[1]/div[1]/div[1]/a[1]/div[1]/div[2]/button[1]"));
		addToCart.click();
		Thread.sleep(3000);
	}
	@Test(priority = 13)
	public void verifyClickToCart() throws InterruptedException {
		WebElement clickToCart= driver.findElement(By.id("cart-icon"));
		clickToCart.click();
		Thread.sleep(3000);
	}
	@Test(priority = 14)
	public void verifyPlaceOrder() throws InterruptedException {
		WebElement placeOrder= driver.findElement(By.xpath("//span[normalize-space()='Place Order']"));
		placeOrder.click();
		Thread.sleep(3000);
	}
	@Test(priority = 15)
	public void verifyCheckoutForm() throws InterruptedException {
		WebElement city= driver.findElement(By.xpath("//select[@id='js--city']"));
		Select selectCity=new Select(city);
		selectCity.selectByValue("43");
		Thread.sleep(2000);
		
		WebElement area= driver.findElement(By.xpath("//select[@id='js--area']"));
		Select selectArea=new Select(area);
		selectArea.selectByValue("400");
		Thread.sleep(2000);
		
		WebElement zone= driver.findElement(By.xpath("//select[@id='js--zone']"));
		Select selectZone=new Select(zone);
		selectZone.selectByValue("1519");
		Thread.sleep(2000);
		
		WebElement address = driver.findElement(By.xpath("//form[@method='POST']//div//div//textarea[@id='address']"));
		address.sendKeys("Nothullahbad, Barishal");
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement paymentMethod = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h3[normalize-space()='Payment Method']")));
		js.executeScript("arguments[0].scrollIntoView();", paymentMethod);
		Thread.sleep(2000);
		WebElement payment= driver.findElement(By.xpath("//label[@for='cod']"));
		payment.click();
		Thread.sleep(3000);
	}

}
