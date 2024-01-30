package Automation_Pkg_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Bajaj_Allianz {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		driver.get("https://www.bajajallianzlife.com/");
		WebElement Plans = driver.findElement(By.xpath("//a[text()=\"Plans\"]"));
		Actions Act = new Actions(driver);
		Act.moveToElement(Plans).build().perform();
		Thread.sleep(3000);
		WebElement TLI = driver.findElement(By.xpath("//a[contains(text(),\"Term Insurance Plans\")]"));
		Act.moveToElement(TLI).build().perform();
		Thread.sleep(3000);
		WebElement SPG = driver.findElement(By.xpath("//a[contains(text(),\"Smart Protection Goal\")]"));
		Act.moveToElement(SPG).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),\"Calculate Now\")]")).click();
		driver.findElement(By.id("fullname")).sendKeys("Lankapati Rawan");               //full name
		driver.findElement(By.xpath("//input[@name=\"Date of Birth\"]//parent::div//child::button")).click();   //DOB
		WebElement Year = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
		Year.click();
		Select Dob_Y = new Select(Year);
		Dob_Y.selectByValue("1998");
		WebElement Month = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
		Month.click();
		Select Dob_M = new Select(Month);
		List<WebElement> list_m = Dob_M.getOptions();
		for(int i=0;i<list_m.size();i++) {
			System.out.println(list_m.get(i).getText());
			if(list_m.get(i).getText().equals("SEP")) {
				list_m.get(i).click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()=\"20\"]")).click();
		Thread.sleep(2000);
		String Age_text = driver.findElement(By.id("ageTxt")).getText();
		System.out.println(Age_text);
		Thread.sleep(2000);
		
		WebElement Country_code = driver.findElement(By.xpath("//select[@name=\"ccode\"]"));
		Country_code.click();
		Select Country_c = new Select(Country_code);
		List<WebElement> C_C = Country_c.getOptions();
		for(int j=0;j<C_C.size();j++) {
			System.out.println(C_C.get(j).getText());
			if(C_C.get(j).getText().equals("+91")) {
				C_C.get(j).click();
				break;
			}
		}
		Thread.sleep(2000);
		WebElement Mobile_num = driver.findElement(By.id("selfmobile"));
		Mobile_num.click();
		Mobile_num.sendKeys("8888888888");
		Thread.sleep(2000);
		
		driver.findElement(By.id("email")).sendKeys("rawan2829@gmail.com");
		Thread.sleep(2000);
		boolean Male = driver.findElement(By.xpath("//input[@value=\"Male\"]")).isSelected();
		System.out.println(Male);
		driver.findElement(By.id("pincodeSpg")).sendKeys("413005");
		
		boolean terms_condition = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[1]")).isSelected();
		if(terms_condition==true) {
			System.out.println("Selected");
		}else {
			System.out.println("Not-selected");
		}
		Thread.sleep(2000);
		
		boolean Next_butn = driver.findElement(By.xpath("//button[text()=\"NEXT\"]")).isEnabled();
		if(Next_butn==true) {	
			System.out.println("Enable");
		}else {
			System.out.println("Disable");
		}
			driver.findElement(By.xpath("//button[text()=\"NEXT\"]")).click();
		
	    
		
		driver.quit();
		
		
		
		
		
		
		
		
		

	}

}
