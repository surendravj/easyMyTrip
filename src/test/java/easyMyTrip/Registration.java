package easyMyTrip;



import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Registration extends Base 
{
	Registration() throws IOException {
		intilizeDriver("google");
		PageFactory.initElements(driver, this);
	//	System.out.println("Registration");
	}


	@FindBy(className = "sub_header_link3")
	private WebElement accountRegistration;
	
	@FindBy(id = "shwlogn")
	private WebElement signinButton;
	
	@FindBy(id = "txtEmail")
	private WebElement username;
	
	@FindBy(name = "btn_Login")
	private WebElement continueButton;
	
	@FindBy(id = "txtEmail1")
	private WebElement otpsent;
	
	@FindBy(id = "otpRsnd")
	private WebElement otpResend;
	
	@FindBy(id = "OtpLgnBtn")
	private WebElement createMyAccountButton;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		intilizeDriver("google");
		driver.manage().window().maximize();
	}
	
	@Test
	public void test1() throws Exception {
		driver.get(props.getProperty("url"));
		//accountRegistration.click();
		driver.findElement(By.className("sub_header_link3")).click();
	Thread.sleep(1000);
		driver.findElement(By.className("btn_loginnew")).click();
		//username.sendKeys("9502206239");
		Thread.sleep(2000);
		driver.findElement(By.id("txtEmail")).sendKeys("9182539026");
		//continueButton.click();
		Thread.sleep(2000);
		driver.findElement(By.name("btn_Login")).click();
		Thread.sleep(2000);
		try (Scanner sc = new Scanner(System.in)) {
			String otp = sc.next();
			driver.findElement(By.id("txtEmail1")).sendKeys(otp);
	//		otp1.sendKeys(otp);
		}
		Thread.sleep(1000);
		driver.findElement(By.id("OtpLgnBtn")).click();
		System.out.println("account created");
	}
	
//	@Test
	public void test2() throws Exception {
		driver.get(props.getProperty("url"));
		driver.findElement(By.className("sub_header_link3")).click();
		Thread.sleep(1000);
			driver.findElement(By.className("btn_loginnew")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtEmail")).sendKeys("918253926");
			WebElement invalidno = driver.findElement(By.xpath("//div[@class='login']//div[@class='i-eml'][normalize-space()='* Enter a valid Phone Number']"));
			assertEquals(invalidno.getText(), "");
	}
	
	//@Test 
	public void test3() throws Exception {
		driver.get(props.getProperty("url"));
		driver.findElement(By.className("sub_header_link3")).click();
		Thread.sleep(1000);
			driver.findElement(By.className("btn_loginnew")).click();
			Thread.sleep(2000);
			driver.findElement(By.id("txtEmail")).sendKeys("9182539026");
			Thread.sleep(2000);
			driver.findElement(By.name("btn_Login")).click();
			Thread.sleep(2000);
			//try (Scanner sc = new Scanner(System.in)) {
			//	String otp = sc.next();
			//	driver.findElement(By.id("txtEmail1")).sendKeys(otp);
		//		otp1.sendKeys(otp);
		//	}
			WebElement invalidotp = driver.findElement(By.id("ValidOtp"));
			assertEquals(invalidotp.getText(),"");
			Thread.sleep(1000);
		driver.findElement(By.id("otpRsnd")).click();
			try (Scanner sc = new Scanner(System.in)) {
				String otp1 = sc.next();
				driver.findElement(By.id("txtEmail1")).sendKeys(otp1);
				otpsent.sendKeys(otp1);
			}
			driver.findElement(By.id("OtpLgnBtn")).click();
			System.out.println("account created");
			
	}
	
	@AfterClass
	public void afterclass()
	{
		driver.quit();
	}
}
