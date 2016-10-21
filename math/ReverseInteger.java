package com.ib.math;

import java.util.ArrayList;

public class ReverseInteger {
	
	private static int reverse(int n){
		int b = 1, a = 0;
		Boolean isNegative = false;
		if(n<0){
			isNegative = true;
			n = n*-1;
		}
		
		while(n>0){
			b = n % 10;
			n = n/10;			
			if(a > (Integer.MAX_VALUE - b)/10 )
				return 0;
			a = a * 10 + b;
		}
		if(isNegative == true){
			a = a*-1;
		}
		
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(-1146467285));
	}

}
