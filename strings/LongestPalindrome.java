package com.ib.strings;

import java.util.ArrayList;

public class LongestPalindrome {

	public static Boolean isPalindrome(String a) {
		StringBuilder str = new StringBuilder(a);
		str = str.reverse();
		if(str.toString() == a)
			return true;
		
		int length = a.length();
		String b;
		int index = length/2;
		if(length%2==0){	
			b = a.substring(index);			
		}else{
			b = a.substring(index+1);
		}
		StringBuilder strbuilder = new StringBuilder(b);
		b = strbuilder.reverse().toString();
		if(a.substring(0, index).contains(b))
			return true;
		return false;
	}
	
	private static String longestPalindrome(String a){
		StringBuilder str = new StringBuilder(a);
		str = str.reverse();
		if(str.toString() == a)
			return a;
		
		Boolean isFound = false;
		ArrayList<StringBuilder> set = new ArrayList<StringBuilder>();
		for(int i=0; i<a.length(); i++){
			for(int j=a.length(); j>=i; j--){
				String substring = a.substring(i, j);
				if(isPalindrome(substring)){
					set.add(new StringBuilder(substring));
					if(j == a.length())
						isFound = true;
					break;
				}
				
			}
			if(isFound)
				break;
		}
		
		if(set.isEmpty())
			return "";
		
		int index = 0;
		int maxLength = 0;
		for(int i=0; i<set.size(); i++){
			int length = set.get(i).length();
			if(length > maxLength){
				index = i;
				maxLength = length;
			}
		}
		
		return set.get(index).toString();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("abb"));
	}

}
