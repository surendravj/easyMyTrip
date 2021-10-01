package easyMyTripPom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import easyMyTrip.Base;

public class LoginPom extends Base {

	@FindBy(className = "my_account")
	protected WebElement accountRegistration;

	@FindBy(className = "signup_pnl")
	protected WebElement loginBtn;

	@FindBy(id = "txtEmail")
	protected WebElement numberInput;

	@FindBy(className = "sign-inn-v1")
	protected WebElement continueButton;

	@FindBy(id = "shwlgnbx")
	protected WebElement usePasswordLink;

	@FindBy(id = "txtEmail2")
	protected WebElement passwordInput;

	@FindBy(css="div[id='emailgnBox'] div[class='mgt15']")
	protected WebElement loginButton;

	@FindBy(className = "i-eml")
	protected WebElement errorMsg;
	
	@FindBy(id = "ValidPass")
	protected WebElement passwordErrorMsg;
	
}
