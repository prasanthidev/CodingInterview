package com.ib.math;

public class GridPaths {

	public class Solution{
		
		public int findGridPaths(int x, int y, int n, int m){
			if(x==n && y == m)
				return 1;
			if(x<=n && y<=m)
				return findGridPaths(x+1, y, n, m) + findGridPaths(x, y+1, n, m);
			return 0;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GridPaths grid = new GridPaths();
		Solution sol = grid.new Solution();
		System.out.println(sol.findGridPaths(0, 0, 2, 2));
	}

}
