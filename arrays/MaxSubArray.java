package com.ib.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxSubArray {
	private static int MSS(ArrayList<Integer> a,int m, int index){
		if(index == 1)
			return a.get(0);
		int leftSum = Integer.MIN_VALUE, rightSum = Integer.MIN_VALUE;
		int sum=0;
		int midIndex = index/2;
		int leftMSS = MSS(a,0, midIndex);
		int rightMSS = MSS(a, midIndex, index-midIndex);
		for(int i=(m-1); i>=0; i--){
			sum += a.get(i);
			leftSum = Math.max(sum, leftSum);
		}
		sum=0;
		for(int i=m; i<index; i++){
			sum += a.get(i);
			rightSum = Math.max(sum, rightSum);
		}
		int max =  Math.max(leftMSS, rightMSS);
		return Math.max(max, rightSum+leftSum);
	}

	private static int maxSubArraySum(ArrayList<Integer> a) {
		int max = MSS(a,0, a.size());
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1); a.add(-7); a.add(1); a.add(5); a.add(-2);
		
		int sum = maxSubArraySum(a);
		System.out.println(sum);
	}

}
