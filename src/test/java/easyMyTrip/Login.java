package easyMyTrip;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import easyMyTripPom.LoginPom;

public class Login extends LoginPom {

	Login() throws IOException {
		loadProps(); // loading props from config.properties
		intilizeDriver(props.getProperty("browser")); // selection of the web browser
		PageFactory.initElements(driver, this);
	}

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
	}

	public void fillNumber(String number) {
		accountRegistration.click();
		loginBtn.click();
		numberInput.sendKeys(number);
		continueButton.click();
	}

	@Test(priority = 3)
	public void successFullLoginTest() {
		driver.navigate().refresh();
		fillNumber(props.getProperty("mobileNumber2"));
		usePasswordLink.click();
		passwordInput.sendKeys(props.getProperty("loginPassword"));
		loginButton.click();
		System.out.println("Login Successful");
	}

	@Test(priority = 1)
	public void InvalidMobileNumberTest() {
		fillNumber(props.getProperty("wrongMobileNumber"));
		assertTrue(errorMsg.isDisplayed());
		assertEquals("* Enter a valid Phone Number", errorMsg.getText());
	}

	@Test(priority = 2)
	public void invalidPasswordTest() throws InterruptedException {
		driver.navigate().refresh();
		fillNumber(props.getProperty("mobileNumber2"));
		usePasswordLink.click();
		passwordInput.sendKeys(props.getProperty("wrongLoginPassword"));
		loginButton.click();
		Thread.sleep(1000);
		assertEquals(passwordErrorMsg.getText(), "* Enter valid Password");
	}
	
	

	@AfterClass
	public void afterclass() {
		driver.quit();
	}

}
