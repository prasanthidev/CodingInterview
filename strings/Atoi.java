package com.ib.strings;

import java.util.ArrayList;

public class Atoi {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(atoi("-6435D56183011M11   648G1 903778065  762 75316456373673B5 334 19885 90668 8 98K  X277 9846 "));
		System.out.println(isValidString("         "));
	}
	
	public ArrayList<Integer> intersect(final ArrayList<Integer> a, final ArrayList<Integer> b) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		
		int arr1len = a.size();
		int arr2len = b.size();
		int startIndex = 0;
		
		return output;
	}
	
	private static int isValidString(String input)
	{
		// can start with + or -
		// inbetween once can contain .
		// inbetween once can contain e and - can follow e
		// remaining are 0 to 9 numbers
		int result = 0;
		input = input.trim();
		boolean eFound = false;
		boolean dotFound = false;
		int startIndex = 0;
		if(input == null || input.length() == 0){
			return 0;
		}
		char charAt = input.charAt(0);
		if(charAt == '-' || charAt == '+'){
			startIndex++;
		}
		for(int i =startIndex; i< input.length(); i++){
			charAt = input.charAt(i);
			if(charAt == 'e'){
				if(eFound){
					return 0;
				}
				eFound = true;
				if(i + 1 == input.length()){
					return 0;
				}
				charAt = input.charAt(i + 1);
				if(charAt == '-' || charAt == '+'){
					i++;
				}
			    continue;
			}
			if(charAt == '.'){
				if(dotFound || eFound){
					return 0;
				}
				if(i + 1 == input.length()){
					return 0;
				}
				dotFound = true;
			    continue;
			}
			int value = Character.getNumericValue(charAt);
			if(value < 0 || value >9){
				return 0;
			}
			result = 1;
		}
		return result;
	}
	
	private static String convert(String a, int b) {
		String output = "";
		String[] outputStrings = new String[b];
		for(int i =0; i< b; i++){
			outputStrings[i] = "";
		}
		int length = a.length();
		for(int i = 0; i < length;){
			for(int j =0; j<b && i < length; j++, i++){
				outputStrings[j] = outputStrings[j] + a.charAt(i);
			}
			for(int j = b -2; j > 0 && i < length; j--, i++){
				outputStrings[j] = outputStrings[j] + a.charAt(i);
			}
		}
		
		for(int i =0; i< b ;i++){
			if(outputStrings[i] != null)
			output = output + outputStrings[i];
		}
		return output;
	}
	
    private static String LargestPalendrone(String input){
    	String reverseString = "";
    	String largestPalindrone = "";
    	int largestPalindroneLength = 0;
    	int length = input.length();
    	int lastStartIndex = 0;
    	for(int i = length - 1; i >= 0 ; i--){
    		reverseString = reverseString.concat(input.charAt(i) + "");
    	}
    	int[][] num = new int[length][length];
    	input = input.toLowerCase();
    	reverseString = reverseString.toLowerCase();
    	
    	// largest common substring
    	for(int i =0; i< length; i++ ){
    		for(int j =0; j< length ; j++){
    			if(input.charAt(i) == reverseString.charAt(i)){
    				num[i][j] = num[i-1][j-1];
    			}
    			if(num[i][j] > largestPalindroneLength){
    				int firstStringPosition = i - num[i][j] + 1;
    				int secondStringPosition = j - num[i][j] + 1;
    				if(firstStringPosition + secondStringPosition != length -1){
    					continue;
    				}
    				largestPalindroneLength = num[i][j];
    				if(lastStartIndex == firstStringPosition){
    					largestPalindrone = largestPalindrone.concat(input.charAt(i) + "");
    				}else{
    					lastStartIndex = firstStringPosition;
    					
    				}
    			}
    		}
    	}
        return input;
        
    }
    
    public static String reverseWords(String a) {
    	String reverseString = "";
    	a = a.trim();
        int length = a.length();
        boolean spaceIncluded = false;
        String outputSubString = "";
        
        for(int i = 0; i < length ; i++){
        	char charAt = a.charAt(i);
        	if(charAt == ' '){
        		if(spaceIncluded){
        			continue;
        		}else{
        			reverseString = outputSubString + " " + reverseString;
        			spaceIncluded = true;
        			outputSubString = "";
        			continue;
        		}
        	}
        	spaceIncluded = false;
        	outputSubString = outputSubString.concat(charAt + "");
        }
        reverseString = outputSubString + " " + reverseString;
        reverseString = reverseString.trim();
        return reverseString;
	}
    
    private static int strStr(final String haystack1, final String needle1) {
    	String haystack = haystack1.toLowerCase();
    	String needle = needle1.toLowerCase();
    	if(haystack == "" || needle == ""){
    		return -1;
    	}
    	for(int i =0; i< haystack.length(); i ++){
    		int j =0;
    		for(j=0; j< needle.length() && i + j < haystack.length(); j++){
    			if(haystack.charAt(i+j) != needle.charAt(j)){
    				break;
    			}
    		}
    		if(j == needle.length()){
				return i;
			}
    	}
    	return -1;
	}
    
	private static int atoi(String input){
		input = input.trim();
		boolean isNumberNegative = false;
		int startIndex = 0;
		String outputStrng = "0";
		char charAtZero = input.charAt(0);
		if(charAtZero == '-')
		{
			isNumberNegative = true;
			startIndex = 1;
		}
		if(charAtZero == '+')
		{
			startIndex = 1;
		}
		for(int i = startIndex; i < input.length(); i++){
			char charAt = input.charAt(i);
			int isInteger = Character.getNumericValue(charAt);
			if(isInteger == -1 || isInteger > 9){
				break;
			}
			outputStrng = outputStrng.concat(charAt + "");
		}
		try {
		    int result = Integer.parseInt(outputStrng);
		    if(isNumberNegative){
		    	return result * -1;
		    }
		    return result;
		} catch (NumberFormatException e) {
			if(isNumberNegative){
		    	return Integer.MIN_VALUE;
		    }
		    return Integer.MAX_VALUE;
		}
	}
}
