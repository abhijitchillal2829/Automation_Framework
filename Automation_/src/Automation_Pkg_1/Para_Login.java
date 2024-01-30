package Automation_Pkg_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Para_Login {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public Para_Login(String excelpath) throws IOException {
		File fi = new File(excelpath);
		FileInputStream fis = new FileInputStream(fi);
		wb = new XSSFWorkbook(fis);
	}
	public String getdata(int sheet_num, int row_count, int cell_count) {
		sheet = wb.getSheetAt(sheet_num);
		String data = sheet.getRow(row_count).getCell(cell_count).getStringCellValue();
		return data;
	}
	public int getrowcount(int Sheet_num) {
		sheet = wb.getSheetAt(Sheet_num);
		int row_num = sheet.getLastRowNum(); // index
		row_num = row_num + 1; // actual row counting
		return row_num;
	}
	public static class excel {
		public static void main(String[] args) throws IOException, InterruptedException {
			Para_Login pl = new Para_Login("/home/apmosys/Desktop/Xcel/Login_Data.xlsx");
			int row = pl.getrowcount(0);
			for (int i = 1; i < row; i++) {
				WebDriver driver = new ChromeDriver();			
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
				String username , pass;	
				username = pl.getdata(0, i, 0);
				pass = pl.getdata(0, i, 1);	
				driver.get("https://mail.apmosys.com/webmail/");
				driver.findElement(By.name("email-address")).sendKeys(username);
	            driver.findElement(By.name("next")).click();
				driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(pass);
				driver.findElement(By.xpath("//button[@type=\"button\"]")).click();
			}
		}
}
}
