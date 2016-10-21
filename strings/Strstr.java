package com.ib.strings;

public class Strstr {
	private static int strstr(final String needle, final String haystack){
		if(needle.length() == 0 || haystack.length() == 0)
			return -1;
		
		char[] ch_haystack = haystack.toCharArray();
		char[] ch_needle = needle.toCharArray();
		int N = ch_haystack.length;
		int n = ch_needle.length;
		int index = 0;
		int i=0;
		for( ; i<N; i++){
			if(index == n)
				return i-n;
			if(ch_haystack[i] != ch_needle[index]){
				i = i - index;
				index = 0;
			}
			else{
				index++;
			}
		}
		
		if(index == n)
			return i-n;
		
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(strstr("babaaa", "bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba"));
	}

}
