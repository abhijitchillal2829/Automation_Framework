package Task_ActiveTime_Login;

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

public class ActiveTime_Login {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");

		String Username = driver.findElement(By.xpath("//b[text()=\"admin\"]")).getText();
		System.out.println(Username);

		String Password = driver.findElement(By.xpath("//b[text()=\"manager\"]")).getText();
		System.out.println(Password);

		WebElement User = driver.findElement(By.id("username"));
		User.click();
		User.sendKeys(Username);

		WebElement Pass = driver.findElement(By.xpath("(//input[@type=\"password\"])[1]"));
		Pass.click();
		Pass.sendKeys(Password);

		driver.findElement(By.xpath("//div[text()=\"Login \"]")).click(); // login
		driver.findElement(By.xpath("//a[text()=\"Lock Time-Track\"]")).click(); // lock time click
		Thread.sleep(3000);

		// fetch data from table to xcel--

		WebElement Table_body = driver.findElement(By.xpath("//div[@id=\"lockTablePlaceholder\"]//table//tbody"));
		List<WebElement> Table_row = Table_body.findElements(By.tagName("tr"));
		String Path = "/home/apmosys/Desktop/Xcel/Acti_Time.xlsx";
		FileInputStream fis = new FileInputStream(Path);
		XSSFWorkbook work = new XSSFWorkbook(fis);
		XSSFSheet sheet = work.createSheet("Table_data_23");
		XSSFCell c=null ;
		for (int row = 0; row < Table_row.size(); row++) {
            int total = 0;
			XSSFRow r = sheet.createRow(row + 1);
			List<WebElement> data = Table_row.get(row).findElements(By.tagName("td"));
			// div[@id=\"lockTablePlaceholder\"]//table//tbody//tr//td
			for (int col = 2; col < data.size(); col++) {
				String T_data = data.get(col).getText();
				String T_data_1 = T_data.replaceAll("[^0-9]", "");
				int num = Integer.parseInt(T_data_1);
				c = r.createCell(col);
				total = total+num;
			}
			c.setCellValue(total);
			total=0;
		}
		fis.close();
		FileOutputStream fos = new FileOutputStream(Path);
		work.write(fos);
		fos.close();
		work.close();
		driver.quit();

		// parceint
		// total---ver
		// total = total+data
		Integer.parseInt("");
	}

}
