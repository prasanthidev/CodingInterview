package com.ib.strings;

import java.util.ArrayList;
import java.util.List;

public class JustifiedText {

	public class Solution{
		public List<String> justifyText(ArrayList<String> words, int L){
			ArrayList<String> text = new ArrayList<String>();
			int startIndex = 0, endIndex = 0;
			int letterCount = 0;
			for(int i=0; i<words.size(); ){
				startIndex = i;
				letterCount = 0;				
				while(i<words.size()){									
					letterCount += words.get(i++).length(); 
					if(i == words.size() || letterCount + words.get(i).length() >= L){
						endIndex = i-1;
						break;
					}
					// Atleast one space after each word
					letterCount += 1;
				}	
				String line = "";
				// If it is last line, add only one space after each word
				if(i == words.size()){
					while(startIndex<i){
						line = line + words.get(startIndex++) + " ";
					}					
					line = line + addSpace(L - line.length());
					if(L < line.length())
						line = line.trim();
					text.add(line);
					break;
				}
				
				/**
				 *  s1 = L 
				 *  s2 = letterCount (word + space)
				 *  s3 = endIndex - startIndex (no of spaces added after each word)
				 *  totalSpaceCount = (s1 - s2) + (s3 - s4)
				 */		
				int noOfSpace = 0;
				if(startIndex <= endIndex)
					noOfSpace = endIndex - startIndex;
				int totalSpaceCount = L - letterCount + noOfSpace;
				
				/*
				while(startIndex < endIndex){
					// Calculate the spaces required between each word
					int requiredSpace = totalSpaceCount/noOfSpace + totalSpaceCount%noOfSpace;
					// Adding words starting from endIndex
					line += words[startIndex++] + addSpace(requiredSpace);
					totalSpaceCount = totalSpaceCount - requiredSpace;
					noOfSpace--;
				}
				*/
				if(noOfSpace != 0){
					int s1 = totalSpaceCount%noOfSpace;	
					int remainSpace = 0;
					int requiredSpace = totalSpaceCount/noOfSpace;
					
					while(startIndex < endIndex){
						remainSpace = 0;
						if(s1>0){
							s1 -= 1;
							remainSpace = 1;
						}
						// Calculate the spaces required between each word
						int s2 = requiredSpace + remainSpace;
						
						// Adding words starting from endIndex
						line += words.get(startIndex++) + addSpace(s2);
					}
				}
				
				
				// Add the last word now
				line += words.get(endIndex);
				if(line.length() != L)
					line = line + addSpace(L - line.length());
				text.add(line);
			}		 
			
			return text;
		}

		private String addSpace(int totalSpaceCount) {
			int i = 0;
			String space = "";
			while(i++ < totalSpaceCount){
				space += " ";				
			}
			return space;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JustifiedText obj = new JustifiedText();
		Solution sol = obj.new Solution();
		String[] words = new String[]{"a","b","c","d","e"};//{"Here", "is", "an", "example", "of", "text", "justification."};
		//System.out.println(sol.justifyText(words, 15));
	}

}
