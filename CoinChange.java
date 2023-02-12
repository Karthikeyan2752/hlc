package com.dynamicprogramming;

import java.math.BigInteger;
import java.util.Arrays;

public class CoinChange {

	// recursion
	public int coinChange1(int[] coins, int amount) {
		int[][] dp = new int[coins.length][amount + 1];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		int r = helper(dp, coins, amount, coins.length - 1);
		return r != (int) 1e9 ? r : -1;
	}

	public int helper(int[][] dp, int[] coins, int target, int i) {
		if (i == 0) {
			if (target % coins[i] == 0) {
				return target / coins[i];
			} else {
				return (int) 1e9;
			}
		}
		if (dp[i][target] != -1) {
			return dp[i][target];
		}
		int nonTake = helper(dp, coins, target, i - 1);
		int take = (int) 1e9;
		if (coins[i] <= target) {
			take = 1 + helper(dp, coins, target - coins[i], i);
		}
		return dp[i][target] = Math.min(take, nonTake);
	}

	// tabulation
	public int coinChange(int[] coins, int amount) {

		if (amount < 1) {
			return 0;
		}
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}

		return dp[amount] != amount + 1 ? dp[amount] : -1;
	}

	public static void main(String[] args) {

		int[] coins = { 9, 11, 10 };
		int amount = 10;
		// System.out.println(coinChange1(coins.length - 1, coins, amount));
		BigInteger bi = new BigInteger("101000", 2);
		System.out.println(bi);

	}

}
