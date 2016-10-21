package com.ib.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Sum3Zero {

	/**
	 * 
	 * @author KH1851
	 * Set is a collection that contains no duplicate elements and 
	 * inserting/searching is much faster than searching in a list
	 * 
	 */
	public class Solution{
	
		public ArrayList<ArrayList<Integer>> ThreeSum(List<Integer> a){
			int n = a.size();		
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			HashSet<String> hashset = new HashSet<String>();
			int sum = 0;
			String s = "";
			Collections.sort(a);
			for (int i=0;i<n-2;i++) {
	            int j = i+1;
	            int k = n-1;
	            while (j < k) {
	            	int s1 = a.get(i); int s2 = a.get(j); int s3 = a.get(k);
	            	sum = s1 + s2 + s3;
	            	if(sum == 0){
	            	    s = s1+""+s2+""+s3;
	            		ArrayList<Integer> triplet = new ArrayList<Integer>();
						triplet.add(s1); triplet.add(s2); triplet.add(s3);
						if(!hashset.contains(s))
							res.add(triplet);
						j++;k--;
						hashset.add(s);
	            	}else if(sum > 0)
	            		k--;
	            	else if(sum < 0)
	            		j++;
	            }
			 }
			return res;
		}
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sum3Zero obj = new Sum3Zero();
		Solution sol = obj.new Solution();
		System.out.println(sol.ThreeSum(Arrays.asList(12,5,-12,4,-11,11,2,7,2,-5,-14,-3,-3,3,2,-10,9,-15,2,14,-3,-15,-3,-14,-1,-7,11,-4,-11,12,-15,-14,2,10,-2,-1,6,7,13,-15,-13,6,-10,-9,-14,7,-12,3,-1,5,2,11,6,14,12,-10,14,0,-7,11,-10,-7,4,-1,-12,-13,13,1,9,3,1,3,-5,6,9,-4,-2,5,14,12,-5,-6,1,8,-15,-10,5,-15,-2,5,3,3,13,-8,-13,8,-5,8,-6,11,-12,3,0,-2,-6,-14,2,0,6,1,-11,9,2,-3,-6,3,3,-15,-5,-14,5,13,-4,-4,-10,-10,11)));
	}

}
