package Automation_Pkg_1;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_1 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://ishine.apmosys.com/#/login");
		WebElement Username = driver.findElement(By.id("username"));
		Username.click();
		Username.sendKeys("abhijit.chillal@apmosys.com");
		WebElement Password = driver.findElement(By.id("userPassword"));
		Password.click();
		Password.sendKeys("Abhijit@123");
		driver.findElement(By.xpath("//button[text()=\"SIGN IN\"]")).click();

		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://mail.apmosys.com/webmail/");
		WebElement Email = driver.findElement(By.xpath("//input[@type=\"email\"]"));
		Email.click();
		Email.sendKeys("abhijit.chillal@apmosys.com");
		driver.findElement(By.xpath("//button[@name=\"next\"]")).click();
		WebElement Password_Mail = driver.findElement(By.xpath("//input[@name=\"password\"]"));
		Password_Mail.click();
		Password_Mail.sendKeys("vun&7Tgpt");
		driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
		driver.findElement(By.id("gui.frm_main.filter#loader")).click();
		driver.switchTo().frame("gui.frm_main.main.mailview#frame");
		System.out.println("Hello");
		String Otp = driver.findElement(By.xpath("//div[@style=\"height: 0px;\"]/p")).getText();
		System.out.println(Otp);
		String otp = Otp.replaceAll("[^0-9]", "");
		System.out.println(otp);

		Set<String> WindowID = driver.getWindowHandles();
		ArrayList<String> Ar = new ArrayList(WindowID);
		String Window_1 = Ar.get(0);
		String Window_2 = Ar.get(1);

		driver.switchTo().window(Window_1);

		WebElement ishine_otp = driver.findElement(By.id("userOtp"));
		ishine_otp.click();
		ishine_otp.sendKeys(otp);
		driver.findElement(By.xpath("//button[text()=\"Confirm\"]")).click();

		WebElement User_Name = driver.findElement(By.id("user-dropdown"));
		System.out.println(User_Name.getText());
		User_Name.click();
		driver.findElement(By.xpath("//div[@class=\"dropdown-menu dropdown-menu-right show\"]/a[2]")).click();

		driver.switchTo().window(Window_2);
		driver.findElement(By.id("gui.frm_main.stat/0")).click();
		driver.findElement(By.id("gui.frm_main.stat/0/12")).click();

		Thread.sleep(4000);

		driver.quit();

	}

}
