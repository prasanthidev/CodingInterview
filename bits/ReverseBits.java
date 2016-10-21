package com.ib.bits;

public class ReverseBits {

	private static long reverse(long a){
		if(a == 0 || (a/2 >= Integer.MAX_VALUE && a%2 != 0))
	        return a;
	    long result = 0;
	    int zeroCount = 0;
	    int count = 0;
	    Boolean isOneOccurred = false;
	    while(a>0){
	    	result = result << 1;
	    	if((a & 0x01) == 0 && isOneOccurred == false)
	    		zeroCount++;
	        if((a & 0x01) == 1){
	        	result = result + 1;
	        	isOneOccurred = true;
	        }
	        count++;
	        a = a >> 1;	
	    }
	    
	    result = result << ((32 - zeroCount) - (count - zeroCount));
	    
	    return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse((long) 4294967294.0));
	}

}
