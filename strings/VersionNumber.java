package com.ib.strings;

import java.util.ArrayList;

public class VersionNumber {
	private static int compareVersion(String a, String b){
		if(a.equals(b))
			return 0;
		
		String[] v1 = a.split("[.]");
		String[] v2 = b.split("[.]");
		int noOfSamedigits = 0;		
		int[] compareStrings = new int[Math.max(v1.length, v2.length)];
				
		for(int i=0; i<v1.length && i<v2.length; i++){
			int zeroCount = v1[i].length() - v2[i].length();
			if(zeroCount>0){
				for(int j=0; j<zeroCount; j++){
					v2[i] = '0' + v2[i];					
				}
			}else{
				for(int j=0; j<zeroCount*(-1); j++){
					v1[i] = '0' + v1[i];
				}
			}
			if(v1[i].compareTo(v2[i]) > 0)
				compareStrings[i] = 1;
			else if(v1[i].compareTo(v2[i]) == 0){
				noOfSamedigits++;
				compareStrings[i] = 0;
			} else
				compareStrings[i] = -1;
		}
		

		if(v1.length > v2.length){
			for(int i=v2.length; i<v1.length; i++){
				if(v1[i].compareTo("0") == 0){
					noOfSamedigits++;
					compareStrings[i] = 0;
				}else
					compareStrings[i] = 1;
			}
		}else{
			for(int i=v1.length; i<v2.length; i++){
				if(v2[i].compareTo("0") == 0){
					noOfSamedigits++;
					compareStrings[i] = 0;
				}else
					compareStrings[i] = -1;
			}
		}
		
		if((noOfSamedigits == v1.length && v1.length == v2.length) || (noOfSamedigits == v1.length && v1.length>v2.length) || (noOfSamedigits == v2.length && v2.length>v1.length))
			return 0;
		else {
			for(int i=0; i<compareStrings.length; i++){		
				if(compareStrings[i] == 1)
					return 1;
				else if(compareStrings[i] == -1)
					break;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> a = new ArrayList<String>();
		a.add("2.13");
		a.add("2.13.4");
		System.out.println(compareVersion("9","65.43.8.591.51.5"));
	}

}
