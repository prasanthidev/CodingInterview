package com.ib.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class MergeIntervals {
	
	class NumberComparator implements Comparator{
		 
		
		
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			
			int number1 = (Integer) o1;
			int number2 = (Integer) o2;
					int option1 = Integer.parseInt(number1+ "" + number2 + "");
		      
		      int option2 = Integer.parseInt(number2+ "" + number1 + "");
		      
			return option2 - option1;
		}
	}
	
	public String largestNumber(final List<Integer> a) {
	    Integer[] arrayy = a.toArray(new Integer[0]);
	    
	    
	    Arrays.sort(arrayy,new NumberComparator());
	    String output = "";
	    
	    for(int i =0; i< arrayy.length; i++){
	    	output = output.concat(arrayy[i]+"");
	    }
	    
	    int outputLength = output.length();
	    char oo = output.charAt(outputLength - 1);
	    int loo = (int)oo;
	    if(Character.getNumericValue(output.charAt(0)) == 0){
	    	output = "0";
	    }
	    return output;
	}
	
	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		int num_intervals = intervals.size();
        int int_sta = -1;
        int int_end = -1;
        
        if(newInterval.start> newInterval.end){
        	int temp = newInterval.start;
        	newInterval.start = newInterval.end;
        	newInterval.end = temp;
        }
        
        for(int i =0; i< num_intervals; i++){
        	if(intervals.get(i).start <= newInterval.start){
        		int_sta = i;
        	}
        	if(intervals.get(i).end >= newInterval.end){
        		int_end = i;
        		break;
        	}
        }
        
        if(int_sta == -1){
        	intervals.add(0, newInterval);
        	if(int_end != -1){
        		if(intervals.get(int_end + 1).start < newInterval.end){
        			intervals.get(0).end = intervals.get(int_end + 1).end;
        		}
        	}
        	for(int i =1; i< num_intervals; i++){
        	    if(intervals.get(1).start <= newInterval.end){
        	    	intervals.remove(1);
        	    }
        	    else{
        	    	break;
        	    }
        	}
        	return intervals;
        }
        if(int_end == -1){
        	for(int i = int_sta +1; i< num_intervals; i++){
        		intervals.remove(int_sta+1);
        	}
        	if(intervals.get(int_sta).end < newInterval.start){
        		intervals.add(newInterval);
        		return intervals;
        	}
        	if(intervals.get(int_sta).end < newInterval.end)
        	intervals.get(int_sta).end = newInterval.end;
        	return intervals;
        }
        for(int i= int_sta + 1; i < int_end; i++){
        	intervals.remove(int_sta + 1);
        }
        int_end = int_sta+1;
        if(intervals.get(int_sta).end < newInterval.start ){
        	if(intervals.get(int_end).start > newInterval.end){
        		intervals.add(int_sta + 1, newInterval);
        	}
        	else{
        		intervals.get(int_end).start = newInterval.start;
        	}
        }
        else{
        	if(intervals.get(int_end).start > newInterval.end){
        		intervals.get(int_sta).end = newInterval.end;
        		
        	}
        	else{
        		//intervals.add(int_end - 1, newInterval);
        		intervals.get(int_sta).end = intervals.get(int_sta + 1).end;
        		intervals.remove(int_sta + 1);
        	}
        }
        return intervals;
    }

	
	
	// To generate A[C] in row R, sum up A’[C] and A’[C-1] from previous row R - 1
	public static ArrayList<ArrayList<Integer>> generate(int numOfColumns) {
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        if(numOfColumns == 0){
			return output;
		}
		
		ArrayList<Integer> columnArray = new ArrayList<Integer>();
		columnArray.add(0, 1);
		output.add(0, columnArray);
		
		for(int column = 1; column < numOfColumns; column++){
			int lastNumberOfRows = output.get( column - 1 ).size();
			columnArray = new ArrayList<Integer>();
			columnArray.add(0, 1);
			output.add(column, columnArray);
			
			int row;
			for(row = 1; row < lastNumberOfRows ; row ++ ){
				output.get(column).add(row, output.get(column - 1).get(row - 1) + output.get(column - 1).get(row));
			}
			
			output.get(column).add(row, 1);
		}
		return output;
	}
	
	public static ArrayList<Integer> wave(ArrayList<Integer> a) {
		if(a.size() <= 0){
			return a;
		}
		Collections.sort(a);
		int remainder = a.size() % 2;
		int last = -1;
		if(remainder == 1)
		{
			last = a.remove(a.size() - 1);
		}
		for(int i=0; i < a.size() - 1; i = i+2 ){
			int temp = a.get(i);
			a.set(i, a.get(i + 1));
			a.set(i + 1, temp);
		}
		if(last != -1)
		a.add(last);
		return a;
	}
	
	public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		ArrayList<Integer> numberOfpresent = new ArrayList<Integer>();
		int size = arrive.size();
		int maxDepartDay = 0;
		for(int i =0; i< size; i++){
			if(maxDepartDay < depart.get(i)){
				maxDepartDay = depart.get(i);
			}
		}
		for(int i=0; i<= maxDepartDay; i++){
			numberOfpresent.add(0);
		}
		for(int i = 0; i< size; i++){
			int arrivalDate = arrive.get(i);
			int departureDate = depart.get(i);
			for(int date = arrivalDate; date <= departureDate ; date ++ )
			{
				int presentValue = numberOfpresent.get(date);
				numberOfpresent.set(date, presentValue + 1);
			}
		}
		boolean satisfy = true;
		for(int i =0; i<= maxDepartDay; i++){
			if(numberOfpresent.get(i) > K){
				satisfy = false;
				break;
			}
		}
		return satisfy;
    }
	
	public static void main(String args[]){
				
		ArrayList<Integer> arrival = new ArrayList<Integer>();
		ArrayList<Integer> depart = new ArrayList<Integer>();
		
		arrival.add(1);
		arrival.add(2);
		arrival.add(3);
		arrival.add(4);
		
		depart.add(10);
		depart.add(2);
		depart.add(6);
		depart.add(14);
		
		boolean response = hotel(arrival, depart, 2);
		System.out.println(response);
		
		/*ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(3, 6));
		intervals.add(new Interval(8, 10));
		
		Interval newInterval = new Interval(1, 2);

		ArrayList<Interval> newIntervals = insert(intervals, newInterval);*/
		
		/*List<Integer> input = new ArrayList<Integer>();
		input.add(90);
		input.add(0);
		input.add(0);
		
		String output = new MergeIntervals().largestNumber(input);
		System.out.println(output);*/
		
		/*ArrayList<ArrayList<Integer>> result = generate(6);
		int ii = result.get(0).get(0);*/
		
		/*ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		
		ArrayList<Integer> result = wave(input);
		int i = result.get(0);*/
	}

}
