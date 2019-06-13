package targetutilites;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class utilites {
	XSSFWorkbook wb;
	XSSFSheet sheet1;
	public utilites(String excelpath) {
		try {
			File src=new File(excelpath);
			FileInputStream  fis= new FileInputStream(src);
			wb= new XSSFWorkbook(fis);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	public String [][]getDataArray(String sheetname){
		sheet1 = wb.getSheet(sheetname);
		int rowCount=sheet1.getLastRowNum();
		int coloumCount = 3;
		int ci=0 ,ri=0;
		String[][]data=new String[rowCount][coloumCount];
		for(int i=0;i<rowCount;i++,ri++) {
			ci=0;
		for(int j=0;j<coloumCount;j++,ci++) {
			System.out.println(sheet1.getRow(i).getCell(j).getDateCellValue());
			data[ri][ci]= sheet1.getRow(i).getCell(j).getStringCellValue();
				}
			
		}
		return data;
		}
}
