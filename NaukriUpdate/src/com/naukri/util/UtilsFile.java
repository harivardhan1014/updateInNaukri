package com.naukri.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UtilsFile {
	
	static String uname;
	static String pwd;
	static String path;
	static WebDriver driver=null;
	static String mainWindow;
	static XSSFSheet sheet=null;
	static FileInputStream fis=null;
	static FileOutputStream fos=null;
	static XSSFWorkbook workbook=null;
	static int count=0;
	
	public void openURL(String URL) 
	{
	   
		driver.get(URL);
		
	}
	
	public static void switchWindow() 
	{
		mainWindow=driver.getWindowHandle();
		Set<String> otherWindows=driver.getWindowHandles();
		for(String currentWindow : otherWindows)
		{
			driver.switchTo().window(currentWindow);
			if(!currentWindow.equals(mainWindow))
			{
				
				if(driver.getCurrentUrl().contains("login"))
				{
					driver.switchTo().window(currentWindow);
				}
				else 
				{
				System.out.println(driver.getCurrentUrl());
				driver.close();
				driver.switchTo().window(mainWindow);
				}
			}
			
		}	
		
	}
	
	public int getLastRow(String filePath) throws IOException 
	{
		fis=new FileInputStream(filePath);
		workbook= new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		int i=sheet.getLastRowNum();
		return i;
	}
	
	public void getData(String filePath,int j) throws IOException
	{
		fis=new FileInputStream(filePath);
		workbook= new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		
			uname=sheet.getRow(j).getCell(0).toString();
			pwd=sheet.getRow(j).getCell(1).toString();
			path=sheet.getRow(j).getCell(2).toString();
			
		
	}

	

	

	public void loginAndUpdate() throws IOException
	{
		switchWindow();
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.linkText("Login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		switchWindow();
	
		WebDriverWait waits=new WebDriverWait(driver, 10);
	    waits.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("emailTxt"))));
	    
	driver.findElement(By.id("emailTxt")).sendKeys(uname);
	driver.findElement(By.id("pwd1")).sendKeys(pwd);
    driver.findElement(By.name("Login")).click();
    driver.findElement(By.linkText("View Profile")).click();
    driver.findElement(By.linkText("Upload New Resume")).click();
    driver.findElement(By.id("attachCV")).sendKeys(path);
  
    WebDriverWait wait=new WebDriverWait(driver, 10);
    WebElement msg=driver.findElement(By.id("attachCVMsg"));
    wait.until(ExpectedConditions.textToBePresentInElement(msg,"File uploaded successfully."));
    		
    driver.findElement(By.xpath("//button[@class='w85bt fl']/div/b")).click();
    
    Assert.assertTrue(driver.getPageSource().contains("Your naukri profile has been updated"));
    takeSceeShortPic();
	driver.manage().deleteAllCookies();
		
	}

	public void takeSceeShortPic() throws IOException {
		// TODO Auto-generated method stub
		
		Random rand = new Random();
		count=rand.nextInt(100);
		SimpleDateFormat sdf=new SimpleDateFormat("dd.m.yyyy");
		String date=sdf.format(new Date());
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File( "D:\\hari vardhan\\work space\\naukriupdate\\screens\\"+uname+count+" "+date+".jpg"));
				
	}

	public void updateExcel(int j) throws IOException 
	{
		Date date =new Date();
		sheet.getRow(j).createCell(3).setCellValue("Resume Uploaded Successfully");
		sheet.getRow(j).createCell(4).setCellValue(date.toString());
		fis.close();
		fos=new FileOutputStream("D:\\hari vardhan\\work space\\NaukriUpdate\\test data\\data1.xlsx");
		workbook.write(fos);
		
		fos.close();
	    
	 
		
	}

	public void closeURL() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	public static void openBrowser(String browser) {
		// TODO Auto-generated method stub
		if(browser.matches("FF")) 
		{
		  driver =new FirefoxDriver();
		}
		else if(browser.matches("IE"))
		{
			System.setProperty("webdriver.ie.driver","D:\\hari vardhan\\jars\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		else if(browser.matches("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\hari vardhan\\jars\\chromedriver.exe");
			driver =  new ChromeDriver();
		}
	}

	
}
