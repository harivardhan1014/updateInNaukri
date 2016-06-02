package com.naukri;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class NewClass2 {

	@Test
	public void IEDriverExample()
	{
		System.setProperty("webdriver.ie.driver", "D://hari vardhan//jars//IEDriverServer.exe");
		WebDriver driver=new InternetExplorerDriver();
		driver.get("http://www.facebook.com");
	}
}