package com.ib.arrays;

import java.util.ArrayList;

public class RotateMatrix {
	
	public static void printrotateMatrixPlus90(ArrayList<ArrayList<Integer>> a){
		int max_rows = a.size();
		int max_cols = a.get(0).size();
		for(int j=max_cols-1; j>=0; j--){
			for(int i=0; i<max_rows; i++){
				System.out.print(a.get(i).get(j) + " ");
			}
			System.out.println();
		}		
	}
	
	public static void printrotateMatrix(ArrayList<ArrayList<Integer>> a){
		int max_rows = a.size();
		int max_cols = a.get(0).size();
		for(int j=0; j<max_cols; j++){
		    System.out.print(" [");
			for(int i=max_rows-1 ; i>=0; i--){		
				System.out.print( a.get(i).get(j) + " ");
			}
			System.out.print("]");
		}
	}
	
	public static void rotateMatrix(ArrayList<ArrayList<Integer>> a){
		int max_rows = a.size();
		int max_cols = a.get(0).size();
		for(int j=0; j<max_cols; j++){
			for(int i=0; i<max_rows/2; i++){	
				int temp = a.get(i).get(j);
				a.get(i).set(j, a.get(max_rows-i-1).get(j));
				a.get(max_rows-i-1).set(j, temp);
			}
		}
		for(int i=0; i<max_rows; i++){
			for(int j=i; j<max_cols; j++){
				int temp = a.get(i).get(j);
				a.get(i).set(j, a.get(j).get(i));
				a.get(j).set(i, temp);
			}
		}
	}
	
	public static ArrayList<ArrayList<Integer>> rotateMatrixPlus90(ArrayList<ArrayList<Integer>> a){
		int max_rows = a.size();
		int max_cols = a.get(0).size();
		ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
		for(int j=max_cols-1, k=0; j>=0 && k<max_cols; j--, k++){
			b.add(k, new ArrayList<Integer>());
			for(int i=0 ; i<max_rows; i++){				
				b.get(k).add(i, a.get(i).get(j));
				System.out.print(b.get(k).get(i) + " ");
			}
			System.out.println();
		}
		return b;
	}

	public static void testCase1(){
		System.out.println("Executing test Case 1 [4*3]");
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		ArrayList<Integer> a4 = new ArrayList<Integer>();
		
		a1.add(1);a1.add(2);a1.add(3);
		a2.add(4);a2.add(5);a2.add(6);
		a3.add(7);a3.add(8);a3.add(9);
		a4.add(10);a4.add(11);a4.add(12);
		
		a.add(a1);
		a.add(a2);
		a.add(a3);
		a.add(a4);
		rotateMatrix(a);
	}
	
	public static void testCase2(){
		System.out.println("Executing test Case 1 [2*2]");
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		
		a1.add(3); a1.add(8);
		a2.add(91); a2.add(0);
		
		a.add(a1);
		a.add(a2);
		rotateMatrix(a);
	}
	
	public static void testCase3(){
		System.out.println("Executing test Case 1 [1*1]");
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		
		a1.add(9);
		
		a.add(a1);
		rotateMatrix(a);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCase1();
		testCase2();
		testCase3();
	}
	
}
