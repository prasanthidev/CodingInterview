package com.ib.arrays;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrderMatrix {
	// DO NOT MODIFY THE LIST
	private static ArrayList<Integer> SpiralOrder(List<ArrayList<Integer>> a) {
		 ArrayList<Integer> result = new ArrayList<Integer>();
		 int n = a.size()-1;
         int m = a.get(0).size()-1;
         int result_size = a.size() * a.get(0).size();         
         int index = 0, l=0;
         
         while(index<result_size){
         
            for(int i=l,j=l; j<=(m-l) && index<result_size; j++,index++)
                result.add(a.get(i).get(j));
            l++;
            for(int i=l,j=(m-l+1); i<=(n-l+1)  && index<result_size; i++,index++)
            	result.add(a.get(i).get(j));
                
            for(int i=(n-l+1),j=(m-l);j>=(l-1) && index<result_size; j--,index++)    
            	result.add(a.get(i).get(j));
                
            for(int i=(n-l),j=(l-1); i>=l && index<result_size; i--,index++)
				result.add(a.get(i).get(j));                    
         }
		 // Populate result;
		 return result;
	}
	
	public static void main(String[] args)
	{
		ArrayList<Integer> inner1 = new ArrayList<Integer>();
		inner1.add(0); inner1.add(1); inner1.add(2); inner1.add(3);
		ArrayList<Integer> inner2 = new ArrayList<Integer>();
		inner2.add(11); inner2.add(12); inner2.add(13); inner2.add(4);
		ArrayList<Integer> inner3 = new ArrayList<Integer>();
		inner3.add(10); inner3.add(15); inner3.add(14); inner3.add(5);
		ArrayList<Integer> inner4 = new ArrayList<Integer>();
		inner4.add(9); inner4.add(8); inner4.add(7); inner4.add(6);
		
		List<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(inner1); a.add(inner2); a.add(inner3); a.add(inner4);
		
		ArrayList<Integer> result = SpiralOrder(a);
		System.out.println(result);
		
	}

	
}
