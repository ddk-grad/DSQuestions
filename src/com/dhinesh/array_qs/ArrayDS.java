package com.dhinesh.array_qs;

import java.util.Arrays;
import java.util.Random;

public class ArrayDS {

	static int[] rDirections = {-1,-1,-1};
	static int[] cDirections = {0,-1,1};
	public static void main(String... args) {
	//	System.out.println(Arrays.toString(uniqueElementsNlogN(new int[]{2,3,1,1,2,6,3,1,2,6,8})));
//		for(int i=0; i<20; i++) {
//			System.out.println(Arrays.toString(shuffle(new int[]{1,2,3,4,5})));
//		}
		long start = System.currentTimeMillis();
		//System.out.println("Num Solutions:" + nQueens(8));
		System.out.println(findPartitionDynamic(120));
		long stop = System.currentTimeMillis();
		System.out.println((stop - start)/(1000.0));
	}
	
	public static int[] uniqueElementsNlogN(int[] arr) {
		Arrays.sort(arr);
		int previousElement = arr[0];
		int currPosition = 1;
		for(int i=1; i<arr.length; i++) {
			if(arr[i] != previousElement) {
				arr[currPosition++] = arr[i];
				previousElement = arr[i];
			}
		}
		
		while(currPosition < arr.length) {
			arr[currPosition++] = Integer.MIN_VALUE;
		}
		return arr;
	}
	
	public static int[] shuffle(int[] arr) {
		Random random = new Random();
		for(int i=0; i<arr.length-1; i++) {
			int swapIndex = random.nextInt(arr.length-i)+i;
			int temp = arr[swapIndex];
			arr[swapIndex] = arr[i];
			arr[i] = temp;
		}
		return arr;
	}
	
	public static int nQueens(int dim) {
		int[][] board = new int[dim][];
		for(int i=0; i<dim; i++) {
			board[i] = new int[dim];
		}
		return solveNQueens(board, 0);
	}
	
	private static Integer solveNQueens(int[][] board, int row) {
		int solutions = 0;
		if(row == board.length) {
//			for(int i=0; i<board.length;i++) {
//				for(int j=0; j<board[0].length;j++) {
//					System.out.print(board[i][j]==1?'Q':'_');
//				}
//				System.out.println();
//			}
//			System.out.println("-----------------------");
			return 1;
		} else {
			for(int i=0; i<board[row].length; i++) {
				boolean conflict = false;
				outer:for(int index = 0; index<rDirections.length; index++) {
					int r = row + rDirections[index];
					int c = i + cDirections[index];
					while(r >=0 && r < board.length && c >= 0 && c < board.length) {
						if(board[r][c] == 1) {
							conflict = true;
							break outer;
						}
						r += rDirections[index];
						c += cDirections[index];
					}
				}
				if(!conflict) {
					board[row][i] = 1;
					solutions += solveNQueens(board, row+1);
					board[row][i] = 0;
				}
			}
		}
		return solutions;
	}
	
	private static int findPartition(final int n, final int m) {
		if(n <= 1) {
			return 1;
		}
		
		if (m > n) {
			return findPartition(n, n);
		}
		
		int sum = 0;
		for(int i=1; i<=m; i++) {
			sum += findPartition(n-i, i);
		}
		return sum;
	}
	
	public static int findPartition(final int n) {
		return findPartition(n,n);
	}
	
	private static int findPartitionDynamic(final int n) {
		int[][] table = new int[n+1][n+1];
		for(int i=0; i<n+1; i++) {
			table[i] = new int[n+1];
		}
		for(int i=0; i<n+1; i++) {
			table[0][i] = 0;
		}
		
		for(int i=1; i<n+1; i++) {
			int sum = 0;
			for (int j=1; j<i; j++) {
				sum += table[i-j][j];
				table[i][j] = sum;
			}
			sum++;
			for(int k= i; k<n+1; k++) {
				table[i][k] = sum;
			}
		}
		
		return table[n][n];
	}
}
