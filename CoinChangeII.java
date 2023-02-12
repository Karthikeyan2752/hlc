/*
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.

You may assume that you have an infinite number of each kind of coin.

The answer is guaranteed to fit into a signed 32-bit integer.
 */
package com.dynamicprogramming;

import java.util.Arrays;

public class CoinChangeII {
	public int change(int amount, int[] coins) {
		int[][] dp = new int[coins.length][amount + 1];

		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}

		return helper(dp, coins, amount, coins.length - 1);
	}

	public int helper(int[][] dp, int[] coins, int amount, int i) {
		if (i == 0) {
			if (amount % coins[i] == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		if (dp[i][amount] != -1) {
			return dp[i][amount];
		}
		int nonTake = helper(dp, coins, amount, i - 1);
		int take = 0;
		if (coins[i] <= amount) {
			take = helper(dp, coins, amount - coins[i], i);
		}
		return dp[i][amount] = take + nonTake;
	}

	public static void main(String[] args) {

	}
}
