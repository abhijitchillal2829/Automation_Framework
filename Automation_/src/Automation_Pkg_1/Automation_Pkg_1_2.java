package Automation_Pkg_1;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Automation_Pkg_1_2 {
	

	   public static void main(String[] args) throws InterruptedException, IOException {

		           WebDriver driver = new ChromeDriver();      
		           driver.get("https://www.aegonlife.com/");
		           driver.manage().window().maximize();
		           Thread.sleep(1000);
		           //2nd page
		           driver.findElement(By.xpath("//div[@class='header-tabs__title'][normalize-space()='Plans']")).click();
		           driver.findElement(By.xpath("//span[normalize-space()='ULIP']")).click();
		           Thread.sleep(1000);
		           driver.findElement(By.xpath("//p[normalize-space()='iInvest']")).click();
		           // Step 3: Wait for page to load
		           Thread.sleep(3000);
		           WebElement buyNowButton = driver.findElement(By.xpath("//span[normalize-space()='Buy now']"));
		           // Step 4: Click on Buy now
		           buyNowButton.click();
		           Thread.sleep(2000);
		           //3rd Page
		           driver.findElement(By.id("username")).sendKeys("Pranali Narhari More");
		           WebElement DOB = driver.findElement(By.xpath("//input[@name='dob']"));
		            DOB.sendKeys("28-12-1995"); 
		            Thread.sleep(2000);
		           driver.findElement(By.xpath("//a[@class='ui-state-default ui-state-active ui-state-hover']")).click();
		           Thread.sleep(4000);
		           driver.findElement(By.xpath(
		               "/html/body/aegon-app/aegon-iinvest/div/ng-component/section/form/div[1]/div/div[2]/div[2]/div[1]/strong/span/span[1]/span/span[2]"))
		               .click();
		           Thread.sleep(2000);
		           driver.findElement(By.xpath("(//*[text()=' Salaried '])[2]")).click();
		           Thread.sleep(5000);
		           driver.findElement(By.xpath("//input[@id='monthlyInvestment']")).click();
		           Thread.sleep(2000);
		           WebElement investment = driver.findElement(By.xpath("//input[@id='monthlyInvestment']"));
		           investment.click();
		           investment.sendKeys("5,000");
		           Thread.sleep(2000);
		           WebElement income = driver.findElement(By.xpath("//input[@id='income']"));
		           income.click();
		           income.sendKeys("1,00,000");
		           Thread.sleep(2000);
		           WebElement city = driver.findElement(By.id("city"));
		           city.click();
		           city.sendKeys("mu");
		           Thread.sleep(2000);
		           java.util.List<WebElement> city_1 = driver.findElements(By.xpath("//ul[contains(@id,\"ui-id-1\")]//li"));
		           city_1.get(0).click();
		           Thread.sleep(2000);
		           driver.findElement(By.xpath("//input[@id='contact']")).sendKeys("8007981495");
		           Thread.sleep(2000);
		           driver.findElement(By.xpath("//input[@id='email']")).sendKeys("pranalimore724@gmail.com");
		           Thread.sleep(2000);
		           driver.findElement(By.xpath("//input[@id='2600_PanNumber']")).sendKeys("ABCTY1234D");
		           Thread.sleep(1000);
		           driver.findElement(By.xpath("//*[text()='Invest Now']")).click();
		           Thread.sleep(2000);
		           driver.findElement(By.xpath(
		                   "/html/body/aegon-app/aegon-iinvest/div/aegon-iinvest-benefits/section/form/div[1]/div[2]/div[3]/span/span[1]/span/span[2]"))
		                   .click();
		            Thread.sleep(3000);
		           driver.findElement(By.xpath("/html/body/span/span/span[2]/ul/li[1]")).click();
		           Thread.sleep(2000);
		           driver.findElement(By.xpath("//*[text()='Get Fund Value']")).click();
		           Thread.sleep(3000);
		            driver.findElement(By.xpath("//*[text()='Continue to Buy']")).click();
		           Thread.sleep(6000);
}
}
