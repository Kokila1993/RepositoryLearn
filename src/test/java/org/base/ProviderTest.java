package org.base;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProviderTest extends BaseClassAll{
	
	@DataProvider(name = "Login Details")
	public static Object [] [] getData(){
		return new Object[] [] {
			{"koki.nataraj@gmail.com","2345tg"},
			{"kokilabit@gmail.com","09876rtyghb"},
			{"koki.kanaka@gmail.com","2345678"},
			{readExcelData(0, 0),readExcelData(0, 1)},
			{readExcelData(1, 0),readExcelData(1, 1)}
			
		};
	}
		
		@Test(dataProvider = "Login Details")
		private static void tc01(String user, String Pass) {
			System.out.println(Thread.currentThread().getId() +"\t" + user +"\t"+ Pass);
		}
		
	}
