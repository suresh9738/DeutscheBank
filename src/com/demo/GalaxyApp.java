package com.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.demo.service.CommonService;

public class GalaxyApp {
	
	public static void main(String[] args) {
		String file = args[0] + "\\" + "coding_input.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
		    String line;
		    List<String> questionList = new ArrayList<String>();
		    List<String> inputList = new ArrayList<String>();
		    while ((line = br.readLine()) != null) {
		       if(line.contains("?")) {
		    	   questionList.add(line);
		       } else {
		    	   inputList.add(line);
		       }
		    }
		    Map<String, String> romanLetters = CommonService.findRomanLetters(inputList);
		    Map<String, Double> itemsValue = CommonService.findCreditsValue(inputList, romanLetters);
		    List<String> answerList = CommonService.findAnswer(romanLetters, itemsValue, questionList);
		    for(String answer : answerList) {
		    	System.out.println(answer);
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
