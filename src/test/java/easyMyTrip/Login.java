package easyMyTrip;

import java.io.IOException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends Base {

	Login() throws IOException {
		loadProps();
		intilizeDriver(props.getProperty("browser"));
		PageFactory.initElements(driver, this);
	}

	By my_account = By.cssSelector("div.sub_header_link3");
	By log_in = By.cssSelector("a.btn_loginnew");
	By in_data = By.id("txtEmail");
	By cont = By.cssSelector("input#shwotp");
	By use_pass = By.id("shwlgnbx");
	By pass_word = By.id("txtEmail2");
	By logged_in = By.xpath("//*[@id=\"emailgnBox\"]/div[1]/div[2]/div/div[8]/input");

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(props.getProperty("url"));
	}

	public void fillNumber() {
		driver.findElement(my_account).click();
		driver.findElement(log_in).click();
		driver.findElement(in_data).sendKeys(props.getProperty("mobileNumber2"));
		driver.findElement(cont).click();
	}

	@Test(priority = 1)
	public void test1() throws InterruptedException {
		
		fillNumber();
		driver.findElement(use_pass).click();
		driver.findElement(pass_word).sendKeys(props.getProperty("loginPassword"));
		driver.findElement(logged_in).click();
		System.out.println("Login Successful");
	}

	@Test(priority = 2)
	public void test2() throws InterruptedException {
		driver.navigate().refresh();
		driver.findElement(my_account).click();
		driver.findElement(log_in).click();
		driver.findElement(in_data).sendKeys(props.getProperty("wrongMobileNumber"));
		WebElement invalidno = driver.findElement(By
				.xpath("//div[@class='login']//div[@class='i-eml'][normalize-space()='* Enter a valid Phone Number']"));
		Assert.assertEquals(invalidno.getText(), "");

	}

	@Test(priority = 2)
	public void test3() throws InterruptedException {
		driver.navigate().refresh();
		fillNumber();
		driver.findElement(use_pass).click();
		driver.findElement(pass_word).sendKeys(props.getProperty("wrongLoginPassword"));
		driver.findElement(logged_in).click();
		WebElement invalidpass = driver.findElement(By.xpath("//*[@id=\"ValidPass\"]"));
		Assert.assertEquals(invalidpass.getText(), "");

	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}

}
