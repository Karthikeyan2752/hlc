/*
 * 
 */
package com.dynamicprogramming;

import java.util.Arrays;

public class NumberOfSubSets {
	public static int findWays(int num[], int target) {
		int[][] dp = new int[num.length][target + 1];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return helper(num, dp, num.length - 1, target);
	}

	public static int helper(int[] nums, int[][] dp, int i, int target) {
		if (target == 0) {
			return 1;
		}
		if (i == 0) {
			if (target == nums[i]) {
				return 1;
			}
			return 0;
		}
		if (dp[i][target] != -1) {
			return dp[i][target];
		}
		int nonTake = helper(nums, dp, i - 1, target);
		int take = 0;
		if (nums[i] <= target) {
			take = helper(nums, dp, i - 1, target - nums[i]);
		}
		return dp[i][target] = take + nonTake;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
