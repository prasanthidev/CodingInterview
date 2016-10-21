package com.ib.math;

import java.util.ArrayList;

public class AllFactors {
	public static ArrayList<Integer> allFactors(int N) {
	    ArrayList<Integer> res =  new ArrayList<Integer>();
	    int n = (int)Math.sqrt(N);
	    int len = 0;
		for(int i=1; i<=n; i++){
			if(N%i == 0){
			    res.add(i);
			}
			if(n*n == N && N%i == 0 && i==n){
				len = -1;
			}
		}
		
		len = res.size()-1 + len;
		
		for(int i=len; i>=0; i--){
		    int num = N/res.get(i);
		    res.add(num);
		}
		
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(allFactors(41));
	}

}
