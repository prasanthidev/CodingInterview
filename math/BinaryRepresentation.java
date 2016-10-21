package com.ib.math;

public class BinaryRepresentation {

	private static int binary(int a){
		int n = a;
		int binary = 0;
		for(int i=0; n>0; i++){
			int digit = n%2;
			binary = binary + digit * (int)Math.pow(10,i);
			n = n/2;
		}
		return binary;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binary(6));
	}

}
