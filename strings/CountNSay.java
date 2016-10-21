package com.ib.strings;

public class CountNSay {
	
	private static String CountAndSay(int n){
		StringBuilder sequence = new StringBuilder("1");
		for(int i=0; i<n-1; i++){
			char[] charseq = sequence.toString().toCharArray();
			char ch = charseq[0];
			int charCount = 0;
			int N = charseq.length;
			sequence.setLength(0);
			for(int j=0; j<N; j++){
				if(ch == charseq[j]){
					charCount++;
				}else{
					sequence = sequence.append((int)charCount).append((char)ch);
					ch = charseq[j];
					charCount = 1;
				}
			}
			if(charCount > 0)
				sequence = sequence.append((int)charCount).append((char)charseq[N-1]);
		}
		
		return sequence.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndSay(16);
		System.out.println();	
	}

}
