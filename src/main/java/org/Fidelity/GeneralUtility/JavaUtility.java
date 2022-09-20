package org.Fidelity.GeneralUtility;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.testng.asserts.SoftAssert;

import net.bytebuddy.agent.builder.AgentBuilder.InitializationStrategy.SelfInjection.Split;
import pomRepository.PageTitle;

public class JavaUtility {
	private SoftAssert soft;
/*
 * This method is to create the all java reusable actions
 */
	public int getRandomNumber(int Number) {
		Random random = new Random();
		int randomno = random.nextInt(Number);
		return randomno;
		
	}
	public Object convertStringToAnyDatatype(String Data, DataConversion strategy) {
		Object obj = null;
		if(strategy.toString().equalsIgnoreCase("long")) {
			 obj = Long.parseLong(Data);
		}
		else if(strategy.toString().equalsIgnoreCase("int")) {
			obj = Integer.parseInt(Data);
		}
		else if(strategy.toString().equalsIgnoreCase("double")) {
			obj = Double.parseDouble(Data);
		}
		return obj;
	}
	/**
	 * This method is to get application number from the alert pop up
	 * @return
	 */
	public String alertGetNoFromPopup(String text) {
		String number="";
		for(int i=0; i<text.length(); i++) {
			if(text.charAt(i)>='0'&& text.charAt(i)<='9') {
				number = number + text.charAt(i);
			}
		}
		return number;
	}

	public String getDebitcardPin(String DebitNo) {
		String cardpin ="";
		for(int i =0; i<DebitNo.length(); i++) {
			if(i>11) {
				cardpin = cardpin + DebitNo.charAt(i);
			}
		}
		return cardpin;
	}
	public String getDebitcardNo(String DebitNo) {
		String cardno ="";
		for(int i =0; i<DebitNo.length(); i++) {
			if(i<=11) {
				cardno = cardno + DebitNo.charAt(i);
			}
		}
		return cardno;
	}
	public String getCustomerId(String acc) {
		String cusId ="";
		for(int i=0; i<acc.length(); i++) {
			if(acc.charAt(i)>='0'&& acc.charAt(i)<='9') {
				cusId = cusId + acc.charAt(i);
			}
		}
		return cusId;
	}
	public String getSystemDate() {
		Date date = new Date();
		String dateTime = date.toString();
		return dateTime;
	}
	/**
	 * This is method is used to compare the two string 
	 * If equal print message 1 if not print message 2
	 * @param var1
	 * @param var2
	 * @param message1
	 * @param message2
	 */
	public void compareTwoString(String var1, String var2, String message1, String message2) {
		if(var1.equalsIgnoreCase(var2)) {
			System.out.println(message1);
		}
		else {
			System.out.println(message2);
		}
	}
	public String[] splitStringMethod(String variable1, String splitBy) {
		String[] split = variable1.split(splitBy);
		return split;
	}
	public void AssertionPageNavigationVerify(String actualResult, PageTitle pageTitle) {
		soft  = new SoftAssert();
		soft.assertEquals(actualResult, pageTitle.getPageTitle());
	}
	public void AssertionContainsTwoString( String expectedResult, String actualResult) {
		soft.assertTrue(actualResult.contains(expectedResult), "Test case Passed");;
	}
	public void AssertionCheckTrue(Boolean condition) {
		soft.assertTrue(condition, getSystemDate());
	}
	public void AssertAll() {
		soft.assertAll();
		
	}
	public String CurrentDate() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String actualDate = sdf.format(date);
		return actualDate;	
	}
	/**
	 * This method is to verfiy the alert whether success alert or failure alert 
	 */
	public void verifyAlertMessage(String actual, String expected) {
		soft.assertTrue(actual.contains(expected));
	}
	
}
