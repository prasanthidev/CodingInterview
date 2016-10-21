package com.ib.twopointers;

import java.util.ArrayList;

public class RemoveDuplicates {

	public static int removeDuplicates(int[] a) {
        int index=0;
        for(int j=0; j<a.length; j++){
        	while(j+1 < a.length && a[j] == a[j+1]){
        		j++;
        	}        	
    		a[index]=a[j];
    		index++;
        }
        
		return index;
    }
	
	public static int removeDuplicates(ArrayList<Integer> a) {
		int index=0;
        for(int j=0; j<a.size(); j++){
        	while(j+1 < a.size() && a.get(j).equals(a.get(j+1))){
        		j++;
        	}        	
    		a.set(index++, a.get(j));
        }
        for(int i=a.size()-1; i>=index; i--)
        	a.remove(i);
        return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();// 0, 0, 0, 1, 1, 2, 2, 3 
		a.add(0); a.add(0); a.add(0); //a.add(1); a.add(1); a.add(2); a.add(2); a.add(3); 
		System.out.println(removeDuplicates(a));
		System.out.println(removeDuplicates(new int[]{1,2,2,2,4,5,5,5,5,7,9,10}));
	}

}
