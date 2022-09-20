package org.Fidelity.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TwoDimensionalArrayExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Regdata.xlsx");
		 Workbook book = WorkbookFactory.create(fis);
		 Sheet sheet = book.getSheet("2DArray");
		 DataFormatter df = new DataFormatter();
		 String [][] arr = new String [sheet.getLastRowNum()+1][sheet.getRow(sheet.getLastRowNum()).getLastCellNum()];
		 for(int i =0; i<=sheet.getLastRowNum(); i++) {
			 for(int j=0; j<sheet.getRow(sheet.getLastRowNum()).getLastCellNum(); j++) {
				 arr[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				 System.out.println(arr[i][j]);
			 }
		 }
		 for(int i =0; i<=sheet.getLastRowNum(); i++) {
			 for(int j=0; j<sheet.getRow(sheet.getLastRowNum()).getLastCellNum(); j++) {
				 System.out.print(arr[i][j]+"\t");
			 }
			 System.out.println();
		 }
		 System.out.println(sheet.getLastRowNum());
		 System.out.println(sheet.getRow(sheet.getLastRowNum()).getLastCellNum());
		// System.out.println(arr[3][3]);
//		 String value = null;
//		 for(int i=0; i<=sheet.getLastRowNum(); i++) {
//			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
//			if(key.equalsIgnoreCase("staff id")) {
//				value = df.formatCellValue(sheet.getRow(0).getCell(i));
//				break;
//			}
//		 }
//		 System.out.println(value);
	}

}
