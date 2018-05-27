package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.SignIn_Action;

public class DataProviderTest {
	
	private static WebDriver driver = null;
	
	@DataProvider(name="Authentication")
	public static Object[][] credentials() {
		Object[][] obj = new Object[][] {{"test1","password1"},{"test2","password2"}};
		System.out.println(obj);
		return obj;
	}

	@BeforeMethod
	public void initialize() {		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shashank Sharma\\workspace\\"
				+ "dataDrivenFrmwrk2018\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	
	@Test(dataProvider="Authentication", testName="Test Authentication")
	public void test(String user, String pass) {		
		try {
			//SignIn_Action.Execute(driver);
			
			WebElement userEl = driver.findElement(By.id("email"));
			userEl.sendKeys(user);
			WebElement passEl = driver.findElement(By.id("pass"));
			passEl.sendKeys(pass);
			//driver.findElement(By.xpath("//input[@value='Log In']")).click();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void kill() {
		driver.quit();		
	}
}
