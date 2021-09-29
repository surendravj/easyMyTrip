package easyMyTrip;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;


public class Hotels extends Base {
	

	public Hotels() throws IOException {
		intilizeDriver("google");
		PageFactory.initElements(driver, this);
		System.out.println("Hotels");
	}

	
}
