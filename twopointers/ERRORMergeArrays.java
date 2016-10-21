package com.ib.twopointers;

import java.util.Arrays;

public class ERRORMergeArrays {

	/*
	 * Error in LeetCode
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeArrays(new int[]{}, 0, new int[]{1}, 1);
	}

	private static void mergeArrays(int[] a, int m, int[] b, int n) {
        a = Arrays.copyOf(a, m+n);	
		int i=m-1;
		int l = m+n-1;		
		int j=n-1; 
		if(i<0)
			a = Arrays.copyOfRange(b, 0, n);
		if(j<0)
			return;
		while(j>=0 && i>=0){
			if(a[i]<b[j]){
				a[l--] = b[j];
				j--;
			}else if(a[i] > b[j]){
				a[l--] = a[i];
				i--;
			}else{
				a[l--] = b[j];
				a[l--] = a[i];
				i--; j--;
			}
		}
		if(j>0){
			a = Arrays.copyOfRange(b, 0, j);
		}
		if(i>0){
			a = Arrays.copyOfRange(a, 0, i);
		}
        return;
		
	}

}
