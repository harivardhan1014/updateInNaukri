import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class Sample2 {

	@Test
	public void load()
	{
		System.setProperty("webdriver.chrome.driver","D:\\hari vardhan\\jars\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
	}
}
