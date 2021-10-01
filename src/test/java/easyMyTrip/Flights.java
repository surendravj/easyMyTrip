package easyMyTrip;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import easyMyTripPom.FlightsPom;

public class Flights extends FlightsPom {

	public Flights() throws IOException {
		loadProps();
		intilizeDriver(props.getProperty("browser"));
		PageFactory.initElements(driver, this);
	}

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
	}

	@Test(priority = 1)
	public void NavigateToFlights() {
		flights.click();
		assertEquals("FLIGHTS", flights.getText());
		assertEquals("Round-Trip", roundTrip.getText());
		roundTrip.click();
	}

	@Test(priority = 2)
	public void selectDepartureCity() {
		setSheet(0);
		from.click();
		assertTrue(l1.size() >= 1);
		from.sendKeys(getValue(1, 1));
		fromCityClick.click();
	}

	@Test(priority = 3)
	public void selectDestinationCity() throws InterruptedException {
		setSheet(0);
		to.click();
		assertTrue(l2.size() >= 1);
		to.sendKeys(getValue(1, 2));
		toCityClick.click();
	}

	@Test(priority = 4)
	public void selectDates() {
		startdate.click();
		startdateSelect.click();
		returndate.click();
		returndateSelect.click();
	}

	@Test(priority = 5)
	public void checkClassSelectionTest() {
		travellerDropdown.click();
		premEconomy.click();
		assertTrue(premEconomy.isEnabled());
		economy.click();
		assertTrue(economy.isEnabled());
		business.click();
		assertTrue(business.isEnabled());
	}

	@Test(priority = 6)
	public void selectTravellers() {
		adultadd.click();
		infantsadd.click();
		childrenadd.click();
		childrensub.click();
		doneButton.click();
		assertTrue(travellerDropdown.getText().contains("3 Traveller(s)"));
		searchButton.click();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
