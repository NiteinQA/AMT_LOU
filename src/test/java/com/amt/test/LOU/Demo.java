package com.amt.test.LOU;

import java.time.LocalDate;

public class Demo {
	
	public static void main(String[] args) {
		
		LocalDate futureDate = LocalDate.now().plusMonths(1);
		
		
		
		String str = String.valueOf(futureDate);
		
		String str1[] = str.split("-");
		
		System.out.println(str1[2]+str1[1]+str1[0]);
		
		String str2 = str1[2].concat("/").concat(str1[1]).concat("/").concat(str1[0]);
	
		System.out.println(str2);
		
	}

}
