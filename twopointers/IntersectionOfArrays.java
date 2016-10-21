package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntersectionOfArrays {

	public static ArrayList<Integer> findIntersection(List<Integer> a, List<Integer> b){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(b.size() == 0 || a.size() == 0)
			 return res;
        Collections.sort(a);
        Collections.sort(b);
		int i=0, j=0;
		while(j<b.size() && i<a.size()){
			if(a.get(i) == b.get(j)){
				res.add(a.get(i));
				i++; j++;
			}else if(a.get(i)>b.get(j))
				j++;
			else
				i++;
		}
		return res;
	}	
	
	public static int[] intersect(int[] a, int[] b) {
        int[] res = new int[0];
        if(b.length == 0 || a.length == 0)
		 return res;
        Arrays.sort(a);
        Arrays.sort(b);
        
        int k=0;
		int i=0, j=0;
		while(j<b.length && i<a.length){
			if(a[i] == b[j]){
			    res = Arrays.copyOf(res, k+1);
				res[k++] = a[i];
				i++; j++;
			}else if(a[i]>b[j])
				j++;
			else
				i++;
		}
		return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findIntersection(Arrays.asList(1, 2), Arrays.asList(2, 1)));
		System.out.println(intersect(new int[]{1,2}, new int[]{2,1}));
	}

}
