package com.ib.strings;

import java.util.Arrays;
import java.util.List;

public class IntegerToRoman {
	
	private static String convert(int n){
		String a = "";
		List<String> romanValue = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
		List<Integer> intValue = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
		for(int i=0; n!=0; ){
			int val = intValue.get(i);
			if(n>=val){
				n = n - val;
				a = a + romanValue.get(i);
			}else{
				i++;				
			}
		}
		
		return a;
	}
	private static String getPlaceHolderValue(int N){
		String a = "";
		for(int i=3; i>=0; i--){
			int n = N;
			n = (int) (n / Math.pow(10, i));
			for(int k = 3-i; k>0; k--){
				n = (int) (n % Math.pow(10, k));
			}	
			
			switch(i){
			case 3:
				a = Thousands(a, n);
				break;
			case 2:
				a = Hundreds(a, n);
				break;
			case 1:
				a = Tens(a, n);
				break;
			case 0:
				a = Ones(a, n);
				break;
			default:
				break;
			}
		}
		return a;
	}
	private static String Thousands(String a, int count){
		while(count>0){
			a = a + "M";
			count--;
		}
		return a;
	}
	private static String Hundreds(String a, int count){		
		if(count>=1 && count<4){
			while(count>0){
				a = a + "C";
				count--;
			}
		}else if(count == 4){
			a = a + "CD";
		}else if(count == 5){
			a = a + "D";
		}
		else if(count>5 && count<9){
			a = a + "D";
			count = count - 5;
			while(count>0){
				a = a + "C";
				count--;
			}
		}else if(count == 9){
			a = a + "CM";
		}	
		
		return a;
	}
	private static String Tens(String a,int count){		
		if(count>=1 && count<4){
			while(count>0){
				a = a + "X";
				count--;
			}
		}else if(count == 4){
			a = a + "XL";
		}else if(count == 5){
			a = a + "L";
		}
		else if(count>5 && count<9){
			a = a + "L";
			count = count - 5;
			while(count>0){
				a = a + "X";
				count--;
			}
		}else if(count == 9){
			a = a + "XC";
		}
		
		return a;
	}
	private static String Ones(String a, int count){		
		if(count>=1 && count<4){
			while(count>0){
				a = a + "I";
				count--;
			}
		}else if(count == 4){
			a = a + "IV";
		}else if(count == 5){
			a = a + "V";
		}
		else if(count>5 && count<9){
			a = a + "V";
			count = count - 5;
			while(count>0){
				a = a + "I";
				count--;
			}
		}else if(count == 9){
			a = a + "IX";
		}
		
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPlaceHolderValue(9));
		System.out.println(convert(2907));
	}

}
