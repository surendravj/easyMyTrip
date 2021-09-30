package easyMyTrip;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;



public class Flights extends Base {

	public Flights() throws IOException {
		loadProps();
		intilizeDriver(props.getProperty("browser"));
		PageFactory.initElements(driver, this);
	}

}
