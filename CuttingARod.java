package com.dynamicprogramming;

import java.util.Arrays;

public class CuttingARod {
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp = new int[n][n + 1];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return helper(dp, price, n, n - 1);
	}

	public static int helper(int[][] dp, int[] price, int n, int i) {
		if (i == 0) {
			return n * price[i];
		}
		int nonTake = helper(dp, price, n, i - 1);
		int take = (int) -1e9;
		int rod = i + 1;
		if (dp[i][n] != -1) {
			return dp[i][n];
		}
		if (rod <= n) {
			take = price[i] + helper(dp, price, n - rod, i);
		}
		return dp[i][n] = Math.max(take, nonTake);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
