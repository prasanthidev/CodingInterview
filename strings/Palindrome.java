package com.ib.strings;

public class Palindrome {

	public static int isPalindrome(String line) {
		line = line.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
		int length = line.length();
		String b;
		int index;
		if(length%2==0){			
			index = length/2;
			b = line.substring(index);
			
		}else{
			index = length/2+1;
			b = line.substring(index);
		}
		b = reverse(b).toLowerCase();
		if(line.substring(0, index).contains(b))
			return 1;
		return 0;
	}
	
	private static String reverse(String b) {
		// TODO Auto-generated method stub
		int n = b.length();
		if(n==0)
			return b;
		StringBuilder strbuilder = new StringBuilder(b);
		strbuilder=strbuilder.reverse(); 
		return strbuilder.toString();
	}
	

	private static int isPalindrome2(String a) {
	    if(a == null || a.length() == 0){
	    	return 0;
	    }
	    int lengthOfString = a.length();
	    int startIndexValue = -1;
	    int lastIndexValue = -1;
	    int startIndex = 0;
	    int lastIndex = lengthOfString - 1;
	    while(startIndex < lastIndex){
	    	while(startIndex < lengthOfString-1){
	    		startIndexValue = getAsciValue(a.charAt(startIndex));
	    		if(startIndexValue != 0){
	    			break;
	    		}
	    		startIndex ++;
	    	}
	    	while(lastIndex > 0){
	    		lastIndexValue = getAsciValue(a.charAt(lastIndex));
	    		if(lastIndexValue != 0){
	    			break;
	    		}
	    		lastIndex --;
	    	}
	    	if(startIndexValue != lastIndexValue){
	    		return 0;
	    	}
	    	startIndex++;
	    	lastIndex--;
	    }
		return 1;
	}
	
	private static int getAsciValue(char ch){
	   	ch = Character.toLowerCase(ch);
	   	
	   	int characterValue = Character.getNumericValue(ch);
	   	if(characterValue >= 0){
	   		return characterValue;
	   	}
	   	characterValue = (int) ch;
	   	
	   	if((characterValue >= 97 && characterValue <= 122))
	   	{
	   		return characterValue;
	   	}
	   	else return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

}
