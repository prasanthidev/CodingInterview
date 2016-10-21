package com.ib.math;

public class TODOLargestCoprime {

	public class Solution{
		public int coPrime(int A, int B){
			int X = 1;
			for(int i = (int)Math.sqrt(A); i>1; i--){
				if(A%i == 0 && (gcd(i, B) || gcd(A/i, B))){
					X = i;
					break;
				}
			}
			return X;
		}
		
		private Boolean gcd(int X, int B){
			int i = 0;
			if(X == B)
				return false;
			if(X>B)
				i = B;
			else
				i = X;
			while(i>1){
				if(X%i == 0 && B%i == 0)
					return false;
				i--;
			}
			return true;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TODOLargestCoprime obj = new TODOLargestCoprime();
		Solution sol = obj.new Solution();
		System.out.println(sol.coPrime(30, 12));
	}

}
