package easyMyTrip;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import easyMyTripPom.HotelsPom;

public class Hotels extends HotelsPom {

	public Hotels() throws IOException {
		loadProps();
		intilizeDriver(props.getProperty("browser"));
		PageFactory.initElements(driver, this);
	}

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() {
		driver.get(props.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void navigationToHotels() {
		waitSomeTime();
		assertTrue(hotels_icon.isDisplayed());
		assertTrue(hotels_icon.isEnabled());
		hotels_icon.click();
		assertTrue(driver.getCurrentUrl().contains(("hotel")));
	}

	@Test(priority = 2)
	public void HotelLocationEnable() {

		setSheet(1);
		waitSomeTime();
		click_loc.click();
		assertTrue(click_loc.isEnabled());
		enter_loc.sendKeys(getValue(1, 0));
		waitSomeTime();
		driver.navigate().refresh();
	}

	@Test(priority = 3)
	public void SelectHotelLocation() {

		click_loc.click();
		setSheet(1);
		enter_loc.sendKeys(getValue(1, 1));
		@SuppressWarnings("deprecation")
		WebDriverWait wait1 = new WebDriverWait(driver, 3);
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("ui-menu-item")));
		enter_loc.sendKeys(Keys.ARROW_DOWN);
		enter_loc.sendKeys(Keys.ENTER);
		WebElement E1 = select_loc;
		E1.click();
		Actions a = new Actions(driver);
		a.moveToElement(E1).doubleClick().build().perform();
		waitSomeTime();
	}

	@Test(priority = 4)
	public void selectDates() {

		Actions a = new Actions(driver);
		WebElement E2 = check_in;
		a.moveToElement(E2).click().build().perform();
		waitSomeTime();
		WebElement E3 = check_out;
		a.moveToElement(E3).click().build().perform();
	}

	@Test(priority = 5)
	public void addGuests() {

		add_adult.click();
		assertTrue(add_adult.isEnabled());
		assertTrue(add_child.isEnabled());
		add_child.click();
		Select s1 = new Select(add_child_age);
		s1.selectByIndex(2);
		Add_Room.click();
		assertTrue(Add_Room.isEnabled());
		add_adult2.click();
		add_child2.click();
		Select s2 = new Select(add_child_age2);
		s2.selectByIndex(5);
		removeroom.click();
		assertTrue(removeroom.isEnabled());
		exit_Room.click();
		assertTrue(exit_Room.isEnabled());
	}

	@Test(priority = 6)
	public void searchHotel() {

		assertTrue(search.isDisplayed());
		assertTrue(search.isEnabled());
		search.click();
		waitSomeTime();
	}

	@Test(priority = 7)
	public void applyingFilters() {

		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id=\"sidebar\"]/div/div[6]/label[1]")));
		Star_Rating.click();
		// trip_rating.click();
		waitSomeTime();
	}

	@Test(priority = 8)
	public void selectingHotel() {

		@SuppressWarnings("deprecation")
		WebDriverWait wait1 = new WebDriverWait(driver, 3);
		wait1.until(ExpectedConditions.elementToBeClickable(By.id("hotelListDiv")));
		List<WebElement> dlist = driver.findElements(By.id("hotelListDiv"));

		waitSomeTime();
		dlist.get(0).click();
	}

	@Test(priority = 9)
	public void bookHotel() throws InterruptedException {

		waitSomeTime();
		driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
		BookNow.click();

	}

	@Test(priority = 10)
	public void passengerDetails() {
		System.out.println(driver.getCurrentUrl());
		setSheet(2);
		waitSomeTime();
		gender.click();
		genderMiss.click();
		fnameA.click();
		fnameA.sendKeys(getValue(1, 0));
		lnameA.click();
		lnameA.sendKeys(getValue(1, 1));
		child_gender.click();
		child_master.click();
		childfname.sendKeys(getValue(1, 4));
		childlname.click();
		childlname.sendKeys(getValue(1, 5));

	}

	@Test(priority = 11)
	public void personalDetails() {
		emailid.sendKeys(getValue(1, 2));
		mobile.sendKeys(getValue(1, 3));
		continue_to_payment.click();
	}

	@Test(priority = 12)
	public void paymentDetails() {
		setSheet(3);
		card_number.sendKeys(getValue(1, 1));
		card_holder_name.sendKeys(getValue(1, 0));
		card_month.click();
		card_month_6.click();
		card_year.click();
		card_year_28.click();
		cvv.sendKeys(getValue(1, 2));
		make_payment.click();
	}

	@AfterClass
	public void afterClass() throws InterruptedException {
		 driver.quit();
	}

}