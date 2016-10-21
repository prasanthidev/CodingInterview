package com.ib.strings;

public class ValidNumber {

	public class Solution{
		public int isValid(String a){
			char[] ch = a.toCharArray();
			int countChar = 0;
			for(int i=0; i<ch.length; i++){
				if (!Character.isDigit(ch[i])) {
			    	countChar++;
			    }
			}
			
			if(countChar > 2)
				return 0;
			
			Boolean isExponent = false;
			for(int i=0; i<ch.length; i++){
				if(ch[i] == '.'){
					if(isExponent)
						return 0;
				}else if(ch[i] == 'e'){
					isExponent = true;
					break;
				}					
			}
			return 1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
