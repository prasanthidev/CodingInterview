package com.ib.math;

public class ExcelColumnTitle {

	private static String convert(int n){
		String title = "";
		while(n>0){
			int val = n % 26;
			if(val == 0)
				val = 26;
			title = (char)(val + 64) + title;
			n = (n-val)/26;
		}
		return title;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert(943566));
	}

}
