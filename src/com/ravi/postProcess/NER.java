package com.ravi.postProcess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NER {
	
	public static  String name(String input){
		/*
		my name is ram
		my name is ram kapoor
		ram
		ram kapoor
		my name ram
		ram shankar patel
		i am ram shankar patel
		*/
		String[] k=input.split(" ");
		if(k.length<=2){
			return input;
		}
		else{
			for(int i=0;i<k.length;i++){
				
				if(k[i].equals("name")){
					if(k[i+1].equals("is")){
						return input.substring(input.indexOf("is")+3);
					}
					else{
						return input.substring(input.indexOf("name")+5);
					}
				}
				if(k[i].equals("am")){
						return input.substring(input.indexOf("am")+3);
				}
			}
			return input;
		}
		
	}
	public static String age(String input){
	/*
	age of the victim is 17
	age is 17
	17
	he is 17 years old
	he is 17 years of age
	his age is 17 years*/
	Matcher matcher = Pattern.compile("\\d+").matcher(input);
	matcher.find();
	int i = Integer.valueOf(matcher.group());
	if(i<15){
		return "low";
	}
	if(i>60){
		return "high";
	}
	if(i>=15 && i<=60){
		return "mid";
	}
	return null;
	}
	public static String time(String input){
		/*
		its been 5 minutes
		its been around 15 minutes
		5 minutes*/
		Matcher matcher = Pattern.compile("\\d+").matcher(input);
		matcher.find();
		int i = Integer.valueOf(matcher.group());
		if(i<10){
			return "low";
		}
		if(i>40){
			return "high";
		}
		if(i>=10 && i<=40){
			return "mid";
		}
		return null;
		}
}
