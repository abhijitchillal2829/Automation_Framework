package Automation_Pkg_1;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Task_EOD {

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
		ishine_otp.sendKeys(otp); // otp
		driver.findElement(By.xpath("//button[text()=\"Confirm\"]")).click(); // submit otp

		// Eod fill task-----
		// 1st 3 hr----------
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//a[@class=\"sidenav-nav-link\"])[4]")).click();
		driver.findElement(By.xpath("//button[text()=\"View My Timesheets\"]")).click(); // timesheet
		Thread.sleep(3000);
		WebElement Start_date = driver.findElement(By.id("timesheetStartDate"));
		Start_date.click();
		Start_date.sendKeys(Keys.ENTER);
		Thread.sleep(2000);

		WebElement End_date = driver.findElement(By.id("timesheetEndDate"));
		End_date.click();
		End_date.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@type=\"submit\"])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=\"Yes, proceed\"]")).click(); // yes proceed
		Thread.sleep(2000);
		driver.findElement(By.id("mat-select-value-13")).click();
		driver.findElement(By.xpath("//span[text()=\" ApMoSys \"]")).click(); // apmosys
		Thread.sleep(2000);
		driver.findElement(By.id("mat-select-value-15")).click();
		driver.findElement(By.xpath("//span[text()=\" Mahape \"]")).click(); // mahape
		Thread.sleep(2000);
		driver.findElement(By.id("mat-select-value-17")).click();
		driver.findElement(By.xpath("//span[text()=\" AUTOMATION INTERNAL | Bench \"]")).click(); // automation intenale
																									// batch
		Thread.sleep(2000);
		WebElement Activity = driver
				.findElement(By.xpath("(//select[@class=\"form-control ng-untouched ng-pristine ng-valid\"])[2]"));
		Select Activity_s = new Select(Activity);
		Activity_s.selectByVisibleText("Training");

		WebElement Description_1 = driver.findElement(By.id("dayTypeDesc"));
		Description_1.click();
		Description_1.sendKeys("Completed training");
		Thread.sleep(5000);

		WebElement Time = driver.findElement(By.xpath("(//input[@step=\"any\"])[2]"));
		Time.click();
		Time.sendKeys("3.00");
		Thread.sleep(4000);

		// 2nd 3hr-----
		driver.findElement(By.xpath("//button[@class=\"btn btn-sm btn-outline-primary mx-1\"]")).click();
		Thread.sleep(2000);
		WebElement Activity_2 = driver
				.findElement(By.xpath("(//select[@class=\"form-control ng-untouched ng-pristine ng-valid\"])[2]"));
		Select Activity_2_s = new Select(Activity_2);
		Activity_2_s.selectByVisibleText("Research and Development work");
		WebElement Description_2 = driver.findElement(By.id("dayTypeDesc"));
		Description_2.click();
		Description_2.sendKeys("Research on apache poi");
		WebElement Time_2 = driver.findElement(By.xpath("(//input[@step=\"any\"])[3]"));
		Time_2.click();
		Time_2.sendKeys("3.00");
		Thread.sleep(2000);

		// 3rd 3hr------
		driver.findElement(By.xpath("(//button[@class=\"btn btn-sm btn-outline-primary mx-1\"])[2]")).click();
		WebElement Activity_3 = driver
				.findElement(By.xpath("(//select[@class=\"form-control ng-untouched ng-pristine ng-valid\"])[2]"));
		Select Activity_3_s = new Select(Activity_3);
		Activity_3_s.selectByVisibleText("Assigned task completion");
		WebElement Description_3 = driver.findElement(By.id("dayTypeDesc"));
		Description_3.click();
		Description_3.sendKeys("Integrate mail with ishine");
		WebElement Time_3 = driver.findElement(By.xpath("(//input[@step=\"any\"])[4]"));
		Time_3.click();
		Time_3.sendKeys("3.00");
		driver.findElement(By.xpath("//button[text()=\"Update Timesheet\"]")).click(); // update timesheet
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()=\"Yes, proceed\"]")).click(); // yes proceed
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()=\"OK\"]")).click();
		Thread.sleep(2000);

		// logout mail & ishine-----
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
