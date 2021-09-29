package easyMyTrip;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {

	Properties props = new Properties();
	WebDriver driver;

	public void intilizeDriver(String browser) throws IOException{
		switch (browser.toUpperCase()) {
		case "GOOGLE":
			System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "EDGE":
			System.setProperty("webdriver.edge.driver", "src//test//resources//msedgedriver.exe");
			driver = new EdgeDriver();
			break;
		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		FileReader reader=new FileReader("src//test//resources//config.properties");
		props.load(reader);
	}

}
