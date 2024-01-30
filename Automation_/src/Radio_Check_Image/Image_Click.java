package Radio_Check_Image;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Image_Click {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		driver.get("https://www.google.com/search?gs_ssp=eJzj4tLP1TfIMC5PqygwYPTiS8zNLM5QKCnKLEgsycgEAIFmCZA&q=amish+tripathi&oq=amish+&aqs=chrome.1.69i57j46i433i512j0i433i512l2j0i131i433i512j46i512j0i433i512j0i512j46i340i512.5263j0j15&sourceid=chrome&ie=UTF-8");
		driver.findElement(By.xpath("(//span[@class=\"bmaJhd iJddsb\"])[4]")).click();
		Thread.sleep(2000);
		List<WebElement> Images = driver.findElements(By.xpath("//div[@class=\" bRMDJf islir\"]"));
		Images.get(2).click();
		Thread.sleep(3000);
		driver.quit();

	}

}
