package Automation_Pkg_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import graphql.Assert;

public class Automation_AddTOCart {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement All = driver.findElement(By.id("searchDropdownBox"));
		driver.findElement(By.xpath("//option[text()=\"Books\"]")).click();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Amish Tripathi", Keys.ENTER);
		List<WebElement> Amish_Books = driver.findElements(By.xpath(
				"//div[@class=\"a-section\"]//child::span[@class=\"a-size-medium a-color-base a-text-normal\"]"));
		for(int j=0;j<Amish_Books.size();j++) {
			System.out.println(Amish_Books.get(j).getText());
			if(Amish_Books.get(j).getText().equals("War of Lanka (Ram Chandra Series Book 4)")) {
				Amish_Books.get(j).click();
				break;
			}
		}
		
//		driver.quit();

	}

}
