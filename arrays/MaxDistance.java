package com.ib.arrays;

import java.util.ArrayList;
import java.util.List;

public class MaxDistance {
	
	public class Sort {
		
		public Sort(){
			
		}
		
		private int sort(int[] arr, int low, int high, int[] index){
			int pivot = arr[high]; 
	        int i = (low-1); // index of smaller element
	        for (int j=low; j<=high-1; j++)
	        {
	            // If current element is smaller than or
	            // equal to pivot
	            if (arr[j] <= pivot)
	            {
	                i++;
	 
	                // swap arr[i] and arr[j]
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	                temp = index[i];
	                index[i] = index[j];
	                index[j] = temp;
	            }
	        }
	 
	        // swap arr[i+1] and arr[high] (or pivot)
	        int temp = arr[i+1];
	        arr[i+1] = arr[high];
	        arr[high] = temp;
	        temp = index[i+1];
            index[i+1] = index[high];
            index[high] = temp;
	        
	        return i+1;
		}
		void qsort(int arr[], int low, int high, int[] index){
	        if (low < high)
	        {
	            /* pi is partitioning index, arr[pi] is 
	              now at right place */
	            int pi = sort(arr, low, high, index);
	            // Recursively sort elements before
	            // partition and after partition
	            qsort(arr, low, pi-1, index);
	            qsort(arr, pi+1, high, index);
	        }
	    }
	}
	public static int maximumGap(final List<Integer> a) {
		int N = a.size();
		int[] b = new int[N];
		int index[] = new int[N];
		int indexMax[] = new int[N];
		int indexMin[] = new int[N];
		// new array
		for(int i=0; i<N; i++){
			b[i] = a.get(i);
			index[i] = i;
		}
		// sort and store the indices
		MaxDistance m = new MaxDistance();
		Sort s = m.new Sort();
		s.qsort(b, 0, b.length-1, index);
		
		// indexMax array
		int maxsum = Integer.MIN_VALUE;
		for(int i=N-1; i>=0; i--){
			maxsum = Math.max(maxsum, index[i]);
			indexMax[i] = maxsum;
		}
		// indexMin array
		int minsum = Integer.MAX_VALUE;
		for(int i=0; i<N; i++){
			minsum = Math.min(minsum, index[i]);
			indexMin[i] = minsum;
		}
		// get the max difference
		int maxGap = -1;
		for(int i=0; i<N; i++){
			int difference = indexMax[i] - indexMin[i];
			if(maxGap < difference)
				maxGap = difference;
		}
		
		return maxGap;
	}
	
	public static int maximumGap2(final List<Integer> a) {
	    ArrayList<Integer> result = new ArrayList<Integer>();
	    int startDigit = a.get(0);
	    int startIndex = 0, endIndex = -1;
	    int i=0, N=a.size();
	    for( ; i<N; i++){
	    	if(startDigit > a.get(i)){	
	    		if(startIndex != i-1 ){
	    			result.add(i-startIndex);
	    			endIndex = i-1;
	    		}
				startIndex = i;
				startDigit = a.get(i);
	    	} 
	    }
	    
	    if(startIndex == 0 && i == N)
	    	result.add(N-1);
	    if(i == N && endIndex <= startIndex && endIndex != -1)
			result.add(i-startIndex);
	    int n = result.size();
	    int maxGap = -1;
	    if(n>0){
	    	maxGap = result.get(0);
	    	for(int j=1; j<n; j++){
	    		if(maxGap < result.get(j))
	    			maxGap = result.get(j);
	    	}
	    }
	    
	    return maxGap;
	}
	
	private static void testCaseOne(){
		List<Integer> a = new ArrayList<Integer>();
		a.add(0); a.add(1);  a.add(-1); a.add(3); a.add(5); a.add(10); a.add(5); a.add(10); a.add(-6);
		int res = maximumGap(a);
		System.out.println(res);
	}
	
	private static void testCaseTwo(){
		List<Integer> a = new ArrayList<Integer>();
		a.add(20); a.add(19); a.add(10); a.add(0); a.add(-6); a.add(-12); a.add(-30);
		int res = maximumGap(a);
		System.out.println(res);
	}
	
	private static void testCaseThree(){
		List<Integer> a = new ArrayList<Integer>();
		a.add(20); a.add(21); a.add(100);
		int res = maximumGap(a);
		System.out.println(res);
	}
	
	private static void testCaseFour(){
		List<Integer> a = new ArrayList<Integer>();
		a.add(20); a.add(26); a.add(20);
		int res = maximumGap(a);
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testCaseOne();
		testCaseTwo();
		testCaseThree();
		testCaseFour();
	}

}
