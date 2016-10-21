package com.ib.strings;

public class LastWord {
	private static int lastWordLength(String a){
		char[] ch = a.toCharArray();
		int start = -1, end = 0;
		for(int i=ch.length-1 ;i>=0; i--){
			if(ch[i] == ' '){
				if(start != -1)
					break;								
				continue;
			}
			if(start == -1)
				start = i;
			end = i;
		}
		
		return start - end + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lastWordLength("   "));
	}
}
