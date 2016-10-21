package com.ib.arrays;

import java.util.ArrayList;

public class MaxNonNegativeSubArray {
	
	private static ArrayList<Integer> MaxSubArray(ArrayList<Integer> a) {
		int n=a.size();
		int startIndex=0, endIndex=0, length=0;
		long sum=0, maxSum=0;		
		int tempSI=0, tempEI=0, templength=0;
		long tempSum=0;
		
		for(int i=0; i<n; i++){
			sum += a.get(i);
			if(maxSum>=sum && tempSum<=maxSum && templength<length){								
				if(a.get(i)<0){
					endIndex=i-1;				
					tempSI=startIndex;
					tempEI=endIndex;
					tempSum=maxSum;
					templength=length;					
				}
				if(maxSum>sum){
					startIndex=i+1;				
					sum=0; maxSum=0; length=0;
				}
			}else{
				endIndex=i; length++;
				maxSum=sum;
			}
		}
		if(tempSum<=maxSum){
			tempSI=startIndex;
			tempEI=endIndex;
		}
		
		ArrayList<Integer> b = getSubArray(a, tempSI, tempEI);
		return b;
	}
	
	private static ArrayList<Integer> getSubArray(ArrayList<Integer> a, int tempSI, int tempEI) {
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int i=tempSI; i<=tempEI; i++){
			if(a.get(i)>=0)
				b.add(a.get(i));
		}
		return b;
	}

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		//a.add(0);  a.add(1); a.add(-1); a.add(0);  a.add(0); a.add(1); a.add(0); a.add(1); a.add(5); a.add(0); a.add(-2); 
		//[ 756898537, -1973594324, -2038664370, -184803526, 1424268980 ]
		//a.add(-75689853); a.add(-1973594324); a.add(-2038664370); a.add(-184803526); a.add(-1424268980);
		//a.add(1); a.add(5); a.add(0);  a.add(1); a.add(-1); a.add(0);  a.add(0); a.add(1); a.add(1); a.add(5); a.add(0);  a.add(1); a.add(-1); a.add(0);  a.add(0); a.add(1);
		a.add(0);a.add(0);a.add(-1);a.add(0);
		ArrayList<Integer> result = MaxSubArray(a);
		System.out.println(result.toString());
	}

}
