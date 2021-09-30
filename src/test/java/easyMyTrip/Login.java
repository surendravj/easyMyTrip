package easyMyTrip;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends Base {

	Login() throws IOException {
		loadProps(); // loading props from config.properties
		intilizeDriver(props.getProperty("browser")); // selection of the web browser
		PageFactory.initElements(driver, this);
	}

	By my_account = By.className("my_account");
	By log_in = By.cssSelector("a.btn_loginnew");
	By in_data = By.id("txtEmail");
	By cont = By.cssSelector("input#shwotp");
	By use_pass = By.id("shwlgnbx");
	By pass_word = By.id("txtEmail2");
	By logged_in = By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input");
	By errorMsg = By.className("i-eml");
	By validPasswordError = By.id("ValidPass");

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
	}

	public void fillNumber(String number) {
		driver.findElement(my_account).click();
		driver.findElement(log_in).click();
		driver.findElement(in_data).sendKeys(number);
		driver.findElement(cont).click();
	}

	@Test(priority = 3)
	public void successFullLoginTest() {
		driver.navigate().refresh();
		fillNumber(props.getProperty("mobileNumber2"));
		driver.findElement(use_pass).click();
		driver.findElement(pass_word).sendKeys(props.getProperty("loginPassword"));
		driver.findElement(logged_in).click();
		System.out.println("Login Successful");
	}

	@Test(priority = 1)
	public void InvalidMobileNumberTest() {
		fillNumber(props.getProperty("wrongMobileNumber"));
		assertTrue(driver.findElement(errorMsg).isDisplayed());
		assertEquals("* Enter a valid Phone Number", driver.findElement(errorMsg).getText());
	}

	@Test(priority = 2)
	public void invalidPasswordTest() throws InterruptedException {
		driver.navigate().refresh();
		fillNumber(props.getProperty("mobileNumber2"));
		driver.findElement(use_pass).click();
		driver.findElement(pass_word).sendKeys(props.getProperty("wrongLoginPassword"));
		driver.findElement(logged_in).click();
		Thread.sleep(1000);
		assertEquals(driver.findElement(validPasswordError).getText(), "* Enter valid Password");
	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}

}
