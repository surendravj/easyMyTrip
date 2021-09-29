package easyMyTrip;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;



public class Flights extends Base {

	public Flights() throws IOException {
		intilizeDriver("google");
		PageFactory.initElements(driver, this);
		System.out.println("Flights");
	}

}
