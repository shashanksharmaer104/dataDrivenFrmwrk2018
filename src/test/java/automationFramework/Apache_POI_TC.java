package automationFramework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.frameworks.dataDrivenFrmwrk2018.Constant;

import pageObjects.SignIn_Action;
import utility.ExcelUtils;

public class Apache_POI_TC {

	private static WebDriver driver = null;
	
	public static void main(String[] args) {
		ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Sheet1");
		
		//driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shashank Sharma\\workspace\\"
				+ "AutomationFrameworkProject\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(Constant.URL);
		
		try {
			SignIn_Action.Execute(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
		ExcelUtils.setCellData("Pass", 1, 3);
		
	}
	
}
