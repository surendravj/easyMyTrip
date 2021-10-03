package easyMyTrip;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
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
		adultsub.click();
		infantssub.click();
		doneButton.click();
		assertTrue(travellerDropdown.getText().contains("1 Traveller(s)"));
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
	public void flightDetailsTest() {
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
	public void emailErrorMsgTest() {
		setSheet(0);
		moveToElement(driver.findElement(By.cssSelector(".emtSecure")));
		emailInput.clear();
		continueBookingBtn.click();
		assertTrue(emailErrorMsg.isDisplayed());
		assertEquals(emailErrorMsg.getText(), "Please enter a valid email Id");
	}

	@Test(priority = 11)
	public void verifyContactEmail() {
		emailInput.sendKeys(getValue(1, 3));
		continueBookingBtn.click();

	}

	@Test(priority = 12)
	public void invalidNumberTest() {
		setSheet(0);
		mobileNumber.clear();
		driver.findElement(By.xpath("//span[@id='spnTransaction']")).click();
		assertTrue(mobileNumberError.isDisplayed());
		assertEquals(mobileNumberError.getText(), "Please enter a valid mobile number");
	}

	@Test(priority = 13)
	public void verifyContactNumber() {
		setSheet(0);
		mobileNumber.sendKeys(getValue(1, 5));
		assertTrue(mobileNumberError.isDisplayed());
		assertEquals(mobileNumberError.getText(), "Please enter a valid mobile number");
		mobileNumber.sendKeys(getValue(1, 4));
	}

	@Test(priority = 14)
	public void firstNameInputTest() {
		moveToElement(driver.findElement(By.cssSelector(".add_adlt")));
		passengerName.sendKeys(getValue(2, 9));
		assertEquals(passengerName.getAttribute("value"), "Surendra");
	}

	@Test(priority = 15)
	public void lastNameInputTest() {
		passengerLastName.sendKeys(getValue(2, 10));
		assertEquals(passengerLastName.getAttribute("value"), "Vadaparthy");
	}

	@Test(priority = 16)
	public void passengerTitleTest() {
		Select titles = new Select(passengerTitle);
		titles.selectByIndex(1);
		assertEquals(titles.getFirstSelectedOption().getText(), "MR");
	}

//	@Test(priority = 17)
//	public void paymentGateWayVerification() throws InterruptedException {
//		setSheet(0);
//		makePaymentBtn.click();
//		assertTrue(cardNumberErrorMsg.isDisplayed());
//		System.out.println(cardNumberErrorMsg.getText());
//		cardNumber.sendKeys(getValue(1, 6));
//		cardHolderName.sendKeys(getValue(1, 7));
//		cvvNumber.sendKeys(getValue(1, 8));
//	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		driver.quit();
	}

}
