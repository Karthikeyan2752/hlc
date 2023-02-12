package com.dynamicprogramming;

import java.util.Arrays;

public class KnapSackCS {
	static int knapsack(int[] weight, int[] value, int n, int maxWeight) {

		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Change in the given tree itself. No need to
		 * return or print the output. Taking input and printing output is handled
		 * automatically.
		 */
		int[][] dp = new int[n][maxWeight + 1];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return helper(dp, weight, value, n - 1, maxWeight);

	}

	static int helper(int[][] dp, int[] weight, int[] value, int i, int W) {
		if (i == 0) {
			if (weight[i] <= W) {
				return value[i];
			} else {
				return 0;
			}
		}
		if (dp[i][W] != -1) {
			return dp[i][W];
		}
		int nonTake = helper(dp, weight, value, i - 1, W);
		int take = Integer.MIN_VALUE;
		if (weight[i] <= W) {
			take = value[i] + helper(dp, weight, value, i - 1, W - weight[i]);
		}
		return dp[i][W] = Math.max(take, nonTake);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
