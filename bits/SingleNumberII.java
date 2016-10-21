package com.ib.bits;

import java.util.Arrays;
import java.util.List;

public class SingleNumberII {

	private static int findNumber(List<Integer> a){
		int missing = 0;
		int[] oneCount = new int[32];
		for(int i=0; i<a.size(); i++){
			oneCount = getBitCount(oneCount, a.get(i));
		}
		for(int i=31; i>=0; i--){
			if(oneCount[i] % 3 != 0){
				missing = missing + (int)Math.pow(2, 31 - i);
			}
		}
		return missing;
	}
	
	private static int[] getBitCount(int[] oneCount, int n) {
		int index = 31;
		while(n>0){
			if((n & 0x01) == 1){
				oneCount[index] += 1;
			}
			n = n>>1;
			index--;
		}
		return oneCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList(3,1,3,4,3,4,4,1,1,100);
		System.out.println(findNumber(a));
	}

}
