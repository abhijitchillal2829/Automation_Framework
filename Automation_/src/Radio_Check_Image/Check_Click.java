package Radio_Check_Image;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Check_Click {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement Ele = driver.findElement(By.xpath("//span[text()=\"Radio Button\"]"));
		Ele.click();
		driver.findElement(By.xpath("//span[text()=\"Check Box\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@type=\"button\"])[4]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=\"Desktop\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()=\"Documents\"]")).click();

		Thread.sleep(2000);
		driver.quit();

	}

}
