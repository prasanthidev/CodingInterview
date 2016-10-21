package com.ib.arrays;

import java.util.ArrayList;

public class MergeOverlappingIntervals {

	public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		int N = intervals.size();
		boolean isRemove = false;
		if(newInterval.start > newInterval.end){
			int temp = newInterval.end;
			newInterval.end = newInterval.start;
			newInterval.start = temp;
		}
		int startDigit = newInterval.start, startIndex = 0;
		int endDigit = newInterval.end, endIndex = 0;
		
		for(int i=0; i<N; i++){
			int curStart = intervals.get(i).start;
			int curEnd = intervals.get(i).end;
			if(curStart < newInterval.start){
				if(curEnd > newInterval.start){
					startDigit = curStart;				
					startIndex = i;
					isRemove = true;
					System.out.println(isRemove);
				}
			} if(newInterval.end > curStart){
				for(int j=i; j<N; j++){
					int intervalEnd = intervals.get(j).end;
					if(intervals.get(j).start < newInterval.end && newInterval.end < intervalEnd){
						endDigit = intervalEnd;
						endIndex = j;
					}
				}
			} else {
				if(i>0 && intervals.get(i).start < newInterval.end){
					curEnd = intervals.get(i-1).end;
					if(curEnd > newInterval.end)
						endDigit = curEnd;
					else
						endDigit = newInterval.end;
					endIndex = i-1;
				}
			}
		}
		System.out.println(startIndex + ": "+ startDigit + "\t" + endIndex + ": " + endDigit);
		
		if(intervals.size()>0 && endDigit >= intervals.get(N-1).end && startDigit < intervals.get(N-1).start && !isRemove){
			intervals.removeAll(intervals);
			intervals.add(new Interval(startDigit, endDigit));
		}
		if(endIndex != 0){
			for(int i=endIndex-1 ; i>=startIndex; i--){
				intervals.remove(i);
			}
		}
		if((intervals.size()>startIndex && N!=intervals.size()) || isRemove)
			intervals.set(startIndex, new Interval(startDigit, endDigit));
		else
			intervals.add(new Interval(startDigit, endDigit));
			intervals = sort(intervals);
		
		return intervals;		
	}
	private static ArrayList<Interval> sort(ArrayList<Interval> intervals) {
		// TODO Auto-generated method stub
		int N = intervals.size();
		for(int i=0; i<N-1; i++){
			for(int j=0; j<N-1; j++){
				if(intervals.get(j).start > intervals.get(j+1).start){
					intervals = swap(intervals, j, j+1);
				}
			}
		}
		return intervals;
	}
	private static ArrayList<Interval> swap(ArrayList<Interval> intervals, int i, int j) {
		// TODO Auto-generated method stub
		int start = intervals.get(i).start;
		int end = intervals.get(i).end;
		intervals.set(i, new Interval(intervals.get(j).start, intervals.get(j).end));
		intervals.set(j, new Interval(start, end));
		return intervals;
	}
	
	private static void testCaseSeven() {
		ArrayList<Interval> intervals = new ArrayList<Interval>(); 
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(12, 16));
		Interval newInterval = new Interval(19, 9);		
		
		ArrayList<Interval> mergedIntervals = insert(intervals, newInterval);
		int N = mergedIntervals.size();
		for(int i=0; i<N; i++){
			System.out.println("[" + mergedIntervals.get(i).start + ", " + mergedIntervals.get(i).end + "]");
		}	
	}
	private static void testCaseSix() {
		ArrayList<Interval> intervals = new ArrayList<Interval>(); 
		intervals.add(new Interval(1, 5));
		intervals.add(new Interval(8, 10));
		
		Interval newInterval = new Interval(2, 4);		
		
		ArrayList<Interval> mergedIntervals = insert(intervals, newInterval);
		int N = mergedIntervals.size();
		for(int i=0; i<N; i++){
			System.out.println("[" + mergedIntervals.get(i).start + ", " + mergedIntervals.get(i).end + "]");
		}	
	}
	private static void testCaseFive() {
		ArrayList<Interval> intervals = new ArrayList<Interval>(); 
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(8, 10));
		
		Interval newInterval = new Interval(11, 12);		
		
		ArrayList<Interval> mergedIntervals = insert(intervals, newInterval);
		int N = mergedIntervals.size();
		for(int i=0; i<N; i++){
			System.out.println("[" + mergedIntervals.get(i).start + ", " + mergedIntervals.get(i).end + "]");
		}		
	}
	private static void testCaseFour() {
		ArrayList<Interval> intervals = new ArrayList<Interval>(); 
		intervals.add(new Interval(3, 5));
		intervals.add(new Interval(8, 10));
		
		Interval newInterval = new Interval(1, 12);		
		
		ArrayList<Interval> mergedIntervals = insert(intervals, newInterval);
		int N = mergedIntervals.size();
		for(int i=0; i<N; i++){
			System.out.println("[" + mergedIntervals.get(i).start + ", " + mergedIntervals.get(i).end + "]");
		}		
	}
	private static void testCaseThree() {
		ArrayList<Interval> intervals = new ArrayList<Interval>(); 
		Interval newInterval = new Interval(1, 1);		
		
		ArrayList<Interval> mergedIntervals = insert(intervals, newInterval);
		int N = mergedIntervals.size();
		for(int i=0; i<N; i++){
			System.out.println("[" + mergedIntervals.get(i).start + ", " + mergedIntervals.get(i).end + "]");
		}
		
	}
	public static void testCaseTwo(){

		ArrayList<Interval> intervals = new ArrayList<Interval>(); 
		intervals.add(new Interval(3, 6));
		intervals.add(new Interval(8, 10));
		
		Interval newInterval = new Interval(1, 2);		
		
		ArrayList<Interval> mergedIntervals = insert(intervals, newInterval);
		int N = mergedIntervals.size();
		for(int i=0; i<N; i++){
			System.out.println("[" + mergedIntervals.get(i).start + ", " + mergedIntervals.get(i).end + "]");
		}
	}
	public static void testCaseOne(){
		// (6037774, 6198243), (6726550, 7004541), (8842554, 10866536), (11027721, 11341296), (11972532, 14746848), 
		//(16374805, 16706396), (17557262, 20518214), (22139780, 22379559), (27212352, 28404611), (28921768, 29621583), 
		//(29823256, 32060921), (33950165, 36418956), (37225039, 37785557), (40087908, 41184444), (41922814, 45297414), 
		//(48142402, 48244133), (48622983, 50443163), (50898369, 55612831), (57030757, 58120901), (59772759, 59943999),
		//(61141939, 64859907), (65277782, 65296274), (67497842, 68386607), (70414085, 73339545), (73896106, 75605861),
		//(79672668, 84539434), (84821550, 86558001), (91116470, 92198054), (96147808, 98979097)
		ArrayList<Interval> intervals = new ArrayList<Interval>(); 
		
		intervals.add(new Interval(6037774, 6198243));
		intervals.add(new Interval(6726550, 7004541));
		intervals.add(new Interval(8842554, 10866536));
		intervals.add(new Interval(11027721, 11341296));
		intervals.add(new Interval(11972532, 14746848));
		intervals.add(new Interval(16374805, 16706396));
		intervals.add(new Interval(17557262, 20518214));
		intervals.add(new Interval(22139780, 22379559));
		intervals.add(new Interval(27212352, 28404611));
		intervals.add(new Interval(28921768, 29621583));
		intervals.add(new Interval(29823256, 32060921));
		intervals.add(new Interval(33950165, 36418956));
		intervals.add(new Interval(37225039, 37785557));
		intervals.add(new Interval(40087908, 41184444));
		intervals.add(new Interval(41922814, 45297414));
		intervals.add(new Interval(61141939, 64859907));
		intervals.add(new Interval(65277782, 65296274));
		
		Interval newInterval = new Interval(36210193, 61984219);		
		
		ArrayList<Interval> mergedIntervals = insert(intervals, newInterval);
		int N = mergedIntervals.size();
		for(int i=0; i<N; i++){
			System.out.println("[" + mergedIntervals.get(i).start + ", " + mergedIntervals.get(i).end + "]");
		}
	}	
	
	public static void main(String[] args) {
		testCaseOne();
		testCaseTwo();
		testCaseThree();
		testCaseFour();
		testCaseFive();
		testCaseSix();
		testCaseSeven();
	}
}
