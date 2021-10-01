package easyMyTrip;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Scanner;

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


	@BeforeClass
	public void beforeClass() throws IOException {
		driver.manage().window().maximize();
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

	@Test
	public void test1() throws Exception {
		FillForm(props.getProperty("mobileNumber"));
		fillOtp();
		login.click();
	}

	@Test
	public void test2() {
		FillForm(props.getProperty("wrongMobileNumber"));
		boolean isErrorMsgDisplayed = errorMsg.isDisplayed();
		assertTrue(isErrorMsgDisplayed);
		assertEquals("* Enter a valid Phone Number", errorMsg.getText());
	}

	@Test
	public void test3() throws Exception {
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
