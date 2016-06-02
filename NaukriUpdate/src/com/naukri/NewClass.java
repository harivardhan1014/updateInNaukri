package com.naukri;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewClass {
	
	@Test
	public void fb()
	{
		System.setProperty("webdriver.chrome.driver", "D://hari vardhan//jars//chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.facebook.com");
	}

}
