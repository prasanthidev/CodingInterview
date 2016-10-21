package com.ib.strings;

public class BinarySum {
	private static String add(String a, String b){
		
		int appendZeroCount = a.length() - b.length();
		if(appendZeroCount >= 0){
			while(appendZeroCount > 0){
				b = "0" + b;
				appendZeroCount--;
			}
		}else{
			while(appendZeroCount < 0){
				a = "0" + a;
				appendZeroCount++;
			}
		}
		int n = a.length();
		String c = "";
		Boolean carry = false;
		for(int i=n-1; i>=0; i--){
			switch(""+a.charAt(i)+b.charAt(i)){
			case "00": {
				if(carry){
					c = "1" + c;
					carry = false;
				}else{					
					c = "0" + c;
				}
			} break;
			case "10": {
				if(carry){
					c = "0" + c;
				}else{					
					c = "1" + c;
				}				
			} break;
			case "01": {
				if(carry){
					c = "0" + c;
				}else{					
					c = "1" + c;
				}
			}break;
			case "11": {
				if(carry){
					c = "1" + c;
				}
				else{
					c = "0" + c;
					carry = true;
				}
			}break;
			
			}			
		}

		if(carry)
			c = "1" + c;
		return c;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(add("011", "1010000101"));
	}

}
