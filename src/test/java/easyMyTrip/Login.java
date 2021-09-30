package easyMyTrip;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;


public class Login extends Base {

	Login() throws IOException {
		loadProps();
		intilizeDriver(props.getProperty("browser"));
		PageFactory.initElements(driver, this);
	}
	
}
