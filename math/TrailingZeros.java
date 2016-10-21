package com.ib.math;

public class TrailingZeros {

	private static int trailZeros(int n){
		int a = 0, b = 1;
		for(int i=1; b>0; i++){
			b = n / (int)Math.pow(5, i);
			a = a + b;
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailZeros(25));
	}

}
