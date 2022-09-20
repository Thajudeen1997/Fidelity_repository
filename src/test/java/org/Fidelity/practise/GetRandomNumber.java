package org.Fidelity.practise;

import org.Fidelity.GeneralUtility.JavaUtility;

public class GetRandomNumber {
	public static void main(String[] args) {
		JavaUtility ut = new JavaUtility();
		int ranNo = ut.getRandomNumber(100);
		System.out.println(ranNo);
	}

}
