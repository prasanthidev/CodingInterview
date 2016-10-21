package com.ib.arrays;

import java.util.ArrayList;

/*
 *  (x,y) to 
    (x+1, y), 
    (x - 1, y), 
    (x, y+1), 
    (x, y-1), 
    (x-1, y-1), 
    (x+1,y+1), 
    (x-1,y+1), 
    (x+1,y-1)
 */

public class CoverPoints {

	private static int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
		if(X.size() == 0 || Y.size() == 0)
			return -1;
		if(X.size() != Y.size())
			return -1;
		int numberOfSteps = 0;
		try{
			int index = 0;
			int startPointX = 0, startPointY = 0;
			int endPointX = 0, endPointY = 0;
			while(X.get(index+1) != null && index<X.size()){
				startPointX = X.get(index);
				startPointY = Y.get(index);
				endPointX = X.get(index+1);
				endPointY = Y.get(index+1);
				int x = Math.abs(startPointX - endPointX);
				int y = Math.abs(startPointY - endPointY);
				numberOfSteps += Math.max(x, y);
				index++;
			}
		} catch(Exception e){
			
		}
		return numberOfSteps;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> X = new ArrayList<Integer>();
		ArrayList<Integer> Y = new ArrayList<Integer>();
		X.add(-7); X.add(2); //X.add(3); X.add(2);
		Y.add(2); Y.add(3); //Y.add(4); Y.add(5);
		int count = coverPoints(X, Y);
		
		System.out.println(count);
	}

}
