package com.ib.strings;

public class PowerOf2 {

	private static boolean isPowerOf2(String input)
	{
		if(input == null || input.length() == 0 || Character.getNumericValue(input.charAt(0)) < -1)
		{
			return false;
		}
		
		int lengthOfString = input.length();
		while(input.length() > 1)
		{
			lengthOfString = input.length();
			int charAtLast = Character.getNumericValue(input.charAt(lengthOfString - 1));
			if(charAtLast < 0 || charAtLast%2 == 1 ){
				return false;
			}
			input = DevideNumber(input , 2);
		}
		int charAtLast = Character.getNumericValue(input.charAt(0));
		if(charAtLast < 0 || charAtLast%2 == 1 ){
			return false;
		}
		return true;
	}
	
	private static String DevideNumber(String input, int number){
		String output = "";
		int lengthOfInput = input.length();
		int charAtPos = Character.getNumericValue(input.charAt(0));
		int remainder = charAtPos % number;
		int queotient = charAtPos / number;
		if(queotient > 0){
			output = output.concat(queotient + "");
		}
		
		for(int i =1 ;i < lengthOfInput; i++){
			String x = "";
			if(remainder == 1){
				x = 1 + "" + input.charAt(i);
			}else{
				x = "" + input.charAt(i);
			}
			charAtPos = Integer.parseInt(x);
			remainder = charAtPos % number;
			queotient = charAtPos / number;
			output = output.concat(queotient + "");
		}
	    return output;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(isPowerOf2("128"));
	}
}
