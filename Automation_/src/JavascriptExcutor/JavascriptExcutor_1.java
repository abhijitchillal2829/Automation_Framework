package JavascriptExcutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExcutor_1 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		Thread.sleep(3000);
		
		JavascriptExecutor Js = (JavascriptExecutor)driver;
		Js.executeScript("window.scrollBy(0 , 3000)", "");
		
	    Thread.sleep(5000);
	    
//	    Js.executeScript("document.getElementByXpath("").value=""", "");
	    WebElement Ele = driver.findElement(By.xpath("//span[@class=\"navFooterBackToTopText\"]"));
	    Js.executeScript("arguments[0].scrollIntoView();", Ele);
	    System.out.println("Hello");
	    
	    driver.quit();
		
	}

}
