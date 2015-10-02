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
	
	//Laplace's expansion n! running time, using LU decomposition we can do it in n^3
	public static int determinant(int[][] matrix) {
		if(matrix.length == 1) {
			return matrix[0][0];
		} else if(matrix.length == 2){
			return matrix[0][0]*matrix[1][1] - matrix[0][1]*matrix[1][0];
		} else {
			int value = 0;
			int[] sign = {1, -1};
			for(int i=0; i<matrix[0].length; i++) {
				value += sign[i%2] * matrix[0][i] *determinant(submatrix(matrix, i));
			}
			return value;
		}
	}
	
	private static int[][] submatrix(int[][] matrix, int column) {
		int[][] resultMatrix = new int[matrix.length-1][matrix.length - 1];
		for(int i=0, r=1; r < matrix.length; r++,i++) {
			for(int j=0, c=0; c < matrix[i].length; c++,j++) {
				if(c == column) {
					j--;
				} else {
					resultMatrix[i][j] = matrix[r][c];
				}
			}
		}
		return resultMatrix;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		printMatrix(addition(new int[][]{{1,2},{3,4}}, new int[][]{{5,6},{7,8}}));
//		System.out.println("Multiplication");
//		printMatrix(multiplication(new int[][]{{1,2},{3,4}}, new int[][]{{5,6},{7,8}}));
//		
		//System.out.println(determinant(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));
		printMatrix(transpose(new int[][]{{1,2,3,4},{5,6,7,8}}));
		
	}
	
	public static int[][] initialize(int rows, int columns) {
		int[][] matrix = new int[rows][];
		for(int i =0; i<rows; i++) {
			matrix[i] = new int[columns];
		}
		return matrix;
	}
	
	public static int[][] transpose(int[][] matrix) {
		int[][] resultMatrix = new int[matrix[0].length][];
		for(int c=0; c < matrix[0].length; c++) {
			resultMatrix[c] = new int[matrix.length];
			for(int r=0; r < matrix.length; r++) {
				resultMatrix[c][r] =  matrix[r][c];
			}
		}
		return resultMatrix;
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
