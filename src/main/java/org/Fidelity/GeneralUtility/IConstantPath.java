package org.Fidelity.GeneralUtility;

public interface IConstantPath {
	String PROJECT_PATH = System.getProperty("user.dir");
	String EXCEL_PATH = PROJECT_PATH + "/src/test/resources/REGTC1.xlsx";
	String PROPERTY_PATH = PROJECT_PATH+ "/src/test/resources/RegTC4.properties";
	String DB_URL = "jdbc:mysql://localhost:3306/tjty";
	

}
