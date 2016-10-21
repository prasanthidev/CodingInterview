package com.ib.bits;

import java.util.ArrayList;

public class SingleNumber {

	private static int singleNumber(ArrayList<Integer> a) {
		int n = 0;
		for(int i=0; i<a.size(); i++){
			n = (n ^ a.get(i));
		}
		return n;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}

}
