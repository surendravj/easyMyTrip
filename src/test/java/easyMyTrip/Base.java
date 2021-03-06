package easyMyTrip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

public class Base {

	protected Properties props = new Properties();
	protected WebDriver driver;

	protected XSSFWorkbook workbook;
	protected XSSFSheet sheet;

	public void loadProps() throws IOException {
		FileReader reader = new FileReader("src//test//resources//config.properties");
		props.load(reader);
		File src = new File("src\\test\\resources\\easeMyTripFramework (1).xlsx");
		FileInputStream fin = new FileInputStream(src);
		workbook = new XSSFWorkbook(fin);
	}

	public void setSheet(int index) {
		sheet = workbook.getSheetAt(index);
	}

	public String getValue(int row, int col) {
		DataFormatter dataFormatter = new DataFormatter();
		String value = dataFormatter.formatCellValue(sheet.getRow(row).getCell(col));
		return value;
	}

	public void intilizeDriver(String browser) {
		switch (browser.toUpperCase()) {
		case "GOOGLE":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver.exe");
			driver = new ChromeDriver(options);
			break;

		case "EDGE":
			EdgeOptions optionsEdge = new EdgeOptions();
			optionsEdge.addArguments("--disable-notifications");
			System.setProperty("webdriver.edge.driver", "src//test//resources//msedgedriver.exe");
			driver = new EdgeDriver(optionsEdge);
			break;

		case "FIREFOX":
			FirefoxOptions optionsFirefox = new FirefoxOptions();
			optionsFirefox.addArguments("--disable-notifications");
			System.setProperty("webdriver.gecko.driver", "src//test//resources//geckodriver.exe");
			driver = new FirefoxDriver(optionsFirefox);
			break;
		}

	}

	@SuppressWarnings("deprecation")
	public void waitSomeTime() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
	}

}
