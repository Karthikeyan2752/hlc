/*
 * https://www.codingninjas.com/codestudio/problems/unbounded-knapsack_1215029?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1
 */
package com.dynamicprogramming;

import java.util.Arrays;

public class UnboundedKnapSack {
	public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
		int[][] dp = new int[n][w + 1];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return helper(dp, weight, profit, n - 1, w);
	}

	static int helper(int[][] dp, int[] weight, int[] value, int i, int W) {
		if (i == 0) {
			return (W / weight[i]) * value[i];
		}
		if (dp[i][W] != -1) {
			return dp[i][W];
		}
		int nonTake = helper(dp, weight, value, i - 1, W);
		int take = Integer.MIN_VALUE;
		if (weight[i] <= W) {
			take = value[i] + helper(dp, weight, value, i, W - weight[i]);
		}
		return dp[i][W] = Math.max(take, nonTake);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
