package com.ib.math;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PowerOfTwoIntegers {
	public class Solution{
		public Solution(){}
		
		private HashMap<Integer, Integer> findFactors(int N, HashMap<Integer, Integer> hash){
			
			int n = (int)Math.sqrt(N);
			int count = 0;
			for(int i=2; i<=n; i++){
				if(N%i == 0){
					if(!hash.containsKey(i))
						hash.put(i, 0);
					hash.put(i, hash.get(i) + 1);
					hash = findFactors(N/i, hash);
					count++;
					break;
				}	
			}
			if(count == 0){
				if(!hash.containsKey(N))
					hash.put(N, 0);
				hash.put(N, hash.get(N) + 1);
			}
			return hash;
		}
		
		@SuppressWarnings("rawtypes")
		public Boolean power(int N){	
			if(N==1)
				return true;
			HashMap<Integer, Integer> hash =  new HashMap<>();			
			int gcd = 0;
			
			hash = findFactors(N, hash);
			
			Iterator it = hash.entrySet().iterator();			
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        int power = (int)pair.getValue();
		        gcd = findGCD(gcd, power);
		    }
		    
		    it = hash.entrySet().iterator();			
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        int power = (int)pair.getValue();
		        if((power - gcd) % 2 != 0)
		        	return false;
		    }
		    
		    if(gcd == 1)
		    	return false;
		    
		    return true;
		}

		private int findGCD(int a, int b){
			int n = 1, gcd = 1;
			if(a==0 || b==0)
				return a|b;
			if(a==b)
				return a;
			else if(a>b)
				n = b;
			else
				n = a;
			for(int i=1; i<=n; i++){
				if(a%i==0 && b%i==0){
					gcd = i;
				}
			}
			return gcd;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PowerOfTwoIntegers p = new PowerOfTwoIntegers();
		Solution s = p.new Solution();
		System.out.println(s.power(524288));
	}
}
