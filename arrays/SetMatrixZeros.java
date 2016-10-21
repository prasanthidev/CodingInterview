package com.ib.arrays;

import java.util.ArrayList;

public class SetMatrixZeros {
	
	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {
		int max_rows = a.size();
        int max_cols = a.get(0).size();
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> cols = new ArrayList<Integer>();
        for(int i=0; i<max_rows; i++){
        	if(!a.get(i).contains(0))
        		continue;
        	rows.add(i);
            for(int j=0; j<max_cols; j++){
                if(a.get(i).get(j) == 0 && !cols.contains(j)){
                    cols.add(j);
                }
            }
        }
        for(int l=0; l<rows.size(); l++){
            for(int i=0; i<max_cols; i++){
               a.get(rows.get(l)).set(i,0);
            }
        }
        for(int i=0; i<cols.size(); i++){
        	for(int l=0; l<max_rows; l++){ 
            	a.get(l).set(cols.get(i), 0);
            }
        }
	}
	
	public static void setZeroesOptimizeTimeComplexity(ArrayList<ArrayList<Integer>> a) {
		int max_rows = a.size();
        int max_cols = a.get(0).size();
        
        for(int i=0; i<max_rows; i++){
        	if(!a.get(i).contains(0))
        		continue;
        	a.get(i).set(0,0);
            for(int j=0; j<max_cols; j++){
                if(a.get(i).get(j) == 0){
                   a.get(0).set(j,0);
                }
            }
        }

        for(int j=0; j<max_cols; j++){
            if(a.get(0).get(j) == 0){
            	for(int i=0; i<max_rows; i++){    
                    a.get(i).set(j, 0);
                }
            }
        }  
        for(int i=0; i<max_rows; i++){        	
            if(a.get(i).get(0) == 0){
            	for(int j=0; j<max_cols; j++){
                    a.get(i).set(j, 0);
                }	
            }
        }  
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> b = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a1.add(0);a1.add(1);//a1.add(1);//a1.add(1);a1.add(1);a1.add(1);
		a2.add(1);a2.add(1);//a2.add(1);//a2.add(0);a2.add(1);a2.add(0);
		//a3.add(1);a3.add(0);a3.add(0);
		a.add(a1);
		a.add(a2);
		a.add(a3);
		b.add(a1);
		b.add(a2);
		//b.add(a3);
		//setZeroesOptimizeTimeComplexity(b);
		//System.out.println(b);
		setZeroes(a);
		System.out.println(a);
		
	}

}
