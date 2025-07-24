package Utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Input {
	public static  Object [][] importexcel(String findfile) throws IOException {

		//		String findfile = "C:\\ProgramData\\AFL_Contracts\\input\\login.xlsx";

		XSSFWorkbook find_wbook = new XSSFWorkbook("./Input_Excel/" + findfile + ".xlsx");
		XSSFSheet sheet =  find_wbook.getSheetAt(0);
		int lastRow = sheet.getLastRowNum();	
		int PhysicalNumberOfRows = sheet.getPhysicalNumberOfRows();
		//		System.out.println("active rows" +PhysicalNumberOfRows);
		//		System.out.println("getLastRowNum---" + lastRow);
		short lastcolumn = sheet.getRow(0).getLastCellNum();
		//		System.out.println("no of rows---" + lastcolumn);
		Object [][] data = new Object [lastRow][lastcolumn];
		for (int i = 1; i <= lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastcolumn; j++) {
				XSSFCell cell = row.getCell(j);
                
				
				if(cell.getCellType() == CellType.NUMERIC) {
					int numaricvalue = (int) cell.getNumericCellValue();
					data[i-1][j] = numaricvalue;
					System.out.println("The login credentail is ---"+ numaricvalue);

				}


			   if(cell.getCellType() == CellType.STRING){
					DataFormatter dft = new DataFormatter();
					String formated_value = dft.formatCellValue(cell);

					data[i-1][j] = formated_value;
					System.out.println("The login credentail is ---"+ formated_value);
				}
				

			}
		}
		find_wbook.close();
		return data;
	}

}
