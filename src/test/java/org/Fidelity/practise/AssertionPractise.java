package org.Fidelity.practise;

import org.Fidelity.GeneralUtility.JavaUtility;
import org.testng.asserts.SoftAssert;

import pomRepository.PageLink;
import pomRepository.PageTitle;

public class AssertionPractise {
	public static void main(String[] args) {
//		SoftAssert soft = new SoftAssert();
//		String actual = "hi";
//		String expected = "hi";
//		soft.assertEquals(actual, expected, "Pass");
//		System.out.println();
//		soft.assertAll();
		System.out.println(PageTitle.CREDIT_CUSTOMER);
		System.out.println(PageTitle.APPLY_DEBIT_CARD);
		JavaUtility javaUtility = new JavaUtility();
		javaUtility.AssertionPageNavigationVerify("Apply Debit Card", PageTitle.APPLY_DEBIT_CARD);
		javaUtility.AssertAll();
	}

}
