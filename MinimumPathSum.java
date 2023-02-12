/*
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1  3  1  1  1 minimizes the sum.
 */
package com.dynamicprogramming;

import java.util.Arrays;

public class MinimumPathSum {

	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return helper(dp, grid, grid.length - 1, grid[0].length - 1);
	}

	public int helper(int[][] dp, int[][] grid, int i, int j) {
		if (i == 0 && j == 0) {
			return grid[0][0];
		}

		if (i < 0 || j < 0) {
			return (int) 1e9;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int up = grid[i][j] + helper(dp, grid, i - 1, j);
		int left = grid[i][j] + helper(dp, grid, i, j - 1);
		return dp[i][j] = Math.min(up, left);
	}
	public static void main(String[] args) {
		int[] a = null;
		int sum = Arrays.stream(a).sum();
	}

}
