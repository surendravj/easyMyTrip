package easyMyTripPom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import easyMyTrip.Base;

public class FlightsPom extends Base {
	@FindBy(css = "div[class='emt_header_full'] li:nth-child(1)")
	protected WebElement flights;

	@FindBy(css = ".click-round.flig-show")
	protected WebElement roundTrip;

	@FindBy(id = "FromSector_show")
	protected WebElement from;

	@FindBy(css = "div[id='ui-id-16'] span[class='arpn']")
	protected WebElement fromCityClick;

	@FindBy(id = "Editbox13_show")
	protected WebElement to;

	@FindBy(xpath = "//span[normalize-space()='New Delhi(DEL)']")
	protected WebElement toCityClick;

	@FindBy(css = "#ddate")
	protected WebElement startdate;

	@FindBy(id = "snd_3_06/10/2021")
	protected WebElement startdateSelect;

	@FindBy(css = "#rdate")
	protected WebElement returndate;

	@FindBy(id = "fiv_6_30/10/2021")
	protected WebElement returndateSelect;

	@FindBy(css = "div[class='mobile-wi1 flig-show1'] a[class='dropbtn_n']")
	protected WebElement travellerDropdown;

	@FindBy(css = "body > div:nth-child(17) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label:nth-child(6)")
	protected WebElement premEconomy;

	@FindBy(css = "body > div:nth-child(17) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label:nth-child(5)")
	protected WebElement economy;

	@FindBy(css = "body > div:nth-child(17) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label:nth-child(7) > span:nth-child(2)")
	protected WebElement business;

	@FindBy(css = "div[id='fromautoFill'] ul")
	protected List<WebElement> l1;

	@FindBy(css = "div[id='toautoFill'] ul")
	protected List<WebElement> l2;

	@FindBy(css = "div[class='mobile-wi1 flig-show1'] div[class='innr_pnl'] div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(3) input:nth-child(1)")
	protected WebElement adultadd;

	@FindBy(css = "#optAdult")
	protected WebElement adultQuantity;

	@FindBy(css = "div[class='mobile-wi1 flig-show1'] div:nth-child(3) div:nth-child(2) div:nth-child(1) div:nth-child(3) input:nth-child(1)")
	protected WebElement infantsadd;

	@FindBy(css = "div[class='mobile-wi1 flig-show1'] div[class='innr_pnl'] div:nth-child(1) div:nth-child(2) div:nth-child(1) div:nth-child(1) input:nth-child(1)")
	protected WebElement adultsub;

	@FindBy(css = "div[class='mobile-wi1 flig-show1'] div:nth-child(3) div:nth-child(2) div:nth-child(1) div:nth-child(1) input:nth-child(1)")
	protected WebElement infantssub;

	@FindBy(css = "body > div:nth-child(17) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > input:nth-child(1)")
	protected WebElement childrensub;

	@FindBy(css = "body > div:nth-child(17) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > input:nth-child(1)")
	protected WebElement childrenadd;

	@FindBy(css = "div[id='myDropdown_n'] a[class='dn_btn']")
	protected WebElement doneButton;

	@FindBy(css = "input[onclick='SearchFlightWithArmy();']")
	protected WebElement searchButton;

	@FindBy(id = "DivOut1")
	protected WebElement fromFlightSelection;

	@FindBy(id = "DivIN1")
	protected WebElement toFlightSelection;

	@FindBy(xpath = "//span[normalize-space()='AI-541']")
	protected WebElement fromFlightId;

	@FindBy(xpath = "//span[normalize-space()='AI-542']")
	protected WebElement toFlightId;

	@FindBy(css = "div[class='row hidden-xs'] div:nth-child(1) div:nth-child(1) div:nth-child(5) p:nth-child(1) span:nth-child(2)")
	protected WebElement fromFlightPrice;

	@FindBy(css = "div:nth-child(2) div:nth-child(1) div:nth-child(5) p:nth-child(1) span:nth-child(2)")
	protected WebElement toFlightPrice;

	@FindBy(css = "p[class='stk_btm_price '] span[class='ng-binding']")
	protected WebElement flightTotalPrice;

	@FindBy(css = "#BtnBookNow")
	protected WebElement bookNowBtn;

	@FindBy(css = "a[ng-click='SelectedFlight_LRT(bookNow)']")
	protected WebElement continueBtn;

	@FindBy(css = ".bg-head")
	protected WebElement medicalRefundDiv;

	@FindBy(css = "input[ng-click='FeemedicalPolicy(true)']")
	protected WebElement medicalRefundCheckBox;

	@FindBy(className = "pr-l")
	protected WebElement medicalRefundText;

	@FindBy(id = "chkInsurance")
	protected WebElement insurance;

	@FindBy(id = "txtEmailId")
	protected WebElement emailInput;

	@FindBy(xpath = "//span[@id='spnVerifyEmail']")
	protected WebElement continueBookingBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter a valid email Id']")
	protected WebElement emailErrorMsg;

}
