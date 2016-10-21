package com.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestNumber {
	public static boolean isTrue(){
		return true;
	}
	
	public static String LargestNumber(ArrayList<Integer> input){
		String result = "0";
		for(int i =0; i< input.size(); i++){
			int digit = input.get(i);
			int digitLength = String.valueOf(digit).length();
			int number = -1;
			if(digitLength > result.length()){
				number = Integer.parseInt(result);
				int digit1 = Integer.parseInt(String.valueOf(digit).substring(0, result.length()));
				if(number == digit1){
					int nextdigit = Integer.parseInt(String.valueOf(digit).substring(result.length(), result.length()));
					int firstDigit = Integer.parseInt(String.valueOf(number).substring(0, 0));
					if(nextdigit > firstDigit){
						result = digit + result;
					}else{
						result = result+digit;
					}
					continue;
				}
				if(number > digit1){
					if(number == 0){
						result = digit + "";
						continue;
					}
					result = result + digit;
				}else{
					if(number == 0){
						result = digit + "";
						continue;
					}
					result = digit + result;
				}
			}else{
				
				try{
					number = Integer.parseInt(result.substring(0, digitLength));
					
					if(number == digit){
						int nextdigit = Integer.parseInt(String.valueOf(number).substring(digitLength, digitLength));
						int firstDigit = Integer.parseInt(String.valueOf(digit).substring(0, 0));
						if(nextdigit > firstDigit){
							result = result + digit;
						}else{
							result = digit+result;
						}
						continue;
					}
					
					if(number >= digit){
						if(number == 0){
							result = digit + "";
							continue;
						}
						result = result + digit;
					}else{
						if(number == 0){
							result = digit + "";
							continue;
						}
						result = digit + result;
					}
				}catch(Exception e){
					result = result + digit;
					continue;
				}
				
			}
		}
		return result;
	}
	
	public static String largestNumber(final List<Integer> a) {
		long sum = a.get(0);
		for(int i =1; i< a.size(); i++){
			int val = a.get(i);
			
			
			long option1 = sum * power(10, String.valueOf(val).length()) + val;
			long option2 = val * power(10, String.valueOf(sum).length()) + sum;
			
			if(option1 >= option2){
				sum = option1;
			}
			else{
				sum = option2;
			}
		}
		
		return sum + "";
		
	}
	public static Integer power(int base, int exponent){
		if(exponent == 0){
			return 1;
		}
		int val = base;
		for(int i=0; i< exponent - 1; i++){
			val = val *base;
		}
		return val;
	}
	
	public static String largestNumber2(final List<Integer> a){
		ArrayList<ArrayList<Integer>> hashMap = new ArrayList<ArrayList<Integer>>(); 
		String result = "";
		for(int i=0; i<10; i++){
			hashMap.add(new ArrayList<Integer>());
		}
		for(int i=0; i<a.size(); i++){
			int placeValue = highestPlaceValue(a.get(i));
			ArrayList<Integer> b = hashMap.get(placeValue);
			b.add(a.get(i));
			hashMap.set(placeValue, b);
		}
		for(int k=0; k<10; k++){
			ArrayList<Integer> bucket = hashMap.get(k);
			if(bucket != null){
				int N = bucket.size();
				for(int i=0;i<N-1;i++){
					for(int j=0;j<N-1;j++){
						if(bucket.get(j)>bucket.get(j+1)){
							int temp = bucket.get(j);
							bucket.set(j, bucket.get(j+1));
							bucket.set(j+1, temp);
						}						
					}
				}
				for(int i=bucket.size()-1; i>=0; i--){
					result = result + bucket.get(i);					
				}
				if(bucket.get(0)<10){
					result = bucket.get(0) + result;
				}
			}			
		}		
		return result;
	}
	
	private static int highestPlaceValue(int value) {
		// TODO Auto-generated method stub
		
		return 0;
	}
	public static void main(String args[]){
		
		
		List<Integer> number = new ArrayList<Integer>();
		number.add(8);
		number.add(89);
		String result = largestNumber2(number);
		System.out.println(result);
		
		
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(3);
		input.add(30);
		input.add(34);
		input.add(5);
		input.add(9);
		String result1 = LargestNumber(input);
		System.out.println(result1);
	}

}
