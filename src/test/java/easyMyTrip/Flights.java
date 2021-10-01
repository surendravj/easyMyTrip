package easyMyTrip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		driver.get(props.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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

	@SuppressWarnings("deprecation")
	@Test(priority = 7)
	public void chooseFlightsTest() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		fromFlightSelection.click();
		toFlightSelection.click();
	}

	@Test(priority = 8)
	public void verifyFlightDetails() {
		assertEquals("AI-541", fromFlightId.getText());
		assertEquals("AI-542", toFlightId.getText());
		Integer totalPrice = Integer.valueOf(fromFlightPrice.getText().replaceAll(",", ""))
				+ Integer.valueOf(toFlightPrice.getText().replaceAll(",", ""));
		assertEquals(totalPrice.toString(), flightTotalPrice.getText().replaceAll(",", ""));
		bookNowBtn.click();
		continueBtn.click();
	}
	
	
	

	@Test(priority = 9)
	public void flightDetailsTest()
	{
		moveToElement(medicalRefundDiv);
		assertFalse(!medicalRefundText.isDisplayed());
		medicalRefundCheckBox.click();
		assertTrue(medicalRefundCheckBox.isEnabled());
		assertTrue(medicalRefundText.isDisplayed());
		moveToElement(continueBookingBtn);
		insurance.click();
		assertTrue(insurance.isEnabled());
	}
	
	
	@Test(priority = 10)
	public void verifyContactEmail()
	{
		moveToElement(driver.findElement(By.cssSelector(".emtSecure")));
		emailInput.clear();
		continueBookingBtn.click();
		assertTrue(emailErrorMsg.isDisplayed());
		assertEquals(emailErrorMsg.getText(), "Please enter a valid email Id");
		emailInput.sendKeys("Vadaparthysurendra@gmal.com");
		continueBookingBtn.click();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}

}
