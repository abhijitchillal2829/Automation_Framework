package Task_M;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Task_M_1 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.icicilombard.com/");
		WebElement ele = driver.findElement(By.xpath("(//ul[@class=\"menu-list\"]//a)[1]"));
		Actions Act = new Actions(driver);
		Act.moveToElement(ele).build().perform();

	}

}
