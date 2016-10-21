package com.ib.strings;

public class ReverseString {

	private static String reverseString(String a){		
		char[] ch = a.toCharArray();
		int N = ch.length;
		
		// Reverse the string
		ch = swap(ch, 0, N-1);
		
		// Reverse each word and remove the extra whitespace
		String b = "";
		int startIndex = -1, endIndex = -1;
		for(int i=0; i<N; i++){
			if(ch[i] == ' '){
				if(endIndex != -1){
					ch = swap(ch, startIndex, endIndex);
					if(b.length() == 0)
						b = String.copyValueOf(ch, startIndex, (endIndex-startIndex+1));
					else
						b = b + " " + String.copyValueOf(ch, startIndex, (endIndex-startIndex+1));
					startIndex = endIndex = -1;
				}
				continue;
			}else{
				if(startIndex == -1)
					startIndex = i;
				endIndex = i;
			}			
		}	
		if(endIndex != -1){
			ch = swap(ch, startIndex, endIndex);
			if(b.length() == 0)
				b = String.copyValueOf(ch, startIndex, (endIndex-startIndex+1));
			else
				b = b + " " + String.copyValueOf(ch, startIndex, (endIndex-startIndex+1));
		}
		return b;
	}
	private static char[] swap(char[] ch, int i, int j){
		int N = 0;
		if((j-i)%2 == 0)
			N = i+((j-i)/2);
		else
			N = i+((j-i)/2) + 1;
		
		for(int k=i; k<N; k++, j--){
			char c = ch[k];
			ch[k] = ch[j];
			ch[j] = c;
		}
		return ch;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(reverseString("j gh"));
	}

}
