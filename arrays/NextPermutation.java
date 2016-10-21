package com.ib.arrays;

import java.util.ArrayList;

public class NextPermutation {
	
	public static ArrayList<Integer> sortArray(ArrayList<Integer> a, int start, int end){
		for(int i=start;i<end-1;i++){
			for(int j=start;j<end-1;j++){
				if(a.get(j)>a.get(j+1)){
					int temp = a.get(j);
					a.set(j, a.get(j+1));
					a.set(j+1, temp);
				}						
			}
		}
		return a;
	}
	
	public static void nextPermutation(ArrayList<Integer> a) {
		int N = a.size();
		int startdigit = 0, startIndex = 0;
		for(int i=N-1; i>0; i--){
			
			if(a.get(i)>a.get(i-1)){
				startdigit = a.get(i-1);
				startIndex = i-1;
				int swapdigit = a.get(i), swapIndex = i;
				
				for(int j=startIndex+1; j<N-1; j++){
					if(a.get(j)>a.get(j+1) && a.get(j+1)>startdigit){
						swapdigit = a.get(j+1);
						swapIndex = j+1;
					}
				}					
				
				a.set(swapIndex, startdigit);
				a.set(startIndex, swapdigit);
				startIndex++;
				break;
			}
		}
		a = sortArray(a, startIndex, N);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> a = new ArrayList<Integer>();
		//701 695 319 52
		//318, 768, 506, 59, 854, 422
		// 856, 701, 319, 695, 52
		//891, 985, 905, 824, 507 
		//a.add(891); a.add(985); a.add(905); a.add(824); a.add(507);
		//a.add(856); a.add(701);
		a.add(695); a.add(856); a.add(701); a.add(319); a.add(695); a.add(52);
		//a.add(318); a.add(768); a.add(506); a.add(59); a.add(854); a.add(422);
		//a.add(1); a.add(1); a.add(1); a.add(1);
		//a.add(1); a.add(3); a.add(41); a.add(6);
		//a.add(1); a.add(3); a.add(42); a.add(41); a.add(8);
		//a.add(42); a.add(3); a.add(41);
		System.out.println(a);
		nextPermutation(a);

		System.out.println(a);
	}

}
