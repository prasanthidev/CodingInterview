package com.ib.arrays;

import java.util.ArrayList;

public class FirstMissingInteger {

	public static int firstMissingPositive(ArrayList<Integer> a) {			
		int N = a.size();
		int missingInt = 0;
		boolean[] hash = new boolean[N];
		for(int i=0; i<N; i++)
			hash[i] = false;
		
		for(int i=0; i<N; i++){
	    	if(a.get(i)>N || a.get(i)<1)
	    		continue;
	    	hash[a.get(i)-1] = true;
	    }
		for(int i=0; i<N; i++){
			if(!hash[i]){
				missingInt = i+1;
				break;
			}
		}
		if(missingInt == 0)
		    missingInt = N+1;
	    return missingInt;
	}
	
	public static int firstMissingPositiveSpaceComplexity(ArrayList<Integer> a) {			
		int N = a.size();
		int missingInt = 0;
		for(int i=0; i<N; i++){
	    	if(a.get(i)<N && a.get(i)>0){
	    		int posIndex = a.get(i);
	    		int posValue = a.get(posIndex-1);
	    		if(posIndex != posValue){
	    			a.set(i, posValue);
	    			a.set(posIndex-1, posIndex);
	    		}
	    	}
	    		
	    }
		for(int i=0; i<N; i++){
			if(a.get(i)-1 != i){
				missingInt = i+1;
				break;
			}
		}
		if(missingInt == 0)
		    missingInt = N+1;
	    return missingInt;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(6);a1.add(2);a1.add(3); a1.add(1);a1.add(5);a1.add(4);
		System.out.println(firstMissingPositive(a1));
		System.out.println(firstMissingPositiveSpaceComplexity(a1));
	}

}
