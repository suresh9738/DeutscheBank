package com.demo.util;

import com.demo.service.RomonNumber.RomanValues;

public class ValidateUtil {
	
	public static boolean validateInput(String input) {
		int count = 1;
		for(int i = 1; i < input.length(); i++) {
			boolean isRepeatedRomon = isContain(input.charAt(i));
			if(isRepeatedRomon) {
				if(input.charAt(i) == input.charAt(i-1)) {
					count++;
					if(count == 4) {
						return false;
					} 
				} else {
					count++;
//					if(count == 4) {
						
						if(count == 4 && (RomanValues.valueOf(String.valueOf(input.charAt(i))).getNumeralValues() > RomanValues.valueOf(String.valueOf(input.charAt(i-1))).getNumeralValues())) {
							return false;
						} else {
							count = 1;
						}
//					} else {
//						count = 1;
//					}
				}
			} else {
				count = 1;
				if(input.charAt(i) == input.charAt(i-1)) {
					return false;
				} 
//				else {
//					if(count == 4) {
//						if(count == 4 && (RomanValues.valueOf(String.valueOf(input.charAt(i))).getNumeralValues() > RomanValues.valueOf(String.valueOf(input.charAt(i-1))).getNumeralValues())) {
//							return false;
//						} else {
							count = 1;
//						}
//					} else {
//						count = 1;
//					}
//				}
			}
		}
		return true;
		
		
//		int count = 0;
//		StringBuilder sb = new StringBuilder();
//		for(int i = 0; i < input.length-4; i++) {
//			if(i != 0) {
//				if(numeralValue.get(input[i]).length() > 1) {
//					for(char c : numeralValue.get(input[i]).toCharArray()) {
//						sb = sb.append(c);
//					}
//				} else {
//					sb = sb.append(numeralValue.get(input[i]));
//				}
//				count = (numeralValue.get(input[i]) == numeralValue.get(input[i-1]) ? count++ : 0);
//				if(count > 3) {
//					return -1;
//				}
//			} else {
//				count++;
//			}
//		}
		
		
	}
	
	public static double getNumeralsValue(char roman) {
		return RomanValues.valueOf(String.valueOf(roman)).getNumeralValues();
	}
	
	public static boolean isContain(char romon) {
		for (char letter : Constants.repeatedLetter) {
            if (letter == romon) {
                return true;
            }
        }
		return false;
	}
	
//	public static void main(String[] args) {
//		boolean result = validateInput("XXXLI");
//		System.out.println(result);
//	}

}
