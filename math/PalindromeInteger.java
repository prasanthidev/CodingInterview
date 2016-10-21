package com.ib.math;

public class PalindromeInteger {
	private static Boolean isPalindrome(int n){
		if(n<0)
			return false;
		int noOfdigits = 0;
		int a = n;
		while(a>0){
			a = a/10;
			noOfdigits++;
		}
		noOfdigits = noOfdigits-1;
		for(int len = 0; len <= noOfdigits/2 && n > 0; len++){
			int rem = n%10;
			n = n - rem * (int)Math.pow(10, noOfdigits - 2*len);
			if(n<0)
				return false;
			n = n/10;
		}
		if(n>=10 || n<0)
			return false;
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(12));
	}

}
