package com.ib.twopointers;

import java.util.List;
import java.util.Arrays;

public class Sort012 {
	
	private static List<Integer> sort(List<Integer> a){
		int n = a.size();
		if(n==1)
			return a;
		int i=0;
		
		for(int j=n-1; i<=j; j--){ 
			while(i<n && a.get(i)==0)
				i++;
			if(a.get(j) == 0){				
				int temp = a.get(j);
				a.set(j, a.get(i));
				a.set(i, temp);
				i++;
			}
		}
		
		for(int k=i, j = n-1; k<=j; k++){ 
			while(j>=0 && a.get(j)==2)
				j--;
			if(a.get(k) == 2){				
				int temp = a.get(j);
				a.set(j, a.get(k));
				a.set(k, temp);
				j--;
			}
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sort(Arrays.asList(2,0,2,1,1,1,0,0,0,2,1,0,0,2,1,2,0,0,0, 1)));
	}

}
