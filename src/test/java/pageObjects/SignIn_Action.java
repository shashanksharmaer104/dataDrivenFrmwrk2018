package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utility.ExcelUtils;

public class SignIn_Action {

	public static void Execute(WebDriver driver) throws Exception {
		
		String username = ExcelUtils.getCellData(1, 1);
		String password = ExcelUtils.getCellData(1, 2);
		
		driver.findElement(By.id("j_username")).sendKeys(username);
		driver.findElement(By.xpath("j_password")).sendKeys(password);
		driver.findElement(By.xpath("proceed")).click();
	}
	
}
