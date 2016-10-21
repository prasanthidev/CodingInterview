package com.ib.bits;

public class DivideIntegers {

	private static int divide(int a, int b){
		if(b == 1)
			return a;
		
		if(b == 0)
			return Integer.MAX_VALUE;
		
		if(a <= Integer.MIN_VALUE)			
			a = Integer.MAX_VALUE;
		
		if(a<0)
			a = a * (-1);	
		if(b<0)
			b = b * (-1);
		
		int result = 0;
		while(a>=b){
			a = a - b;
			result++;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-2147483648, -1));
	}

}
