package org.Fidelity.GeneralUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	Properties property;
	public void initializePropertyfile(String PropertyPath) {
		FileInputStream fis = null;
		try {
			 fis = new FileInputStream(PropertyPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties property = new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public String getDataFromPropertFile(String key) {
		return property.getProperty(key).trim();
	}
	

}
