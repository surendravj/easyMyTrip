package easyMyTrip;

import java.io.IOException;
import org.openqa.selenium.support.PageFactory;


public class Registration extends Base {

	
	public Registration() throws IOException {
		intilizeDriver("google");
		PageFactory.initElements(driver, this);
		System.out.println("Registration");
	}

	
}
