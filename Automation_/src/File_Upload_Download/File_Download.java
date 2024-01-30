package File_Upload_Download;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class File_Download {

	public static void main(String[] args) throws InterruptedException {
		
		  WebDriver driver = new ChromeDriver();
	         driver.manage().window().maximize();
	         driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
	         driver.get("https://demoqa.com/upload-download");
	         driver.findElement(By.id("downloadButton")).click();
	         Thread.sleep(4000);
	         driver.quit();
			

	}

}
