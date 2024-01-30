package Parameterisation_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class parameterisation_1 {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		String path = "/home/apmosys/Downloads/Automation_sheet.xlsx";

		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Amish Tripathi", Keys.ENTER);
		List<WebElement> List = driver
				.findElements(By.xpath("//span[@class=\"a-size-medium a-color-base a-text-normal\"]"));

		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook xs = new XSSFWorkbook(fis);
		XSSFSheet sheet = xs.createSheet("Amazon_data");
		for (int i = 0; i < List.size(); i++) {

			XSSFRow create_row = sheet.createRow(i);
			XSSFCell create_cell = create_row.createCell(0);

			String data = List.get(i).getText();
			create_cell.setCellValue(data);
		}
		fis.close();

		FileOutputStream fos = new FileOutputStream(path);
		xs.write(fos);
		fos.close();
		xs.close();

		driver.quit();

	}

}
