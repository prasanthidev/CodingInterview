package com.ib.arrays;

import java.util.ArrayList;

public class Diagonals {
	
	private static ArrayList<ArrayList<Integer>> PrintDiagonal(ArrayList<ArrayList<Integer>> a) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
				
		int columns = a.get(0).size();
		int rows = a.size();
		for(int k=0; k<columns ;k++){
			row = new ArrayList<Integer>();
			for(int j=k, i=0; j>=0 && i<rows; j--,i++){
				int val = a.get(i).get(j);
				row.add(val);
			}
			result.add(row);			
		}
		for(int k=1; k<rows; k++){
			row = new ArrayList<Integer>();
			for(int i=k, j=columns-1; i<rows && j>=0; i++,j--){
				int val = a.get(i).get(j);
				row.add(val);
			}
			result.add(row);
		}
		return result;
	}
	 
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> b1 = new ArrayList<Integer>();
		ArrayList<Integer> b2 = new ArrayList<Integer>();
		ArrayList<Integer> b3 = new ArrayList<Integer>();
		//ArrayList<Integer> b4 = new ArrayList<Integer>();
		b1.add(1);b1.add(2);b1.add(3);//b1.add(4);
		b2.add(5);b2.add(6);b2.add(7);//b2.add(8);
		b3.add(9);b3.add(10);b3.add(11);//b3.add(12);
		//b4.add(13);b4.add(14);b4.add(15);b4.add(16);
		a.add(b1);a.add(b2);a.add(b3);//a.add(b4);
		
		ArrayList<ArrayList<Integer>> c = PrintDiagonal(a);
		System.out.println(c.toString());
	}

}
