package Automation_Pkg_1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable_Automation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.programiz.com/sql/online-compiler/");
		driver.manage().timeouts().implicitlyWait(20 , TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
		WebElement Table_body = driver.findElement(By.xpath("(//div[@class=\"table-data\"]//table)[1]//tbody")); //body
		
		List<WebElement> Table_row = Table_body.findElements(By.tagName("tr"));   //row
		
		for(int i=0;i<Table_row.size();i++) {
			
			List<WebElement> Table_data = Table_row.get(i).findElements(By.tagName("td"));   //data
			
			Thread.sleep(3000);
			
			for(int j=0;j<Table_data.size();j++) {
				
				String S = Table_data.get(j).getText();
				System.out.print(S +"\t");
				
			}
			System.out.println("\n");
		}
		
		driver.quit();
		
		
		
		

	}

}
