package com.demo.service;

/*
 * Store the constant key value for roman letters and numerals
 * return romanLetter and Numeral value
*/

public class RomonNumber { 
	
	
	
	public enum RomanValues {
		I ("I", 1),
		V ("V", 5),
		X ("X", 10),
		L ("L", 50),
		C ("C", 100),
		D ("D", 500),
		M ("M", 1000);
		
		private String romanLetter;
		private double numeralValues;

		RomanValues(String romanLetter, int numeralValues) {
			this.romanLetter = romanLetter;
			this.numeralValues = numeralValues;
		}
		
		public String getRomanLetter() {
			return romanLetter;
		}
		
		public double getNumeralValues() {
			return numeralValues;
		}
	}
	
	public enum SubtractValues {
		I ("VX"),
		X ("LC"),
		C ("DM");
		
		private String substractRoman;
		
		SubtractValues(String substractRoman) {
			this.substractRoman = substractRoman;
		}
		
		public String getSubstractRoman() {
			return substractRoman;
		}

	}
	
	public static boolean contains(String roman) {

	    for (RomanValues romanValue : RomanValues.values()) {
	        if (romanValue.name().equals(roman)) {
	            return true;
	        }
	    }

	    return false;
	}

}
