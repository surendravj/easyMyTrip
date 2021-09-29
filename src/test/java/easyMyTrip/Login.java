package easyMyTrip;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;


public class Login extends Base {

	Login() throws IOException {
		intilizeDriver("google");
		PageFactory.initElements(driver, this);
		System.out.println("Login");
	}
	
}
