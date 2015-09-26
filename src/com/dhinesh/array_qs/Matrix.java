package com.dhinesh.array_qs;

import com.google.common.base.Stopwatch;

public class Matrix {
	
	private static Stopwatch timer = Stopwatch.createUnstarted();

	public static int[][] addition(int[][] a, int[][] b) {
		timer.start();
		if(a.length != b.length) {
			throw new RuntimeException("Matrix should be same size");
		} else {
			int[][] answer = initialize(a.length, a[0].length);
			for(int i=0; i<answer.length; i++) {
				for(int j=0; j<answer[i].length; j++) {
					answer[i][j] = a[i][j] + b[i][j];
				}
			}
			timer.stop();
			System.out.println("Time:"+timer);
			timer.reset();
			return answer;
		}
	}
	
	public static int[][] multiplication(int[][] a, int[][] b) {
		timer.start();
		int[][] answer = initialize(a.length, b[0].length);
		for(int i=0; i<a.length; i++) {
			for (int j=0; j < b[i].length; j++) {
				int sum = 0;
				for(int k = 0; k < a[i].length; k++) {
					sum += a[i][k] * b[k][j];
				}
				answer[i][j] = sum;
			}
		}
		timer.stop();
		System.out.println("Time:" + timer);
		timer.reset();
		return answer;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printMatrix(addition(new int[][]{{1,2},{3,4}}, new int[][]{{5,6},{7,8}}));
		System.out.println("Multiplication");
		printMatrix(multiplication(new int[][]{{1,2},{3,4}}, new int[][]{{5,6},{7,8}}));
		
	}
	
	public static int[][] initialize(int rows, int columns) {
		int[][] matrix = new int[rows][];
		for(int i =0; i<rows; i++) {
			matrix[i] = new int[columns];
		}
		return matrix;
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i=0 ; i<matrix.length; i++) {
			for(int j=0; j<matrix[i].length; j++) {
				System.out.format("%2d",matrix[i][j]);
				if(j < matrix[i].length - 1) {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}

}
