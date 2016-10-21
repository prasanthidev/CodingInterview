package com.ib.strings;

import java.util.ArrayList;

public class LongestCommonPrefix {
    private static String getCommonPrefix(ArrayList<String> a){
    	if(a.size()==1)
    		return a.get(0);
    	int minlength = Integer.MAX_VALUE;
    	int minIndex = -1;
    	for(int i=0; i<a.size(); i++){
    		String s = a.get(i);
    		if(minlength > s.length()){
    			minlength = s.length();
    			minIndex = i;
    		}
    	}
    	String str = a.get(minIndex);
    	int count = 0;
    	for(int j=1; j<=minlength; j++){
    		String s = str.substring(0, j);
    		int i=0;
    		for(; i<a.size(); i++){
    			if(a.get(i).startsWith(s))
    				continue;
    			break;
    		}
    		if(i==a.size())
    			count = count + 1;
    		else
    			break;
    	}	
    	
    	return str.substring(0, count);
    }
    
    private static String getCommonPrefix2(ArrayList<String> inputStrings)
	{
		int shortestStringLength = inputStrings.get(0).length();
		String outputString = "";
		char charAt = inputStrings.get(0).charAt(0);
		for(int i =1 ; i < inputStrings.size(); i++){
			if(inputStrings.get(i).charAt(0) != charAt){
				return outputString;
			}
			int currentStringLength = inputStrings.get(i).length();
			if(currentStringLength < shortestStringLength){
				shortestStringLength = currentStringLength;
			}
		}
		outputString = outputString.concat("" + charAt);
		
		for(int j =1; j< shortestStringLength ; j++){
			charAt = inputStrings.get(0).charAt(j);
			for(int i =0 ; i < inputStrings.size(); i++){
				if(inputStrings.get(i).charAt(j) != charAt){
					return outputString;
				}
			}
			outputString = outputString.concat("" + charAt);
		}
		
		return outputString;
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<String>();
		a.add("aaaa");
		a.add("aa");
		a.add("aaa");
		System.out.println(getCommonPrefix(a));
	}

}
