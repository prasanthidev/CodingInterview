package com.ib.twopointers;

import java.util.Hashtable;

public class LongestRepeatingChar {

	 public static int characterReplacement(String s, int k) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        if(n == 1)
            return 0; 
        // count max occurred letter in the string
        Hashtable<Integer, Integer> letterHash = new Hashtable<Integer, Integer>();
        int count = 0;
        for(int i=0; i<n; i++){
            int index = (int) ch[i] - 65;
            if(!letterHash.containsKey(index)){
                letterHash.put(index, 1);
            }
            else{
                count = letterHash.get(index);
                letterHash.put(index, count+1);
            }
        }
        // get the max occurred letter (if any)
        char max_occ_letter = 0;
        count = 0;
        for(int i=0; i<letterHash.size(); i++){
            int c = letterHash.get(i);
            if(count < c){
                count = c;
                max_occ_letter = (char)(65 + i);
            }
        }
        // if k==0 return the max substr
        if(k==0){
	        count = 0;
	        for(int i=0; i<n; i++){
	        	if(ch[i] == max_occ_letter){
	        		int c = 0;
	        		while(i<n && ch[i] == max_occ_letter){
	        			c++; i++;
	        		}
	        		if(c>count)
	        			count = c;
	        	}
	        }
	        return count;
        }
        
        // similar to flip 0s and 1s
        int flips = k;
        int start = -1;
        int max_count = 0;
        count = 0;
        int ptr = 0;
        for(int i=0; i<n; i++){
            if(ch[i] == max_occ_letter){
                if((i==0 || ch[i-1] != max_occ_letter) && start == -1){
                   ptr = i-1;
                   start = i;
                } count++;
            }else{
            	flips--;
            	count++;
            	if(flips == 0){
            		while(i+1<n && ch[i+1] == max_occ_letter){
            			count++;
            			i++;
            		}
            		if(max_count < count){
            			max_count = count;
            			start = -1;
            		}
            		count = 0;
            		flips = k;
            	}
            }
        }
        if(count > max_count){
        	max_count = count;
        }
        return max_count;
    }
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(characterReplacement("AAAAAABBBBCDBBBB", 2));
		System.out.println(characterReplacement("AAABKKDKKXXXYZAAA", 2));
	}

}
