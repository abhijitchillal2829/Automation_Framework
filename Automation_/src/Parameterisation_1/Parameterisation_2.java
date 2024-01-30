package Parameterisation_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Parameterisation_2 {

	public static void main(String[] args) throws IOException {

		File f = new File("/home/apmosys/Downloads/DashboardStatus-19-04-2023-2.00pm (1).xlsx");

		FileInputStream file = new FileInputStream(f);

		XSSFWorkbook Wb = new XSSFWorkbook(file);
        
		XSSFSheet sheet = Wb.getSheetAt(0);

		int last_row = sheet.getLastRowNum();
		int last_cell = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < last_row; i++) {

			for (int j = 0; j < last_cell; j++) {

				String S = sheet.getRow(i).getCell(j).toString();
				System.out.print(S +"\t");
			}
		}

//		String S = sheet.getRow(0).getCell(0).getStringCellValue();	
//		System.out.println(S);

	}

}
