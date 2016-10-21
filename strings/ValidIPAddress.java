package com.ib.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class ValidIPAddress {

	public class Solution{
		ArrayList<String> combinations = new ArrayList<String>();
		
		public ArrayList<String> restoreIP(String input)
		{
			recurse("", input, 1);
			return combinations;
		}
				
		private Boolean isValidAddress(String a){
			int n = Integer.valueOf(a);
			return n >=0 && n<=255 && a.equals(String.valueOf(n));
		}
			
		private void recurse(String ipAddress, String remaining, int part) {
			if(part==5)
			{
				if(remaining.length() == 0)
				{
					combinations.add(ipAddress.substring(1));
				}
				
				return;
			}
			
			for(int i=1; i<=3 && i<=remaining.length(); i++)
			{
				String myPart = remaining.substring(0, i);
				if(isValidAddress(myPart))
				{
					String newRemaining = i == remaining.length() ? "" : remaining.substring(i);
					recurse(ipAddress + "." + myPart, newRemaining, part+1);
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidIPAddress obj = new ValidIPAddress();
		Solution sol = obj.new Solution();
		//2561135		
		System.out.println(Arrays.toString(sol.restoreIP("567891011").toArray()));
	}

}