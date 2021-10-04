package easyMyTripPom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import easyMyTrip.Base;
public class SamplePom extends Base{

	@FindBy(css = "div[class='emt_header_full'] li:nth-child(1)")
	protected WebElement flights;
	
	@FindBy(css = ".border-lft.flig-show.click-one")
	protected WebElement oneway;
	
	@FindBy(id = "FromSector_show")
	protected WebElement from;
	
	@FindBy(css = "div[class='tp-cit'] ul")
	protected List<WebElement> l3;
	
	@FindBy(css = "#ui-id-16")
	protected WebElement fromCity;
	
	@FindBy(id = "Editbox13_show")
	protected WebElement to;
	
	@FindBy(css = "div[id='toautoFill'] ul")  
	protected List<WebElement> l4;
	
	@FindBy(css = "div[id='toautoFill'] div[class='rcnt'] div[class='tp-cit'] ul li[onchange='ChangeCabin();'] div span[id='spn3']")
	protected WebElement toCity;
	
	@FindBy(css = "#ddate")
	protected WebElement startdate;
	
	@FindBy(id = "snd_3_06/10/2021")
	protected WebElement startdateClick;
	
	@FindBy(css = "div[class='mobile-wi1 flig-show1'] a[class='dropbtn_n']")
	protected WebElement travellerDropdown;
	
	@FindBy(css = "body > div:nth-child(17) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label:nth-child(6)")
	protected WebElement premEconomy;

	@FindBy(css = "body > div:nth-child(17) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label:nth-child(5)")
	protected WebElement economy;

	@FindBy(css = "body > div:nth-child(17) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > label:nth-child(7) > span:nth-child(2)")
	protected WebElement business;
	
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

	@FindBy(css = "#divMoreFare0")
	protected WebElement morefare;
	
	@FindBy(css = "body form[id='FrmEmtMdl'] div[id='ServiceControllerId'] div[class='container'] div[id='divFltMain'] div[class='col-md-10 col-sm-12 new-padd-0 no-padd-rt pad-lft0'] div[id='ResultDiv'] div[class='col-md-12 col-sm-12 no-padd'] div div[data-infinite-scroll='loadMoreOutBound()'] div[class='row no-margn fltResult ng-scope'] div[class='col-md-12 col-sm-12 main-bo-lis pad-top-bot ng-scope'] div[id='frOption0'] div:nth-child(1) label:nth-child(1) div:nth-child(2) div:nth-child(2) span:nth-child(1)")
	protected WebElement saverfare;
	
	@FindBy(css = "body form[id='FrmEmtMdl'] div[id='ServiceControllerId'] div[class='container'] div[id='divFltMain'] div[class='col-md-10 col-sm-12 new-padd-0 no-padd-rt pad-lft0'] div[id='ResultDiv'] div[class='col-md-12 col-sm-12 no-padd'] div div[data-infinite-scroll='loadMoreOutBound()'] div[class='row no-margn fltResult ng-scope'] div[class='col-md-12 col-sm-12 main-bo-lis pad-top-bot ng-scope'] div[id='frOption0'] div:nth-child(2) label:nth-child(1) div:nth-child(2) div:nth-child(2) span:nth-child(1)")
	protected WebElement Flexiplusfare;
	
	@FindBy(css = "body > form:nth-child(4) > div:nth-child(25) > div:nth-child(5) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(6) > button:nth-child(2)")
	protected WebElement booknow;
	
	@FindBy(css = "div[class='bor mar20'] div[class='insur-yes'] label[class='container-radio']")
	protected WebElement yesrefund;
	
	@FindBy(css = "div[class='bor mar20'] div[class='insur-no'] label[class='container-radio']")
	protected WebElement norefund;
	
	@FindBy(css = "div[id='divInsuranceTab'] div[class='insur-yes'] label[class='container-radio']")
	protected WebElement yesinsurance;
	
	@FindBy(css = "div[id='divInsuranceTab'] div[class='insur-no'] label[class='container-radio']")
	protected WebElement noinsurance;
	
	@FindBy(css = "div[class='success_ins_msg']")
	protected WebElement yesinsurancemsg;
	
	@FindBy(css = "#divWinText1")
	protected WebElement warningmsg;
	
	@FindBy(id = "txtEmailId")
	protected WebElement emailInput;

	@FindBy(xpath = "//span[@id='spnVerifyEmail']")
	protected WebElement continueBookingBtn;
	
	@FindBy(xpath = "//span[normalize-space()='Please enter a valid email Id']")
	protected WebElement emailErrorMsg;
	
	@FindBy(css = ".bg_si_d.ng-scope")
	protected WebElement infomsg;
	
	@FindBy(css = "label[id='mycheckbox'] span[class='cmark_cbox']")
	protected WebElement adultcheckbox;
	
	@FindBy(xpath = "//*[@id=\"titleAdult0\"]")
	protected WebElement adultTitle;
	
	@FindBy(css = "option[value='Mr']")
	protected WebElement titleMr;
	
	@FindBy(css = "option[value='Ms']")
	protected WebElement titleMs;
	
	@FindBy(css = "option[value='Mrs']")
	protected WebElement titleMrs;
	
	@FindBy(css = "#txtFNAdult0")
	protected WebElement adultFirtsName;
	
	@FindBy(css = "#txtLNAdult0")
	protected WebElement adultLastName;
	
	@FindBy(css = "#divFlyerPlusAdult0")
	protected WebElement frequentflyer;
	
	@FindBy(css = "#txtFFAdult0")
	protected WebElement frequentflyernumber;
	
	@FindBy(css = "#txtFFAirAdult0")
	protected WebElement airlines;
	
	@FindBy(css = "#txtFFMealAdult0")
	protected WebElement mealpreference;
	
	@FindBy(css = "option[value='Hindu ( Non Vegetarian) Meal']")
	protected WebElement nonveg;
	
	@FindBy(css = "#txtCPhone")
	protected WebElement phonenumber;
	
	@FindBy(css = "div[class='hv-ps8'] span[class='cmark_cbox']")
	protected WebElement checkboxTandC;
	
	@FindBy(css = "#spnRdoFESTIVESALE")
	protected WebElement couponcode;
	
	@FindBy(css= ".cancl")
	protected WebElement removecouponcode;
	
	@FindBy(css = "div[class='pr-r1_Rs'] span[class='ng-binding']")
	protected WebElement grandtotalprice;
	
	@FindBy(css = "div[id='divContinueTransactionSCD'] span[class='co']")
	protected WebElement contBooking;
}