package org.Fidelity.GeneralUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	private Workbook workbook = null;
	/**
	 * This method is used to get datas from the excel
	 * @param SheetName
	 * @param RowNumber
	 * @param CellNumber
	 * @return
	 */
	public String getDataFromExcel(String SheetName, int RowNumber, int CellNumber) {
		Sheet sheet = workbook.getSheet(SheetName);
		String data = new DataFormatter().formatCellValue(sheet.getRow(RowNumber).getCell(CellNumber));
		return data;
	}
	
	/**
	 * This method is used to initialize the excel
	 * @param ExcelPath
	 */
	public void initializeExcel(String ExcelPath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(ExcelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void writeDatatoExcel(String ExcelPath, String SheetName, int RowNumber, int CellNumber, String setData) {
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(ExcelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {

			e.printStackTrace();
		}
		Sheet sheet = workbook.getSheet(SheetName);
		sheet.getRow(RowNumber).createCell(CellNumber).setCellValue(setData);
	}
	/**
	 * This method is used to close the excel workbook
	 */
	public void closingExcel() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getDataFromExcel(String sheetName, String actualKey) {
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		String value = null;
		for(int i =0; i<=sheet.getLastRowNum(); i++) {
			String key = df.formatCellValue(sheet.getRow(i).getCell(0));
			if(key.equalsIgnoreCase(actualKey)) {
				value = df.formatCellValue(sheet.getRow(i).getCell(1));
			}
		}
		return value;
	}
	public Map<String, String> getDataFromExcelUsingMap(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		Map<String, String> map = new HashMap<>();
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(1))); 
		}
		return map;
	}
	public List<Map<String,String>> getDataFromExcelUsingListMap(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		List<Map<String, String>> list = new ArrayList<>();
		for(int k=1; k<sheet.getRow(0).getLastCellNum(); k++) {
			Map<String, String> map = new HashMap<>();
			for(int i=0; i<=sheet.getLastRowNum(); i++) {
				map.put(df.formatCellValue(sheet.getRow(i).getCell(0)), df.formatCellValue(sheet.getRow(i).getCell(k)));
			}
			list.add(map);
		}
		return list;
	}
	public String[][] getMultipleData(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);
		DataFormatter df = new DataFormatter();
		String[][] arr = new String[sheet.getLastRowNum()+1][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<=sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				arr[i][j]=df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return arr;
	}
}
