package org.Fidelity.practise;


import java.sql.SQLException;
import java.util.List;

import org.Fidelity.GeneralUtility.DatabaseUtility;
import org.Fidelity.GeneralUtility.IConstantPath;
import org.Fidelity.GeneralUtility.JavaUtility;

public class FetchDataFromDatabaseUsingUtility {
	public static void main(String[] args) throws SQLException {
//		DatabaseUtility dataBaseutility = new DatabaseUtility();
//		dataBaseutility.connectToDatabase(IConstantPath.DB_URL, "root", "root");
//		List<String> data = dataBaseutility.getDataFromDatabase("select * from sdet40;", "EmpName");
//		System.out.println(data);
//		dataBaseutility.closeDatabaseConnection();
		JavaUtility javaUtility = new JavaUtility();
		String systemDate = javaUtility.getSystemDate();
		int count =1;
		while (count<10) {
			System.out.println(systemDate);
			count++;
		}
		
	}
	

}
