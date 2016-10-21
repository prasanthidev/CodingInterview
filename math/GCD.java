package com.ib.math;

public class GCD {

	private static int findGCD(int a, int b){
		int n = 1, gcd = 1;
		if(a==0 || b==0)
			return a|b;
		if(a==b)
			return a;
		else if(a>b)
			n = b;
		else
			n = a;
		for(int i=1; i<=n; i++){
			if(a%i==0 && b%i==0){
				gcd = i;
			}
		}
		return gcd;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findGCD(3, 0));
	}

}
