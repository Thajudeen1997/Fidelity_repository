package org.Fidelity.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TwoDimensionalArray {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/Regdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("CommonData");
//		int data = (int)sheet.getRow(2).getCell(0).getNumericCellValue();
//		System.out.println(data);
		DataFormatter df = new DataFormatter();
		sheet.getRow(1).createCell(2).setCellValue("pass");
		sheet.createRow(3).createCell(2).setCellValue("fail");
		FileOutputStream fos = new FileOutputStream("./src/test/resources/Regdata.xlsx");
		wb.write(fos);
		System.out.println("successfully updated");
		wb.close();
		
		
	}
}

