package Action;

import java.awt.Desktop.Action;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Action_Class {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		WebElement Account_List = driver.findElement(By.xpath("//span[text()=\"Account & Lists\"]"));
		Actions Act =  new Actions(driver);
		Act.moveToElement(Account_List).perform();
		
		
		
		
	}

}
