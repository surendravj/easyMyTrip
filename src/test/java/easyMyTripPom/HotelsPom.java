package easyMyTripPom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import easyMyTrip.Base;

public class HotelsPom extends Base {

	@FindBy(xpath = "//div[@class='ng-scope']//a[normalize-space()='Hotels']")
	protected WebElement hotels_icon;

	@FindBy(xpath = "//div[@class='htl_location']/span[1]")
	protected WebElement click_loc;

	@FindBy(xpath = "//input[@name='txtCity']")
	protected WebElement enter_loc;

	@FindBy(xpath = "/html/body/div[2]/div/div[4]/div/div[1]")
	protected WebElement select_loc;

	@FindBy(xpath = "//*[@id=\"htl_dates\"]")
	protected WebElement checkin_button;

	@FindBy(xpath = "//div[@id='ui-datepicker-div']/div[1]/table[1]/tbody[1]/tr[4]/td[6]/a")
	protected WebElement check_in;

	@FindBy(xpath = "//div[@id='ui-datepicker-div']/div[1]/table[1]/tbody[1]/tr[5]/td[1]/a")
	protected WebElement check_out;

	@FindBy(xpath = "//a[normalize-space()='Add Room']")
	protected WebElement Add_Room;

	@FindBy(id = "Adults_room_1_1_plus")
	protected WebElement add_adult;

	@FindBy(id = "Adults_room_1_1_minus")
	protected WebElement sub_adult;

	@FindBy(id = "Children_room_1_1_plus")
	protected WebElement add_child;

	@FindBy(id = "Child_Age_1_1")
	protected WebElement add_child_age;

	@FindBy(id = "Children_room_1_1_minus")
	protected WebElement sub_child;

	@FindBy(id = "Adults_room_2_2_plus")
	protected WebElement add_adult2;

	@FindBy(id = "Children_room_2_2_plus")
	protected WebElement add_child2;

	@FindBy(id = "Child_Age_2_1")
	protected WebElement add_child_age2;

	@FindBy(id = "removehotelRoom")
	protected WebElement removeroom;

	@FindBy(xpath = "//*[@id=\"exithotelroom\"]")
	protected WebElement exit_Room;

	@FindBy(xpath = "/html/body/div[2]/div/div[4]/div/div[4]/input")
	protected WebElement search;

	@FindBy(xpath = "//*[@id=\"sidebar\"]/div/div[6]/label[1]")
	protected WebElement Star_Rating;

	@FindBy(xpath = "//*[@id=\"rating-filter\"]/label[1]")
	protected WebElement trip_rating;

	@FindBy(xpath = "//*[@id=\"drpHighList\"]")
	protected WebElement sortBy;

	@FindBy(xpath = "//*[@id=\"drpHighList\"]/option[2]")
	protected WebElement priceLtoH;

	@FindBy(xpath = "//div[@class='right-content']//div[2]//div[2]//div[1]//div[1]//a[1]//div[6]")
	protected WebElement selectHotel;

	@FindBy(xpath = "//div[@class='btnhcol']//a[@class='fill-btn'][normalize-space()='Book Now']")
	protected WebElement BookNow;

	@FindBy(xpath = "//*[@id=\"btnTravellerContinue\"]/div[1] ")
	protected WebElement Payment;

	@FindBy(css = "#ddlGender1")
	protected WebElement gender;

	@FindBy(xpath = "//option[@value='Miss.']")
	protected WebElement genderMiss;

	@FindBy(xpath = "//option[@value='Mr.']")
	protected WebElement genderMr;

	@FindBy(xpath = "//option[@value='Miss.']")
	protected WebElement genderMrs;

	@FindBy(css = "#txtFirstName1")
	protected WebElement fnameA;

	@FindBy(css = "#txtLastName1")
	protected WebElement lnameA;

	@FindBy(xpath = "//select[@id='ddlChildGender']")
	protected WebElement child_gender;

	@FindBy(xpath = "//option[@value='Master']")
	protected WebElement child_master;

	@FindBy(xpath = "//option[@value='Miss']")
	protected WebElement child_miss;

	@FindBy(css = "#txtFirstNameChild1")
	protected WebElement childfname;

	@FindBy(css = "#txtLastNameChild1")
	protected WebElement childlname;

	@FindBy(xpath = "//input[@id='txtEmailId']")
	protected WebElement emailid;

	@FindBy(xpath = "//input[@id='txtCPhone']")
	protected WebElement mobile;

	@FindBy(css = "label[class='ctr_cbox lh18'] span[class='cmark_cbox']")
	protected WebElement gstcheckbox;

	@FindBy(xpath = "//div[@class='coonpayment']")
	protected WebElement continue_to_payment;

	@FindBy(xpath = "//input[@id='CC']")
	protected WebElement card_number;

	@FindBy(xpath = "//input[@id='CCN']")
	protected WebElement card_holder_name;

	@FindBy(xpath = "//select[@id='CCMM']")
	protected WebElement card_month;

	@FindBy(xpath = "//option[@value='06']")
	protected WebElement card_month_6;

	@FindBy(xpath = "//select[@id='CCYYYY']")
	protected WebElement card_year;

	@FindBy(xpath = "//*[@id=\"CCCVV\"]")
	protected WebElement cvv;

	@FindBy(xpath = "//option[@value='2028']")
	protected WebElement card_year_28;

	@FindBy(xpath = "//div[@ng-click='CardValidation(RoomDetails.Rooms.engine)']")
	protected WebElement make_payment;

}