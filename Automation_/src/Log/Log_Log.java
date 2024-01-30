package Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Log_Log  {

	static Logger logger = Logger.getLogger("Log_Log");
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
		PropertyConfigurator.configure("/home/apmosys/eclipse-workspace/Automation_/src/Automation_Pkg_1/Log4J.properties");
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to("https://www.google.com/");
		logger.info("App open");
		WebElement google = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
		google.sendKeys("quizizz");
		google.sendKeys(Keys.ENTER);
		logger.info("Enter Url");
		driver.findElement(By.xpath("//h3[normalize-space()='Quizizz - Free Online Quizzes']")).click();
		logger.info("Click on ele");

		driver.findElement(By.xpath("//a[@class='button-12 w-button']")).click();
		driver.findElement(By.xpath(
				"//button[@data-cy='continue-with-phone']//div[@class='flex items-center justify-between w-full md:justify-start']"))
				.click();
		driver.findElement(By.xpath("//input[@name='Enter phone number']")).sendKeys("8856805966");
		driver.findElement(By.xpath("//input[@name='Password']")).sendKeys("Abhijit@123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		driver.findElement(By.xpath("(//span[@class=\"title\"])[3]")).click(); // Enter code
		logger.info("click on enter code");

		Set<String> Windowid = driver.getWindowHandles();
		ArrayList<String> al = new ArrayList(Windowid);
		String Window_2 = al.get(1);
		driver.switchTo().window(Window_2);
		logger.info("Switch to second window");

		File f = new File("/home/apmosys/Downloads/Assessment_Link.xlsx");
		FileInputStream fin = new FileInputStream(f);
		XSSFWorkbook wb = new XSSFWorkbook(fin);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		String code = sheet.getRow(0).getCell(1).toString();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='check-room-input']")).sendKeys(code.substring(0, 6), Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='toggle-button text-unselectable on']")).click();


	}

}
