package Automation_Pkg_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task_2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.foundit.in/");
		driver.findElement(By.xpath("//div[@class=\"heroSection-buttonContainer_primaryBtn__text\"]")).click();

		// Basic Details----
		WebElement Full_name = driver.findElement(By.id("fullName"));
		Full_name.click();
		Full_name.sendKeys("Abhijit Chillal");

		WebElement Email = driver.findElement(By.id("emailId"));
		Email.click();
		Email.sendKeys("chilla28@gmail.com");

		WebElement Pass = driver.findElement(By.id("password"));
		Pass.click();
		Pass.sendKeys("Abhijit@123");

		WebElement Mobile_num = driver.findElement(By.id("mobileNumber"));
		Mobile_num.click();
		Mobile_num.sendKeys("8856805966");

		driver.findElement(By.id("option-0")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[text()=\"Claim Number\"]")).click(); // capcha & otp

		Thread.sleep(20000);

		driver.findElement(By.id("continue-btn")).click(); // countinue----capcha

		Thread.sleep(10000);

		// Job Preferences-----
		driver.findElement(By.id("jobPreferenceDetailsSkills")).sendKeys("Automation Testing", Keys.ENTER);
		Thread.sleep(3000);
		driver.findElement(By.id("jobPreferenceDetailsIndustries")).click();
		List<WebElement> Industry = driver.findElements(By.xpath("//ul[@class=\"suggestionList bottom100\"]//li"));
		for (int i = 0; i < Industry.size(); i++) {
			if (Industry.get(i).getText().equals("IT/Computers - Software")) {
				Industry.get(i).click();
				break;
			}
		}
		System.out.println("Hello_1");

		driver.findElement(By.id("jobPreferenceDetailsFunctions")).click();
		List<WebElement> Dept = driver.findElements(By.id("//ul[@class=\"suggestionList bottom100\"]//li"));
		for (int j = 0; j < Dept.size(); j++) {
			if (Dept.get(j).getText().equals("IT")) {
				Dept.get(j).click();
				break;
			}
		}
		System.out.println("Hello_2");

		driver.findElement(By.id("jobPreferenceDetailsRoles")).click();
		List<WebElement> Preferred_Role = driver.findElements(By.xpath("//ul[@class=\"suggestionList top100\"]//li"));
		Preferred_Role.get(0).click();
		System.out.println("Hello_3");

		WebElement Preferred_Location = driver.findElement(By.id("jobPreferenceDetailsRoles"));
		Preferred_Location.click();
		Preferred_Location.sendKeys("Mumbai", Keys.ENTER);
		System.out.println("Hello_4");

		driver.findElement(By.id("continue-btn")).click(); // countinue

	}

}
