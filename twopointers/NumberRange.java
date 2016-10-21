package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberRange {

	public static int numRange(ArrayList<Integer> a, int b, int c) {
		int count = 0;
		int n = a.size();
		if(n == 1)
			return a.get(0)>= b && a.get(0)<=c ? 1 : 0;
		int sum = 0;
		for(int i=0; i<n; i++){
			if(a.get(i)>c)
				continue;
			
			sum = a.get(i);
			for(int j=i+1; j<n;){
				do{
					sum += a.get(j++);
				}while(j<n && sum < b);
				
				if(sum >= b && sum <= c){
					count++;
				}else {
					break;
				}
			}
		}
		System.out.println(sum);
		return count;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(Arrays.asList(76, 22, 81, 77, 95, 23, 27, 35, 24, 38, 15, 90, 19, 46, 53, 6, 77, 96, 100, 85, 43, 16, 73, 18, 7, 66));
		System.out.println(numRange(a, 98, 290));
		a.clear();
		a.addAll(Arrays.asList(9, 91, 73, 89, 36, 14, 93, 29, 63 ));
		System.out.println(numRange(a, 20, 60));
	}

}
