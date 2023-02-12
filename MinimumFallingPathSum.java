/*
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.

A falling path starts at any element in the first row and chooses the element in the next row that is either directly below 
or diagonally left/right. Specifically,
 the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
 */
package com.dynamicprogramming;

import java.util.Arrays;

public class MinimumFallingPathSum {

	public int minFallingPathSum1(int[][] matrix) {
		int n = matrix.length;
		int[][] dp = new int[n][n];
		for (int j = 0; j < n; j++) {
			dp[0][j] = matrix[0][j];
		}
		return helper1(matrix, dp, n);
	}

	public int helper1(int[][] matrix, int[][] dp, int n) {
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int down = matrix[i][j] + dp[i - 1][j];
				int leftDiagnol = matrix[i][j];
				if (j - 1 >= 0) {
					leftDiagnol += dp[i - 1][j - 1];
				} else {
					leftDiagnol += (int) 1e9;
				}
				int rightDiagnol = matrix[i][j];
				if (i - 1 >= 0 && j + 1 < n) {
					rightDiagnol += dp[i - 1][j + 1];
				} else {
					rightDiagnol += (int) 1e9;
				}

				dp[i][j] = Math.min(Math.min(rightDiagnol, leftDiagnol), down);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			min = Math.min(dp[n - 1][i], min);
		}
		return min;
	}

	// recursive

	public int minFallingPathSum(int[][] matrix) {
		int n = matrix.length;
		int[][] dp = new int[n][n];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < n; j++) {
			min = Math.min(min, helper(dp, matrix, n, n - 1, j));
		}
		return min;
	}

	public static int helper(int[][] dp, int[][] matrix, int n, int i, int j) {

		if (j >= n || j < 0) {
			return (int) 1e9;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (i == 0) {
			return matrix[0][j];
		}
		int left = matrix[i][j] + helper(dp, matrix, n, i - 1, j + 1);
		int right = matrix[i][j] + helper(dp, matrix, n, i - 1, j - 1);
		int down = matrix[i][j] + helper(dp, matrix, n, i - 1, j);

		return dp[i][j] = Math.min(Math.min(right, left), down);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
