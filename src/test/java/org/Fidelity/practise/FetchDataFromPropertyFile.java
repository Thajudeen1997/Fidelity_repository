package org.Fidelity.practise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class FetchDataFromPropertyFile {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/RegTC4.properties");
		Properties loadproperty = new Properties();
		loadproperty.load(fis);
		String url = loadproperty.getProperty("url").trim();
		System.out.println(url);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/RegTC4.properties");
		loadproperty.setProperty("dob", "10/07/1997");
		loadproperty.save(fos, url);
	}
}
