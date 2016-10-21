package com.ib.arrays;

import java.util.ArrayList;

public class FindDuplicateInArray {
	public static int FindDuplicate(ArrayList<Integer> a){
		int N = a.size();
		boolean[] hash = new boolean[N];
		for(int i=0; i< N; i++){
			hash[i]= false;
		}
		for(int i=0; i<N; i++){
			int value = a.get(i);
			if(hash[value - 1] == false){
				hash[value - 1] = true;
			}
			else{
				return value;
			}
	    }
	    return 0;
	}
	public static int FindDuplicate2(ArrayList<Integer> a){
		int N = a.size();
		for(int i=0; i<N; i++){
    		int posIndex = a.get(i);
    		int posValue = a.get(posIndex-1);
    		
    		if(posIndex != posValue){
    			a.set(i, posValue);
    			a.set(posIndex-1, posIndex);
	    	}else if(posIndex-1 != i){
	    		return posIndex;
	    	}
	    }
		
	    return a.get(0);
	}
	public static int FindDuplicate3(int[] a){
		int N = a.length;
		for(int i=0; i<N; i++){
    		int posIndex = a[i];
    		int posValue = a[posIndex-1];
    		
    		if(posIndex != posValue){
    			a[posValue] = i;
    			a[posIndex-1] = posIndex;
    			
	    	}else if(posIndex-1 != i){
	    		return posIndex;
	    	}
	    }
		
	    return a[0];
	}
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		int[] a1 = new int[]{ 247, 240, 303, 9, 304, 105, 44, 204, 291, 26, 242, 2, 358, 264, 176, 289, 196, 329, 189, 102, 45, 111, 115, 339, 74, 200, 34, 201, 215, 173, 107, 141, 71, 125, 6, 241, 275, 88, 91, 58, 171, 346, 219, 238, 246, 10, 118, 163, 287, 179, 123, 348, 283, 313, 226, 324, 203, 323, 28, 251, 69, 311, 330, 316, 320, 312, 50, 157, 342, 12, 253, 180, 112, 90, 16, 288, 213, 273, 57, 243, 42, 168, 55, 144, 131, 38, 317, 194, 355, 254, 202, 351, 62, 80, 134, 321, 31, 127, 232, 67, 22, 124, 271, 231, 162, 172, 52, 228, 87, 174, 307, 36, 148, 302, 198, 24, 338, 276, 327, 150, 110, 188, 309, 354, 190, 265, 3, 108, 218, 164, 145, 285, 99, 60, 286, 103, 119, 29, 75, 212, 290, 301, 151, 17, 147, 94, 138, 272, 279, 222, 315, 116, 262, 1, 334, 41, 54, 208, 139, 332, 89, 18, 233, 268, 7, 214, 20, 46, 326, 298, 101, 47, 236, 216, 359, 161, 350, 5, 49, 122, 345, 269, 73, 76, 221, 280, 322, 149, 318, 135, 234, 82, 120, 335, 98, 274, 182, 129, 106, 248, 64, 121, 258, 113, 349, 167, 192, 356, 51, 166, 77, 297, 39, 305, 260, 14, 63, 165, 85, 224, 19, 27, 177, 344, 33, 259, 292, 100, 43, 314, 170, 97, 4, 78, 310, 61, 328, 199, 255, 159, 185, 261, 229, 11, 295, 353, 186, 325, 79, 142, 223, 211, 152, 266, 48, 347, 21, 169, 65, 140, 83, 156, 340, 56, 220, 130, 117, 143, 277, 235, 59, 205, 153, 352, 300, 114, 84, 183, 333, 230, 197, 336, 244, 195, 37, 23, 206, 86, 15, 187, 181, 308, 109, 293, 128, 66, 270, 209, 158, 32, 25, 227, 191, 35, 40, 13, 175, 146, 299, 207, 217, 281, 30, 357, 184, 133, 245, 284, 343, 53, 210, 306, 136, 132, 239, 155, 73, 193, 278, 257, 126, 331, 294, 250, 252, 263, 92, 267, 282, 72, 95, 337, 154, 319, 341, 70, 81, 68, 160, 8, 249, 96, 104, 137, 256, 93, 178, 296, 225, 237 };
		a.add(4); a.add(2); a.add(1); a.add(5); a.add(2); a.add(3);
		System.out.println(FindDuplicate(a));
	}
}
