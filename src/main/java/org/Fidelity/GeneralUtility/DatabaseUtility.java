package org.Fidelity.GeneralUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	/**
	 * This method is used to create a new driver for database
	 * And also register driver to jdbc
	 * And also to create connection
	 */
	Connection connection;
	public void connectToDatabase(String dbURL, String dbUsername, String dbPassword) throws SQLException {
		Driver dbdriver = new Driver();


		DriverManager.registerDriver(dbdriver);
		// register driver to jdbc

		connection = DriverManager.getConnection(dbURL, dbUsername, dbPassword);

	}
	/**
	 * This method is to 
	 * @param query
	 * @param columnName
	 * @return
	 */
	public List<String> getDataFromDatabase( String query, String columnName) {

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		} // non static method
		ResultSet result = null;
		List<String> list = new ArrayList();
		try {
			result = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(result.next()) {
				try {
					list.add(result.getString(columnName));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	public void closeDatabaseConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
