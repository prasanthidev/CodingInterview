package com.ib.math;

public class ExcelColumnToInt {

	private static int convert(String a){
		int column = 0;
		a = a.toUpperCase();
		int length = a.length();
		for(int i=length-1; i>=0; i--){
			column = column + ((int)a.charAt(i) - 64) * (int)Math.pow(26, length-1-i);
		}
		return column;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("AC"));
	}

}
