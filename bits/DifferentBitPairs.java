package com.ib.bits;

import java.util.Arrays;
import java.util.List;

public class DifferentBitPairs {

	public static int cntBits(List<Integer> a){
        int sum = 0;
        int n = a.size();
        for(int i=0; i<31; i++){
            int count = 0;
            for(int j=0; j<n; j++){
                if((a.get(j) & (0x01 << i)) != 0)
                    count ++;
            }
            sum += count * (n-count) * 2;
        }
		return sum;
    }
	
	private static long sumOfPairs(List<Integer> a){
		long sum = 0;
		for(int i=0; i<a.size(); i++){
			for(int j=i+1; j<a.size(); j++){
				sum += findDifferentBits(a.get(i), a.get(j));
			}
		}
		if(sum > Integer.MAX_VALUE/2)
			sum = 2*(sum % (int)Math.pow(10, 9)) + 7;
		else
			sum = 2*sum;
		return sum;
	}
	private static long findDifferentBits(int a, int b) {
		int count = 0;
		while(a>0 || b>0){
			if((a & 0x01) != (b & 0x01)){
				count++;
			}
			a = a >> 1;
			b = b >> 1;
		}
		return count;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(cntBits(Arrays.asList(1,3,5)));

	}

}
