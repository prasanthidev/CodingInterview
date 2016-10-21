package com.ib.strings;

import java.util.HashMap;

public class RomanToInteger {

	private static int convert2(String a){ 
		HashMap<Character, Integer> map = new HashMap<Character, Integer>(); 
		int result = 0;
		
		map.put('I', 1); 
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		char[] c = a.toCharArray();
		
		for(int i=0; i<c.length; i++){
			
			if(i == c.length-1 || map.get(c[i]) >= map.get(c[i+1])){
				result += map.get(c[i]);
			}else if( map.get(c[i]) < map.get(c[i+1])){
				result = result - map.get(c[i]);
			}
			
		}
		
		return result;
	}
	
	private static int convert(String a){
		int result = 0;
		for(int i=0; i<a.length(); i++){
			Boolean isCalculated = false;
			String substr = "";
			if(i+1<a.length())
				substr = "" + a.charAt(i) + a.charAt(i+1);
			else
				substr = "" + a.charAt(i);
			do{
				switch(substr){
				case "M": 
					result = result + 1000;
					isCalculated = true;
					break;
				case "D": 
					result = result + 500;
					isCalculated = true;
					break;
				case "C": 
					result = result + 100;
					isCalculated = true;
					break;
				case "L": 
					result = result + 50;
					isCalculated = true;
					break;
				case "X": 
					result = result + 10;
					isCalculated = true;
					break;
				case "V": 
					result = result + 5;
					isCalculated = true;
					break;
				case "I": 
					result = result + 1;
					isCalculated = true;
					break;
				case "CM":
					result = result + 900;
					isCalculated = true; i++;
					break;
				case "CD":
					result = result + 400;
					isCalculated = true; i++;
					break;
				case "XC":
					result = result + 90;
					isCalculated = true; i++;
					break;
				case "XL":
					result = result + 40;
					isCalculated = true; i++;
					break;
				case "IX":
					result = result + 9;
					isCalculated = true; i++;
					break;
				case "IV":
					result = result + 4;
					isCalculated = true; i++;
					break;
				default: 
					substr = "" + a.charAt(i);
					break;
				}
			}while(!isCalculated);
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(convert("DCCCIV"));
		System.out.println(convert2("IC"));
	}

}
