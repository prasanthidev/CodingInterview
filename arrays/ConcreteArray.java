package com.ib.arrays;

import java.util.ArrayList;

public class ConcreteArray {
	public static ArrayList<ArrayList<Integer>> prettyPrint(int a) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int m, n;
		int size = a*2 + 1;
		m = n = size;
		for(int i=0; i<m; i++){
			res.add(new ArrayList<Integer>());
			for(int j=0; j<n; j++){
				res.get(i).set(j, 0);
			}
		}
		
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
