package com.ib.bits;

import java.util.Arrays;
import java.util.List;

public class FindMissingOne {

	private static int findMissing(List<Integer> a){
		int[] ones = new int[32];
		
		for(int i=0; i<a.size(); i++){
			int x = a.get(i);
			int itr = 0;
			while(x > 0){
				int digit = x%2;
				if(digit == 1){
					ones[itr]++;
				}
				x = x/2;
				itr++;
			}
		}
		
		int ans = 0;
		for(int i=0; i<32; i++){
			if(ones[i] % 3 != 0){
				ans += Math.pow(2, i);				
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(3,4,4,1,3,1,3,1,4,90);
		System.out.println(findMissing(a));
	}

}
