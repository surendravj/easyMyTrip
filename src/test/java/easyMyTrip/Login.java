package easyMyTrip;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class Login extends Base {

	@FindBy(name = "q")
	private WebElement googleInputBox;

	Login() throws IOException {
		intilizeDriver("google");
		PageFactory.initElements(driver, this);
	}

	@Test
	public void test() throws InterruptedException {
		driver.get(props.getProperty("url"));
		googleInputBox.sendKeys("Surendra");
		googleInputBox.sendKeys(Keys.ENTER);
	}

	@AfterClass
	public void afterclass() {
		driver.quit();
	}

}
