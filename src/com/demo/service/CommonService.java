package com.demo.service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.demo.service.RomonNumber.SubtractValues;
import com.demo.util.Constants;
import com.demo.util.ValidateUtil;

public class CommonService {

	public static Map<String, String> findRomanLetters(List<String> inputList) {
		Map<String, String> numeralValue = new HashMap<String, String>();
		for(String inputValue : inputList) {
			String[] input = inputValue.split(" ");
			if(!inputValue.contains("Credits")) {
				numeralValue.put(input[0], input[2]);
			}
		}
		return numeralValue;
	}

	public static Map<String, Double> findCreditsValue(List<String> inputList, Map<String, String> romanLetters) {
		Map<String, Double> itemsValue = new HashMap<String, Double>();
		for(String inputValue : inputList) {
			double credits = 0;
			if(inputValue.contains("Credits")) {
				String[] input = inputValue.split(" ");
				StringBuilder inputString = new StringBuilder();
				for(int i = 0; i < input.length-4; i++) {
					if(RomonNumber.contains(romanLetters.get(input[i]))) {
						inputString = inputString.append(romanLetters.get(input[i]));

					} else {
						//						number validation
					}

				}
				boolean isValid = ValidateUtil.validateInput(inputString.toString());
				int size = inputString.length();
				if(isValid) {
					boolean isValidSubstract = true;
					for(int j = 0; j < inputString.length(); j++) {
						if(j+1 < size) {
							if(ValidateUtil.getNumeralsValue(inputString.charAt(j)) >= ValidateUtil.getNumeralsValue(inputString.charAt(j+1))) {
								credits = credits + ValidateUtil.getNumeralsValue(inputString.charAt(j));
							} else {
								if((SubtractValues.valueOf(String.valueOf(inputString.charAt(j))).getSubstractRoman()).contains(String.valueOf(inputString.charAt(j+1)))) {
									credits = credits + (ValidateUtil.getNumeralsValue(inputString.charAt(j+1)) - ValidateUtil.getNumeralsValue(inputString.charAt(j)));
									j = j + 1;
								} else {
									isValidSubstract = false;
									break;
								}
							}
						} else {
							credits = credits + ValidateUtil.getNumeralsValue(inputString.charAt(j));
						}
					}
					if(isValidSubstract) {
						String item = input[input.length-4];
						double itemValue = Double.parseDouble(input[input.length-2])/credits;
						itemsValue.put(item, itemValue);
					}
				} 

			} 
		}
		return itemsValue;
	}

	public static List<String> findAnswer(Map<String, String> romanLetters, Map<String, Double> itemsValue, List<String> questionList) {
		List<String> answerList = new ArrayList<String>();

		for(String question : questionList) {
			String[] questionArray = question.split(" ");
			int i = Arrays.asList(questionArray).indexOf("is");
			if(i != -1) {
				double credits = 0;
				StringBuilder inputString = new StringBuilder();
				StringBuilder answerString = new StringBuilder();
				int questionSize = questionArray.length;
				if(question.contains("Credits")) {
					questionSize = questionArray.length-1;
				}
				for(i = i+1; i < questionSize; i++) {
					if(RomonNumber.contains(romanLetters.get(questionArray[i].replace("?", "")))) {
						inputString = inputString.append(romanLetters.get(questionArray[i].replace("?", "")));
						answerString = answerString.append(questionArray[i].replace("?", "")).append(" ");
					} else {
						//					number validation
					}
				}
				boolean isValid = ValidateUtil.validateInput(inputString.toString());
				int size = inputString.length();
				if(isValid) {
					boolean isValidSubstract = true;
					for(int j = 0; j < inputString.length(); j++) {
						if(j+1 < size) {
							if(ValidateUtil.getNumeralsValue(inputString.charAt(j)) >= ValidateUtil.getNumeralsValue(inputString.charAt(j+1))) {
								credits = credits + ValidateUtil.getNumeralsValue(inputString.charAt(j));
							} else {
								if((SubtractValues.valueOf(String.valueOf(inputString.charAt(j))).getSubstractRoman()).contains(String.valueOf(inputString.charAt(j+1)))) {
									credits = credits + (ValidateUtil.getNumeralsValue(inputString.charAt(j+1)) - ValidateUtil.getNumeralsValue(inputString.charAt(j)));
									j = j + 1;
								} else {
									isValidSubstract = false;
									break;
								}
							}
						} else {
							credits = credits + ValidateUtil.getNumeralsValue(inputString.charAt(j));
						}
					}
					if(isValidSubstract) {
						DecimalFormat format = new DecimalFormat("0.#");
						String credit = "";
						if(question.contains("Credits")) {
							String item = questionArray[questionArray.length-1];
							if(itemsValue.containsKey(item.replace("?", ""))) {
								credits = credits * itemsValue.get(item.replace("?", ""));
								credit = format.format(credits);
								answerString = answerString.append(item.replace("?", "")).append(" is ").append(" " + credit).append(" Credits");
							} else {
								answerString = new StringBuilder(Constants.ANSWER_NOT_FOUND);
							}
							
						} else {
							credit = format.format(credits);
							answerString = answerString.append("is ").append(" " + credit);
						}
						
						answerList.add(answerString.toString());
					}
				} else {
					answerList.add(Constants.ANSWER_NOT_FOUND);
				}
			} else {
				answerList.add(Constants.ANSWER_NOT_FOUND);
			}
			

		}

		return answerList;
	}
	
	public static String findRomanLetters(String numbers) {
		for(int i = numbers.length()-1; i >= 0; i--) {
			System.out.println(numbers.charAt(i) * i);
		}
		return null;
	}
	
	public static void main(String[] args) {
		findRomanLetters("100");
	}

}
