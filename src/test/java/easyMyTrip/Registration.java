package easyMyTrip;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registration extends Base {

	public Registration() throws IOException {
		intilizeDriver("google");
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "my_account")
	private WebElement accountRegistration;

	@FindBy(className = "signup_pnl")
	private WebElement loginOrSignupButton;

	@FindBy(className = "i-eml")
	private WebElement errorMsg;

	@FindBy(id = "txtEmail")
	private WebElement username;

	@FindBy(className = "sign-inn-v1")
	private WebElement continueButton;

	@FindBy(id = "txtEmail1")
	private WebElement otpInput;

	@FindBy(className = "otpsn")
	private WebElement otpResendLink;

	@FindBy(id = "OtpLgnBtn")
	private WebElement login;

	@FindBy(id = "OTPsent")
	private WebElement otpResentSuccessMsg;

	@FindBy(id = "ValidOtp")
	private WebElement otpIsNotValidMsg;

	
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

	
	//function to fill otp using scanner
	public void fillOtp() {
		try (Scanner sc = new Scanner(System.in)) {
			String otp = sc.next();
			otpInput.sendKeys(otp);
		}
	}

	@Test
	public void test1() throws Exception {
		FillForm("9676258512");
		fillOtp();
		login.click();
	}

	@Test
	public void test2() {
		FillForm("877848484");
		boolean isErrorMsgDisplayed = errorMsg.isDisplayed();
		assertTrue(isErrorMsgDisplayed);
		assertEquals("* Enter a valid Email or Phone Number", errorMsg.getText());
	}

	@Test
	public void test3() throws Exception {
		FillForm("9676258512");
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
