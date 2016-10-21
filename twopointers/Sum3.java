package com.ib.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sum3 {
	
	public static int threeSumClosest(int[] a, int target) {
        int n = a.length;		
        int result1 = Integer.MIN_VALUE, result2 = Integer.MAX_VALUE;
		int sum = 0;
		Arrays.sort(a);
		for (int i=0;i<n-2;i++) {
            int j = i+1;
            int k = n-1;
            while (j < k) {
            	int s1 = a[i]; int s2 = a[j]; int s3 = a[k];
            	sum = s1 + s2 + s3;
            	if(sum ==  target){
					return target;
				}else if(sum < target){
					if(sum>result1)
						result1 = sum;
					j++;
				}else if(sum > target){
					if(sum<result2)
						result2 = sum;
					k--;
				}
            }
		}
		
		if(result1 == Integer.MIN_VALUE)
			return result2;
		if(result2 == Integer.MAX_VALUE)
			return result1;
		return ((target - result1) < (result2 - target) ? result1 : result2);
    }
	
	private static int ThreeSum(List<Integer> a, int target){
		int n = a.size();		
		int result1 = Integer.MIN_VALUE, result2 = Integer.MAX_VALUE;
		int sum = 0;
		Collections.sort(a);
		for(int i=0; i<n-2; i++) {
            int j = i+1;
            int k = n-1;
            while (j < k) {
            	int s1 = a.get(i); int s2 = a.get(j); int s3 = a.get(k);
            	sum = s1 + s2 + s3;
				if(sum ==  target){
					return target;
				}else if(sum < target){
					if(sum>result1)
						result1 = sum;
					j++;
				}else if(sum > target){
					if(sum<result2)
						result2 = sum;
					k--;
				}
            }
		}
		
		if(result1 == Integer.MIN_VALUE)
			return result2;
		if(result2 == Integer.MAX_VALUE)
			return result1;
		return ((target - result1) < (result2 - target) ? result1 : result2);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(ThreeSum(Arrays.asList(0,1,2), 0));
		System.out.println(threeSumClosest(new int[]{0,1,2}, 0));
	}

}
