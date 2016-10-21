package com.ib.twopointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KthSmallestNumber {

	public static int kthsmallest2(final List<Integer> a, int k) {
		int n = a.size();
		for(int i=0; i<n; i++){
			for(int j=n-1; j>i; j--){
				if(a.get(j-1)>a.get(j)){
					int temp = a.get(j);
					a.set(j, a.get(j-1));
					a.set(j-1, temp);
				}
			}
		}
		return a.get(k-1);
	}
	
	public int kthsmallest3(final List<Integer> a, int k) {
	    int n = a.size();
		int temp1 = Integer.MAX_VALUE, temp2 = -1;
		int index = 0;
		while(index < n){
			for(int j=n-1; j>=0; j--){
				if(a.get(j)<temp1 && temp2<=a.get(j)){
					temp2 = a.get(j);
				}
			}
			if(temp2==-1)
				break;
			index += Collections.frequency(a, temp2);			
			if(index >= n-k+1)
				return temp2;
			temp1 = temp2;
			temp2=-1;
		}
		return temp2;
	}
	
	public static int kthsmallest(final List<Integer> a, int k) {
		int n = a.size();
		int temp1 = Integer.MAX_VALUE, temp2 = -1;
		int temp3 = Integer.MIN_VALUE, temp4 = temp1;
		int index1 = 0, index2 = 0;
		while(index1 < n && index2 < n){
			for(int j=n-1; j>=0; j--){
				if(a.get(j)<temp1 && temp2<a.get(j)){
					temp2 = a.get(j);
				}
				if(a.get(j)>temp3 && temp4>a.get(j)){
					temp4 = a.get(j);
				}
			}
			if(temp2==-1)
				break;
			index1 += Collections.frequency(a, temp2);			
			if(index1 >= n-k+1)
				return temp2;
			index2 += Collections.frequency(a, temp4);			
			if(index2 >= k)
				return temp4;
			temp1 = temp2;
			temp3 = temp4;
			temp2=-1;
			temp4=Integer.MAX_VALUE;
		}
		return temp2;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(kthsmallest(Arrays.asList(60, 94, 63, 3, 86, 40, 93, 36, 56, 48, 17, 10, 23, 43, 77, 1, 1, 93, 79, 4, 10, 47, 1, 99, 91, 53, 99, 18, 52, 61, 84, 10, 13, 52, 3, 9, 78, 16, 7, 62), 22));
		System.out.println(kthsmallest(Arrays.asList(8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92), 9));
		//System.out.println(kthsmallest(Arrays.asList(2,1,3,2,4),3));
	}

}
