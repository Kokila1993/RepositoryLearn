package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassAll {
	public static WebDriver driver;
	public static WebElement element;

	// ************************** To Select WebDriver ****************************

	public static void initDriver(String browser) {

		switch (browser) {
		case "Chrome":

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			break;

		case "Edge":

			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.manage().window().maximize();

			break;

		case "Firefox":

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

			break;

		case "InternetExplorer ":

			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();

			break;
		default:
			System.out.println("None of the above Browser");
			break;
		}
	}

	// ***************************** To Launch URL *********************************

	public static void getUrl(String url) {
		driver.get(url);
	}

	// ****************************** To use SendKeys Function *******************************
	public static void getByXpath(String xpath, String text) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		findElement.sendKeys(text);

	}
	// ******************************* To use Click Function **********************************

	public static void getClickByXpath(String xpath, String text) {
		WebElement findElement = driver.findElement(By.xpath(xpath));
		findElement.click();

	}

	// ******************************* To use SendKeys Function ******************************
	
	public static void getById(String id, String text) {
		
		WebElement findElement = driver.findElement(By.id(id));
		findElement.sendKeys(text);
	}

	// ****************************** To use SendKeys Function *******************************
	
	public static void getByName(String name, String text) {
		WebElement findElement = driver.findElement(By.name(name));
		findElement.sendKeys(text);
	}
	
	// ***************************** To Read Data from Excel *********************************

	public static String readExcelData(int rownum, int cellnum) {

		String value = null;

		try {

			File file = new File("D:\\Koki Excel\\Adactin.xlsx");
			FileInputStream stream = new FileInputStream(file);
			Workbook book = new XSSFWorkbook(stream);
			Sheet sheet = book.getSheet("DemoSite");
			Row row = sheet.getRow(rownum);
			Cell cell = row.getCell(cellnum);
			CellType cellType = cell.getCellType();

			switch (cellType) {
			case STRING:
				value = cell.getStringCellValue();
				break;

			default:
				if (DateUtil.isCellDateFormatted(cell)) {

					Date dateCellValue = cell.getDateCellValue();
					SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
					value = s.format(dateCellValue);

				} else {
					double numericCellValue = cell.getNumericCellValue();
					long l = (long) numericCellValue;
					BigDecimal valueOf = BigDecimal.valueOf(l);
					value = valueOf.toString();
				}

				break;
			}
		} catch (Exception e) {
		}
		return value;
	}
	
	// ********************************* Select Using Index ************************************

	public static void selectIndex(WebElement element, int value) {

		new Select(element).selectByIndex(value);
		List<WebElement> options = new Select(element).getOptions();
	}

	// ****************************** Select using VisibleText **********************************

	public static void selectVisibleText(WebElement element, String value) {

		try {

			new Select(element).selectByVisibleText(value);
			List<WebElement> options = new Select(element).getOptions();

		} catch (Exception e) {
		}
	}

	// ********************************* Select using Value **********************************

	public static void selectValue(WebElement element, String value) {
		try {

			new Select(element).selectByValue(value);
			List<WebElement> options = new Select(element).getOptions();

		} catch (Exception e) {
		}
	}

	// ************************************* To Take ScreenShot *******************************

	public static void shot(String name) {
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File Source = ts.getScreenshotAs(OutputType.FILE);
			File Target = new File("C:\\Users\\kokpa\\OneDrive\\Desktop\\Record\\NewSite\\" + name + ".jpeg");
			FileUtils.copyFile(Source, Target);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// *******************************To Set value Using JavaScript *******************************

	public static void textSendJS(String text, WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
			//

		} catch (Exception e) {
		}
	}
	
	// *******************************To Get Set value Using JavaScript *******************************

	public static Object getTextJS(WebElement element) {
				
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Object executeScript = js.executeScript("return arguments[0].getAttribute('value')", element);
			return executeScript;
	}

	// ********************************* Click using JavScript *****************************************

	public static void clickJS(WebElement element) {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", element);

		} catch (Exception e) {
		}
	}

	// ********************************** Scroll function using JavaScript ***************************************

	public static void scrollJava(WebElement element) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			js.executeScript("arguments[0].scrollIntoView(false)", element);
			
		} catch (Exception e) {
		}
	}

	// ************************************** To Perform Mouse Over Action *******************************************

	public static void mouseOverAction(WebElement target) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(target).build().perform();

		} catch (Exception e) {
		}
	}

	// ************************************** To Perform Drag And Drop *******************************************

	public static void dragAndDrop(WebElement source, WebElement target) {
		try {
			Actions act = new Actions(driver);
			act.dragAndDrop(source, target).build().perform();

		} catch (Exception e) {
		}
	}

	// ************************************** To Perform Right Click *******************************************

	public static void rightClick(WebElement target) {
		try {
			Actions act = new Actions(driver);
			act.contextClick(target).build().perform();

		} catch (Exception e) {
		}
	}

	// ************************************** To Perform Double Click *******************************************

	public static void doubleClick(WebElement target) {
		try {
			Actions act = new Actions(driver);
			act.doubleClick(target).build().perform();

		} catch (Exception e) {
		}
	}

}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	