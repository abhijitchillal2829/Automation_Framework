package Alert;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Accept_alert {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("alertButton")).click();
		driver.switchTo().alert().accept();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(7000);
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		Thread.sleep(4000);
		
		driver.findElement(By.id("confirmButton")).click();
		driver.switchTo().alert().dismiss();
		
		Thread.sleep(4000);
		
		driver.findElement(By.id("promtButton")).click();
		driver.switchTo().alert().sendKeys("Hello world");
		driver.switchTo().alert().accept();
		
		driver.quit();
		
		
		
		
	}
}
