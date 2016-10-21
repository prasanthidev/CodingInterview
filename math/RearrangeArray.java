package com.ib.math;

import java.util.ArrayList;

public class RearrangeArray {

	private static ArrayList<Integer> reArrange(ArrayList<Integer> a){
		int n = a.size();
		for(int i=0; i<n; i++){
			int x = a.get(i);
			int y = a.get(x);
			int z = x + (y%n)*n;
			a.set(i, z);
		}
		
		for(int i=0; i<n; i++){
			int x = a.get(i);
			a.set(i, x/n);
		}
		return a;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
