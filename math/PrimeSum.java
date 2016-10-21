package com.ib.math;

import java.util.ArrayList;

public class PrimeSum {
	
	private static int isPrime(int A) {
	    if(A==1 || A==0)
	    return 0;
		int upperLimit = (int)(Math.sqrt(A));
		for (int i = 2; i <= upperLimit; i++) {
			if (A % i == 0) return 0;
		}
		return 1;
	}
	
	private static ArrayList<Integer> primeSum(int N){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i=2; i<=N; i++){
			if(isPrime(i) == 1 && isPrime(N-i) == 1){
				result.add(i);
				result.add(N-i);
				break;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(primeSum(90));
		
		
	}

}
