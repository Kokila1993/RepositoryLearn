package org.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class AnnotateTest{
	
	public static WebDriver driver;
	
	@Test(dataProvider="Login Details", dataProviderClass = ProviderTest.class)
	
	public static void tco1(String textuser, String textpass) {
		try {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			System.out.println("Browser Launched Successfully");
			
		} catch (Exception e) {
			System.out.println("Browser Launch Getting Failed");
		}
		
		try {
			driver.get("http://www.facebook.com/");
			System.out.println("URL Launched Successfully");
		
		} catch (Exception e) {
			System.out.println("URL Launch Getting Failed");
			
		}
		try {
			WebElement username = driver.findElement(By.id("email"));
			username.sendKeys(textuser);
			System.out.println("UserName Entered Successfully");
//			WebElement password = driver.findElement(By.id("pass"));
//			password.sendKeys(textpass);
//			System.out.println("Password Entered Successfully");
			
		} catch (Exception e) {
			System.out.println("UserName not Entered Successfully");
		}
		try {
			WebElement password = driver.findElement(By.id("pass"));
			password.sendKeys(textpass);
			System.out.println("Password Entered Successfully");
			
		} catch (Exception e) {
			System.out.println("Password not Entered Successfully");
		}
		try {
			WebElement button = driver.findElement(By.name("login"));
			button.click();
			System.out.println("Button Clicked Successfully");
			
		} catch (Exception e) {
			System.out.println("Button not Clicked Successfully");			
		}
			
	}

}
