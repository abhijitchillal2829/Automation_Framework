package Automation_Pkg_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Aegonlife_Automation {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.aegonlife.com/");
		WebElement Plans = driver.findElement(By.xpath("(//div[text()=\"Plans\"])[1]")); // plans
		Actions Act = new Actions(driver);
		Act.moveToElement(Plans).build().perform();
		WebElement ULIP = driver.findElement(By.xpath("//span[text()=\"ULIP\"]"));
		Act.moveToElement(ULIP).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//ul[@class=\"inner-dropdown-content\"])[3]//child::p[text()=\"iInvest\"]"))
				.click();
		System.out.println("hello");
		Act.moveByOffset(0, 0);
		try {
			driver.findElement(By.xpath("(//button[@class=\"agn-primary-button\"])[8]")).click();
		} catch (Exception E) {
		}
		System.out.println("Hello");
		Thread.sleep(3000);

		// page--2
	   WebElement Full_N = driver.findElement(By.id("username"));
	   Full_N.click();
	   Full_N.sendKeys("Abhijit Chillal");
	   Thread.sleep(2000);
	   boolean Male = driver.findElement(By.xpath("//label[@class=\"gender male active\"]")).isSelected();
	   if(Male==true) {
		   System.out.println("Selected");
	   }else {
		   
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   driver.quit();

	}

}
