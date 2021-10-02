package easyMyTrip;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import easyMyTripPom.FlightsOneTripPom;

public class FlightsOneTrip extends FlightsOneTripPom {
	public FlightsOneTrip() throws IOException {
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
	public void NavigateToOneWay() {
		flights.click();
		assertEquals("FLIGHTS", flights.getText());
		assertEquals("One-Way", oneway.getText());
		oneway.click();
	}
	
	@Test(priority = 2)
	public void departureCitySelect() {
		setSheet(0);
		from.click();
		assertTrue(l3.size() >= 1);
		from.sendKeys(getValue(2, 1));
		fromCity.click();
	}
	
	@Test(priority = 3)
	public void selectDestinationCity() throws InterruptedException {
		setSheet(0);
		to.click();
		assertTrue(l4.size() >= 1);
		to.sendKeys(getValue(2, 2));
		toCity.click();
	}
	
	@Test(priority = 4)
	public void dateSelect() {
		startdate.click();
		startdateClick.click();	
		
	}
	
	@Test(priority = 5)
	public void checkClassSelection() {
		travellerDropdown.click();
		business.click();
		assertTrue(business.isEnabled());
		premEconomy.click();
		assertTrue(premEconomy.isEnabled());
		economy.click();
		assertTrue(economy.isEnabled());
	}
	
	@Test(priority = 6)
	public void selectTravellers() {
		adultadd.click();
		adultsub.click();
		infantsadd.click();
		infantssub.click();
		childrenadd.click();
		childrensub.click();
		doneButton.click();
		assertTrue(travellerDropdown.getText().contains("1 Traveller(s)"));
		searchButton.click();
	}
	
	@Test(priority = 7)
	public void selectFare() {
		morefare.click();
		saverfare.isSelected();
		Flexiplusfare.isDisplayed();
		morefare.click();
		booknow.click();
	}
	
	@Test(priority = 8)
	public void refundPolicy() {
		yesrefund.click();
		assertEquals(yesrefund.getText(), "Yes, I want to add Medical Refund Policy (FREE) to this flight");
		assertTrue(yesrefund.isEnabled());
		norefund.click();
		assertEquals(norefund.getText(), "No, I don't wish to add Medical Refund Policy (FREE) to this flight");
		assertTrue(norefund.isEnabled());
	}
	
	@Test(priority = 9)
	public void travelInsurance() {
		yesinsurance.click();
		assertTrue(yesinsurance.isEnabled());
		assertEquals(yesinsurance.getText(), "Yes, I want to secure my trip with insurance.");
		assertTrue(yesinsurancemsg.isDisplayed());
		assertEquals(yesinsurancemsg.getText(), "More than 36% of our customers choose to secure their trip.");
		noinsurance.click();
		assertTrue(noinsurance.isEnabled());
		assertEquals(noinsurance.getText(), "No, I do not want to insure my trip");
		waitSomeTime();
		assertTrue(warningmsg.isDisplayed());
		}
	
	@Test(priority =10)
	public void contactEmail() {
		moveToElement(driver.findElement(By.cssSelector(".emtSecure")));
		emailInput.clear();
		continueBookingBtn.click();
		assertTrue(emailErrorMsg.isDisplayed());
		assertEquals(emailErrorMsg.getText(), "Please enter a valid email Id");
		setSheet(0);
		emailInput.sendKeys(getValue(2, 3));
		continueBookingBtn.click();
	}
	
	@Test(priority =13)
	public void travellerDetails() {
		assertTrue(infomsg.isDisplayed());
		assertTrue(adultcheckbox.isEnabled());
		waitSomeTime();
		adultTitle.click();
		waitSomeTime();
		titleMr.click();
		setSheet(0);
		adultFirtsName.sendKeys(getValue(2, 9));
		adultLastName.sendKeys(getValue(2, 10));
		frequentflyer.click();
		waitSomeTime();
		frequentflyernumber.click();
		frequentflyernumber.sendKeys(props.getProperty("flyerno"));
		airlines.sendKeys(getValue(2, 11));
		mealpreference.click();
		waitSomeTime();
		nonveg.click();
		assertEquals(grandtotalprice.getText(),"4,078");
	}
	
	@Test(priority = 12)
	public void couponOffer() {
		assertEquals(grandtotalprice.getText(),"5,178");
		removecouponcode.click();
		waitSomeTime();
		couponcode.click();
		waitSomeTime();
	}
	
	@Test(priority =11)
	public void enterPhoneNumber() throws Exception {
		phonenumber.sendKeys(props.getProperty("mobileNumber"));
		assertTrue(checkboxTandC.isEnabled());
		contBooking.click();
		Thread.sleep(5000);
	}
	
	
	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
