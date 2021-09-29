package easyMyTrip;






import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login extends Base {

	@FindBy(id = "txtEmail")
	private WebElement username;
	
	@FindBy(name = "btn_Login")
	private WebElement continueButton;
	
	@BeforeClass
	public void beforeClass() throws IOException {
		intilizeDriver("google");
		driver.manage().window().maximize();
	}

	@Test
	public void test() {
		driver.get(props.getProperty("url"));
	}
	
	@AfterClass
	public void afterclass()
	{
		driver.quit();
	}

}
