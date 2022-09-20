package org.Fidelity.practise;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.Fidelity.GeneralUtility.ExcelUtility;
import org.Fidelity.GeneralUtility.IConstantPath;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class FetchDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		FileInputStream fis = new FileInputStream("./src/test/resources/Regdata.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sheet = wb.getSheet("CommonData");
//		int data = (int)sheet.getRow(2).getCell(0).getNumericCellValue();
//		System.out.println(data);
//		DataFormatter df = new DataFormatter();
//		String data1 = df.formatCellValue(sheet.getRow(4).getCell(0));
//		System.out.println(data1);
		ExcelUtility excelUtility = new ExcelUtility();
		excelUtility.initializeExcel(IConstantPath.EXCEL_PATH);
//		String data = excelUtility.getDataFromExcel("TestData-accopening", "dob");
//		System.out.println(data);
//		Map<String, String> data = excelUtility.getDataFromExcelUsingMap("TestData-accopening");
//		System.out.println(data.get("pan"));
		List<Map<String, String>> list = excelUtility.getDataFromExcelUsingListMap("TestMap");
		System.out.println(list.get(2).get("city"));
	}
}