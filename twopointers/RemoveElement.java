package com.ib.twopointers;

import java.util.Arrays;
import java.util.List;

public class RemoveElement {
	
	public static int removeElement(int[] a, int val) {
        int index = 0;
		for(int i=0; i<a.length; i++){
			if(a[i] == val){
				while(i<a.length && a[i] == val)
					i++;
				if(i == a.length)
					break;
			}
			a[index++] = a[i];
		}
		return index;
    }
	
	public static int removeElement(List<Integer> a, int val) {
        int index = 0;
		for(int i=0; i<a.size(); i++){
			if(a.get(i).equals(val)){
				while(i<a.size() && a.get(i).equals(val))
					i++;
				if(i == a.size())
					break;
			}
			a.set(index++, a.get(i));
		}
		return index;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeElement(Arrays.asList(3,2,2,3), 3));
		System.out.println(removeElement(new int[]{3,2,2,3}, 3));
	}

}
