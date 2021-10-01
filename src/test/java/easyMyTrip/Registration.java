package easyMyTrip;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import easyMyTripPom.RegistrationPom;

public class Registration extends RegistrationPom {

	public Registration() throws IOException {
		loadProps();
		intilizeDriver(props.getProperty("browser"));
		PageFactory.initElements(driver, this);
	}


	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() throws IOException {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
	}

	// function to fill mobile number
	public void FillForm(String number) {
		accountRegistration.click();
		waitSomeTime();
		loginOrSignupButton.click();
		username.sendKeys(number);
		continueButton.click();
	}

	// function to fill otp using scanner
	public void fillOtp() {
		try (Scanner sc = new Scanner(System.in)) {
			String otp = sc.next();
			otpInput.sendKeys(otp);
		}
	}

	@Test(priority = 3)
	public void SuccesfullRegister() throws Exception {
		FillForm(props.getProperty("mobileNumber"));
		fillOtp();
		login.click();
	}

	@Test(priority = 1)
	public void invalidMobileNumberTest() {
		FillForm(props.getProperty("wrongMobileNumber"));
		boolean isErrorMsgDisplayed = errorMsg.isDisplayed();
		assertTrue(isErrorMsgDisplayed);
		assertEquals("* Enter a valid Phone Number", errorMsg.getText());
		driver.navigate().refresh();
	}

	@Test(priority = 2)
	public void otpResendTest() throws Exception {
		FillForm(props.getProperty("mobileNumber"));
		waitSomeTime();
		otpResendLink.click();
		waitSomeTime();
		assertTrue(otpResentSuccessMsg.isDisplayed());
		assertEquals("OTP sent successfully", otpResentSuccessMsg.getText());
		fillOtp();
		login.click();
	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}
}
