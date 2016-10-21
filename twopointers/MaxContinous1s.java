package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxContinous1s {

	public static ArrayList<Integer> maxone(ArrayList<Integer> a, int k) {
		int start = 0, count = 0, zeroPtr = -1;
		int maxStart = 0, maxCount = 0;
		int flips = k;
		int n = a.size();
		int i = 0;
		if(k==0){
			for(int j=0; j<n; j++){
				if(a.get(j)==1){
				    if(start == 0)
				        start = j;
					count++;
				}
				else{
					if(maxCount<count){
					    maxStart = start;
						maxCount = count;
					}
					count = 0;
					start = 0;
				}
			}
			if(count > maxCount){
			    maxStart = start;
				maxCount = count;
			}
		}else{
			for(; i<n; i++){
				if(a.get(i) == 1){
					if(i+1 < n && zeroPtr == -1 && a.get(i+1) == 0)
						zeroPtr = i+1;
					count++;
				}else{
					if(flips == 0){
						if(maxCount < count){
							maxStart = start;
							maxCount = count;
						}
						if(zeroPtr == -1){
							while(i<n && a.get(i) != 1)
								i++;
							i--;
							start = i;
						}else{
							i = start = zeroPtr;							
							zeroPtr = -1;						
						}
						count = 0;
						flips = k;
					}else{
						flips--;
						count++;
					}
				}
			}
			if(count > maxCount){
				maxCount = count;
				maxStart = start;
			}
		}
		ArrayList<Integer> b = new ArrayList<Integer>();
		for(int j=0; j<maxCount; j++)
			b.add(maxStart + j);
			
		return b;
	}	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> a = Arrays.asList( 1, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0 );
		ArrayList<Integer> b = new ArrayList<Integer>();
		b.addAll(a);
		System.out.println(maxone(b, 4));
		
	}

}
