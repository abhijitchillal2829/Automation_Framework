package Radio_Check_Image;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Radio_Click {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/elements");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		WebElement Ele = driver.findElement(By.xpath("//span[text()=\"Radio Button\"]"));
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("argument[0].scrollIntoView();", Ele);
//		Thread.sleep(1000);
		Ele.click();
		Thread.sleep(2000);
		List<WebElement> Radio_Buttons = driver
				.findElements(By.xpath("//div[@class=\"mb-3\"]//parent::div//child::label"));
		Radio_Buttons.get(0).click();

		Thread.sleep(2000);
		driver.quit();

	}

}
