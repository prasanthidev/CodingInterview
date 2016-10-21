package com.ib.twopointers;

public class TODORemoveDuplicatesII {

	public static int removeDuplicates(int[] a) {
        int index = 0;
        if(a.length==2)
        	return 2;
        for(int j=0; j<a.length;){
        	if(j+1 < a.length && a[j] == a[j+1]){
        		a[index++] = a[j++];
        		a[index++] = a[j++];
        		while(j < a.length && a[j] == a[j-1]){
            		j++;
            	}
        	}if(j+1<a.length && a[j] != a[j+1])
        		a[index++]=a[j++];
        }
        return index;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(removeDuplicates(new int[]{1,1,3}));
	}

}
