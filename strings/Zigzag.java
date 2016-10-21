package com.ib.strings;

import java.util.ArrayList;

public class Zigzag {

	private static String convert(String a, int rows){
		if(rows == 0 || rows == 1 || rows >= a.length())
			return a;
		String result = "";
		int length = a.length();
		ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
		
		int n = length/(rows-1);
		if(length % (rows-1) != 0)
			n = n + 1;
		
		int index = 0; 
		for(int i=0; i<n; i++){
			matrix.add(new ArrayList<String>());
			int startIndex = 1;
			int endIndex = rows - 1;
			
			if(i % 2 == 0){
				startIndex = 0;
				endIndex = rows - 1;
				
				for(int j=startIndex; j<endIndex; j++){
					if(index >= length){
						for(int l=j; l<endIndex; l++)
							matrix.get(i).add("");
						break;
					}
						
					matrix.get(i).add(""+a.charAt(index++));
				}
				
				matrix.get(i).add("");
				
			}else{
				int current_index = index + rows-2;
				startIndex = 1;
				endIndex = rows - 1;				
				
				matrix.get(i).add("");
				
				if(current_index >= length){
					current_index = length - 1;	
					startIndex = rows - (length - index);
					for(int l=1; l<startIndex ; l++)
						matrix.get(i).add("");	
					index = current_index;
				}else{
					index = current_index + 1;
				}
				
				for(int j=startIndex; j<=endIndex; j++){
					matrix.get(i).add(""+a.charAt(current_index--));
				}				
			}
		}
		
		index = 0;
		for(int j=0; j<rows; j++){			
			for(int i=0; i<n; i++){
				if(index >= length)
					break;
				String s = matrix.get(i).get(j);
				if(s != ""){
					result += s;
					index++;
				}
			}			
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convert("PAYPALISHIRING", 5)); 
		//PHASIYIRPLIGAN
	}

}
