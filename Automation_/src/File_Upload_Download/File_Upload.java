package File_Upload_Download;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Upload {
	public static void main(String[] args) throws InterruptedException {
		
         WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
         driver.get("https://demoqa.com/upload-download");
         Thread.sleep(3000);
         driver.findElement(By.id("uploadFile")).sendKeys("/home/apmosys/Desktop/Abhi.txt");
         Thread.sleep(4000);
         driver.quit();
		
		
		
	}

}
