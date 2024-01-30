package Automation_Pkg_1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Apmosys_Mail_Automation {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://mail.apmosys.com/webmail/");
	    Thread.sleep(3000);
	    
	    //Login---page1
	    driver.findElement(By.xpath("//input[@name=\"email-address\"]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@type=\"email\"]")).sendKeys("abhijit.chillal@apmosys.com");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[text()=\"Next\"]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@name=\"password\"]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("vun&7Tgpt");
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//span[text()=\"Sign in\"]")).click();
	    Thread.sleep(4000);
	    
	    //Compose---page_2
	   driver.findElement(By.xpath("//a[@id=\"gui.frm_main.hmenu1/0\"]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id=\"gui.frm_compose.to.plus#main\"]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id=\"gui.frm_compose.to.plus#main\"]")).sendKeys("tushar.jakate@apmosys.com", Keys.ENTER);
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//div[@id=\"gui.frm_compose#switch\"]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id=\"gui.frm_compose.cc.plus#main\"]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id=\"gui.frm_compose.cc.plus#main\"]")).sendKeys("abhijit.gorane@apmosys.com" , Keys.ENTER , "krushnal.mahajan@apmosys.com", Keys.ENTER);;
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id=\"gui.frm_compose.bcc.plus#main\"]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id=\"gui.frm_compose.bcc.plus#main\"]")).sendKeys("pratik.panda@apmosys.com" , Keys.ENTER);
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id=\"gui.frm_compose.subject#main\"]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id=\"gui.frm_compose.subject#main\"]")).sendKeys("Re: Script Issue Status 13-04-2023 5pm");
	   Thread.sleep(2000);
	   WebElement text_area = driver.findElement(By.xpath("//a[@id=\"gui.frm_compose.body/paste_text\"]"));
	   text_area.click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//textarea[@id=\"gui.rich_popup.input#main\"]")).click();
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//textarea[@id=\"gui.rich_popup.input#main\"]")).sendKeys("Dear Team, "
	   		+ "Please find attached Updated file of script issues for 14-04-2023-9.30am.\n"
	   		+ "Thanks & Regards\n"
	   		+ "Abhijit Chillal\n"
	   		+ "QC Team");
	   Thread.sleep(1000);
	   driver.findElement(By.xpath("//input[@id=\"gui.rich_popup.btn_ok#main\"]")).click();
	   Thread.sleep(1000);
//	   Thread.sleep(1000);
	   
	   //upload file---page3
	   driver.findElement(By.id("gui.frm_compose.x_btn_att#main")).sendKeys("/home/apmosys/Downloads/DashboardStatus-15-04-2023-12.30pm.xlsx");
//	   driver.findElement(By.xpath("//form[@id=\"gui.frm_compose.x_btn_att\"]//following-sibling::div")).click();
//	   Thread.sleep(1000);
//	   System.out.println("Hello");
//	   driver.findElement(By.xpath("//span[contains(text(),\"From Files & Documents\")]")).click();
//	   Thread.sleep(3000);
//	   driver.findElement(By.xpath("//span[@id=\"gui.insert_item.filter#M\"]")).click();
//	   Thread.sleep(2000);
//	   driver.findElement(By.xpath("//div[@id=\"gui.insert_item.datagrid/*9730378/HAS_ATTACHMENT\"]")).click();
//	   Thread.sleep(1000);
//	   System.out.println("Hello_2");
//	   driver.findElement(By.xpath("//input[@id=\"gui.insert_item.x_btn_ok#main\"]")).click();
//	   driver.findElement(By.xpath("//input[@id=\"gui.frm_compose.x_btn_send#main\"]")).click();
	   
	   Thread.sleep(7000);
	   
	  //counting total inbox mess----
	   String Title = driver.getTitle();
	   System.out.println(Title.replaceAll("Total inbox :"+"[^0-9]", ""));
	   
	 //unread mess----
	   String S = driver.findElement(By.xpath("//b[text()=\"Inbox\"]//following-sibling::u")).getText();
	   System.out.println("Unread Message :"+S.replaceAll("^[0-9]", ""));
	   
	   //sent mess---
	   driver.findElement(By.xpath("//div[@class=\"ico ico_sent default\"]")).click();
	   Thread.sleep(1000);
	   String S1 = driver.getTitle();
	   System.out.println(S1.replaceAll("Sent Message :"+"[^0-9]", ""));
	   
	   
	   Thread.sleep(1000);
	   driver.quit();
	  
	   
	   
	    

	}

}
