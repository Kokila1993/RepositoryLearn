package org.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTesting extends BaseClassAll {
	
	
	@Test
	public static void tc01() {
		
		try {
			
			initDriver("Chrome");
			driver.get("http://www.facebook.com");
			System.out.println("Browser Launched Successfully");
			//Thread.sleep(5000);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Parameters({"user","pass"})
	@Test
	public static void tc02(String textuser, String textpass) {
//	public static void tc02(@Optional("koki.nataraj@gmail.com")String textuser, @Optional("sam@2020")String textpass) {
		
		try {
		
		WebElement userName = driver.findElement(By.id("email"));
		userName.sendKeys(textuser);
		System.out.println("User Name Entered Successfully");
		
		WebElement password = driver.findElement(By.id("pass"));
		password.sendKeys(textpass);
		System.out.println("Password Entered Successfully");
		}catch (Exception e) {
		}
	}
	
}