package com.ib.arrays;

import java.util.ArrayList;

public class AddOne {

	private static ArrayList<Integer> plusOne2(ArrayList<Integer> a) {
		int n = a.size();
		ArrayList<Integer> b = new ArrayList<Integer>();
		
		
		int number = getNumberOfDigits(a);
		int plusOne = number + 1;
		
		String ans = String.valueOf(plusOne);
		//for(int i=0; i<ans.length();i++) b.add(((int) ans.charAt(i) - 48));
		
		int sum = 0, addOne=1;
		int carry = 0;
		for(int i=n-1; i>=0; i--){
			sum = a.get(i) + carry + addOne;
			if(sum>9) {
				b.add(0+carry); carry = 1;
			}else {
				b.add(sum); carry = 0;
			} addOne=0;			
		}
		if(carry == 1){
			b.add(1);
		}
		b = trimArrayList(b);
		b = reverseArrayList(b);
		
		return b;
		
	}
	private static ArrayList<Integer> plusOne(ArrayList<Integer> a) {
		int n = a.size();
		ArrayList<Integer> b = new ArrayList<Integer>();
		//for(int i=0;i<n;i++)b.add(i,0);
		
		int number = getNumberOfDigits(a);
		int plusOne = number + 1;
		
		String ans = String.valueOf(plusOne);
		//for(int i=0; i<ans.length();i++) b.add(((int) ans.charAt(i) - 48));
		
		int sum = 0, addOne=1;
		int carry = 0;
		for(int i=n-1; i>=0; i--){
			sum = a.get(i) + carry + addOne;
			if(sum>9) {
				b.add(0+carry); carry = 1;
			}else {
				b.add(sum); carry = 0;
			} addOne=0;			
		}
		
		
		return b;
	}
	private static ArrayList<Integer> reverseArrayList(ArrayList<Integer> b) {
		int n = b.size();
		for(int i=0;i<n/2;i++){
			int temp = b.get(i);
			b.set(i, b.get(n-i-1));
			b.set(n-i-1, temp);
		}
		return b;
	}
	private static ArrayList<Integer> trimArrayList(ArrayList<Integer> b) {
		for(int i=b.size()-1;i>=0;i--){
			if(b.get(i)!=0)
				break;
			b.remove(i);
		}
		return b;
	}
	private static int getNumberOfDigits(ArrayList<Integer> a) {
		int number = 0;
		for(int i=a.size()-1;i>=0;i--){
			number += a.get(i)*Math.pow(10, a.size()-i-1);
		}
		return number;
	}
	public ArrayList<Integer> plusOne3(ArrayList<Integer> a) {
	    ArrayList<Integer> b = new ArrayList<Integer>(a.size());
		
		int number = getNumberOfDigits(a);
		int plusOne = number + 1;
		
		String ans = String.valueOf(plusOne);
		for(int i=0; i<ans.length();i++) b.add(((int) ans.charAt(i) - 48));
		return b;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(0); a.add(0);a.add(1); a.add(2); a.add(9);
		ArrayList<Integer> b = plusOne2(a);
		
		//int sum = plusOne(a);
		System.out.println(b.toString());
	}

}
