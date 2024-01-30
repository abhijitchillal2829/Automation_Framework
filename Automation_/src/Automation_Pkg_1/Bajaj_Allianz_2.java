package Automation_Pkg_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Bajaj_Allianz_2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.bajajallianzlife.com/");
		Actions Act = new Actions(driver);
		List<WebElement> List = driver.findElements(By.xpath("//ul[@class=\"navlinks\"]/li"));
		for (int i = 0; i < List.size(); i++) {
			System.out.println(List.get(i).getText());
			if (List.get(i).getText().equals("Plans")) {
				WebElement Plans = driver.findElement(By.xpath("//a[text()=\"Plans\"]"));
				Act.moveToElement(Plans).build().perform();
			}
		}
		System.out.println();
		List<WebElement> Plans_list = driver.findElements(By.xpath("//ul[@class=\"inner-subnav subnav-one loadmore\"]/li"));
	   for(int j=0;j<Plans_list.size();j++) {
		   System.out.println(Plans_list.get(j).getText());
		   if(Plans_list.get(j).getText().equals("On Sale Plans")) {
			   WebElement On_Sale_Plans = driver.findElement(By.xpath("//a[contains(text(),\"On Sale Plans\")]"));
			   On_Sale_Plans.click();
			   break;
		   }
	   }
	   
	   JavascriptExecutor Js = (JavascriptExecutor)driver;
	   WebElement Scroll = driver.findElement(By.xpath("//a[contains(text(),\"Bajaj Allianz Life Group N\")]"));
	   Js.executeScript("arguments[0].scrollIntoView();", Scroll);	  
	   
	   
		
		Thread.sleep(7000);
		driver.quit();

	}

}
