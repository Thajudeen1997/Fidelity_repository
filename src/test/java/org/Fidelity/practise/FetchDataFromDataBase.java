package org.Fidelity.practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDataBase {
	public static void main(String[] args) throws SQLException {
		Driver dbdriver = new Driver();
		DriverManager.registerDriver(dbdriver); // register driver to jdbc
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tjty", "root", "root");
		try {
		Statement statement = connection.createStatement(); // non static method
		ResultSet result = statement.executeQuery("select * from sdet40");
		while(result.next()) {
			System.out.println(result.getString("EmpName"));
		}
	}
	finally {
		connection.close();
	}
	}
}
