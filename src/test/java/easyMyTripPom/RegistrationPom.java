package easyMyTripPom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import easyMyTrip.Base;

public class RegistrationPom extends Base {

	@FindBy(className = "my_account")
	protected WebElement accountRegistration;

	@FindBy(className = "signup_pnl")
	protected WebElement loginOrSignupButton;

	@FindBy(className = "i-eml")
	protected WebElement errorMsg;

	@FindBy(id = "txtEmail")
	protected WebElement username;

	@FindBy(className = "sign-inn-v1")
	protected WebElement continueButton;

	@FindBy(id = "txtEmail1")
	protected WebElement otpInput;

	@FindBy(className = "otpsn")
	protected WebElement otpResendLink;

	@FindBy(id = "OtpLgnBtn")
	protected WebElement login;

	@FindBy(id = "OTPsent")
	protected WebElement otpResentSuccessMsg;

	@FindBy(id = "ValidOtp")
	protected WebElement otpIsNotValidMsg;
}
