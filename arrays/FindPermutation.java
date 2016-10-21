package com.ib.arrays;

import java.util.ArrayList;

public class FindPermutation {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public static ArrayList<Integer> findPerm(final String A, int B) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	int I_COUNT = 0;
    	int D_COUNT = 0;
    	for(int i=0; i<B-1; i++){
    		if(A.charAt(i)=='I')
    			I_COUNT++;
    		else
    			D_COUNT++;
    	}
    	if(I_COUNT == B-1){
    		for(int i=0;i<B;i++)
    			result.add(i+1);
    	}
    	else if(D_COUNT == B-1){
    		for(int i=0;i<B;i++)
    			result.add(B-i);
    	}
    	else{
    		int beginInt = B - I_COUNT;
    		result.add(beginInt);
    		int next_Idigit = beginInt;
    		int next_Ddigit = beginInt-1;
    		for(int i=0;i<B-1;i++){
    			if(A.charAt(i)=='I')
    				result.add(++next_Idigit);
    			else
    				result.add(next_Ddigit--);
    		}    		
    	}
		return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//final String A = "IIIDDDDDDDDIDDDIDDIIDDDDDDIIIIDIIIDDDIDIIIDDDIDDDDDDIIIDDDIIDDIIDIDIIIDIDIDIIIDDIIIIIDIIIIIDDIDDIDDDDIDIIDDIDIIDDIID";
		//int B = 117;
		final String A = "IIIDDDD";
		int B = 8;
		System.out.println(findPerm(A,B));
	}

}
