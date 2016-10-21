package com.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RepeatedNumber {
	public static void main(String args[]){
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1967513926);
		a.add(1540383426);
		a.add(-1303455736);
		a.add(-521595368);
		//a.add(-745);
		//a.add(0);
		//a.add(0);
		
		maxset(a);
	}
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
	     ArrayList<Integer> resultArray = new ArrayList<Integer>(a.size());
	     ArrayList<Integer> maxResultArray = new ArrayList<Integer>(a.size());
	     
	     long sum = 0;
	     long maxSum = 0;
	     
	     int numberOfElements = 0;
	     int maxNumberOfElements = 0;
	     
	     for(int i=0;i< a.size(); i++){
	    	 int element = a.get(i);
	    	 if(element < 0){
	    		 if(sum == 0 && maxSum > 0){
	    			 continue;
	    		 }
	    		 if(maxSum < sum || (maxSum == sum && maxNumberOfElements < numberOfElements)){
	    			 maxSum = sum;
	    			 maxNumberOfElements = numberOfElements;
	    			 maxResultArray.clear();
	    			 maxResultArray.addAll(resultArray);
	    		 }
	    		 numberOfElements = 0;
	    		 resultArray.clear();
	    		 sum = 0;
	    	 }
	    	 else{
	    		 numberOfElements++;
	    		 sum = sum + element;
	    		 resultArray.add(element);
	    	 }
	     }
	     if(maxSum < sum || (maxSum == sum && maxNumberOfElements < numberOfElements)){
			 maxResultArray.clear();
			 maxResultArray.addAll(resultArray);
		 }
	     return maxResultArray;
	}
	public ArrayList<Integer> repeatedNumber2(final List<Integer> a) {
	    boolean[] isElementPresent = new boolean[a.size()];
	    for(int i=0; i< a.size(); i++){
	    	int element = a.get(i);
	    	isElementPresent[element - 1] = true;
	    }
	    int missingElement = 0;
	    int repeatedElement = 0;
	    for(int i=0; i< a.size();i++){
	    	if(!isElementPresent[i]){
	    		missingElement = i +1;
	    		break;
	    	}
	    }
	    
	    for(int i=0; i< a.size(); i++){
	    	int element = a.get(i);
	    	isElementPresent[element - 1] = ! isElementPresent[element - 1];
	    }
	    for(int i=0; i< a.size();i++){
	    	if(isElementPresent[i]){
	    		repeatedElement = i +1;
	    		break;
	    	}
	    }
	    
	    System.out.print(repeatedElement);
	    System.out.print(missingElement);
	    ArrayList<Integer> value = new ArrayList<Integer>();
	    value.add(repeatedElement);
	    value.add(missingElement);
	    return value;
	}
	
	private int findtheNumber(List<Integer> b, int i, int size) {
		if(size == 1)
			return b.get(0);
		int n = (i+size)/2;
		
		return 0;
		
	}
	
	
}
