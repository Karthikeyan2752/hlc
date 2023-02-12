package com.dynamicprogramming;

public class UniquePaths {

	// Memoization

	public static int helper(int m, int n, int[][] dp) {
		if (m == 0 && n == 0) {
			return 1;
		}
		if (m < 0 || n < 0) {
			return 0;
		}
		if (dp[m][n] != 0) {
			return dp[m][n];
		}
		int left = helper(m, n - 1, dp);
		int right = helper(m - 1, n, dp);

		return dp[m][n] = left + right;
	}

	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		return helper(m - 1, n - 1, dp);
	}

	public static void main(String[] args) {

	}

}
