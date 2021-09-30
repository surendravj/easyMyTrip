package easyMyTrip;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;


public class Hotels extends Base {
	

	public Hotels() throws IOException {
		loadProps();
		intilizeDriver(props.getProperty("browser"));
		PageFactory.initElements(driver, this);
	}

	
}
