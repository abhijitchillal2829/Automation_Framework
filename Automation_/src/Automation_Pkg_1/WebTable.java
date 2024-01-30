package Automation_Pkg_1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bseindia.com/markets/Equity/EQReports/mktwatchR.html?filter=Gainer*group$all$A");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		Thread.sleep(3000);

		WebElement T_Body = driver.findElement(By.xpath("(//div[@class=\"col-lg-12 largetable\"]//table)[2]//tbody"));
		List<WebElement> T_Row = T_Body.findElements(By.tagName("tr"));

		String path = "/home/apmosys/Downloads/Automation_sheet.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.createSheet("BSE_DATA_2");

		for (int r = 0; r < T_Row.size(); r++) {
			List<WebElement> T_Data = T_Row.get(r).findElements(By.tagName("td"));
			for (int d = 0; d < T_Data.size(); d++) {
				String T_data = T_Data.get(d).getText();
				XSSFRow row = sheet.createRow(r);
				XSSFCell cell = row.createCell(d);
				cell.setCellValue(T_data);
			}
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
		wb.close();
		driver.quit();

	}

}
