package easyMyTrip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	protected Properties props = new Properties();
	protected WebDriver driver;

	protected XSSFWorkbook workbook;
	protected XSSFSheet sheet;

	public void loadProps() throws IOException {
		FileReader reader = new FileReader("src//test//resources//config.properties");
		props.load(reader);
		File src = new File("src\\test\\resources\\easeMyTripFramework.xlsx");
		FileInputStream fin = new FileInputStream(src);
		workbook = new XSSFWorkbook(fin);
	}
	
	public void setSheet(int index)
	{
		sheet=workbook.getSheetAt(index);
	}

	public String getValue(int row, int col) {
		return sheet.getRow(row).getCell(col).getStringCellValue();
	}

	public void intilizeDriver(String browser) {
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

	}

	@SuppressWarnings("deprecation")
	public void waitForElementPresence(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
	}

	@SuppressWarnings("deprecation")
	public void waitSomeTime() {
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
	}

}
