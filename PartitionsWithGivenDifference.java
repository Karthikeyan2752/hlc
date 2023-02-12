/*
 *You are given an integer array nums and an integer target.

You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.

For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
Return the number of different expressions that you can build, which evaluates to target.

 

Example 1:

Input: nums = [1,1,1,1,1], target = 3
Output: 5
Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
-1 + 1 + 1 + 1 + 1 = 3
+1 - 1 + 1 + 1 + 1 = 3
+1 + 1 - 1 + 1 + 1 = 3
+1 + 1 + 1 - 1 + 1 = 3
+1 + 1 + 1 + 1 - 1 = 3
AKA target sum in leetcode
 */
package com.dynamicprogramming;

import java.util.Arrays;

public class PartitionsWithGivenDifference {
	static int mod = (int) Math.pow(10, 9) + 7;

	public static int countPartitions(int n, int d, int[] arr) {
		int sum = Arrays.stream(arr).sum();
		int target = (sum - d) / 2;
		if (sum - d < 0) {
			return 0;
		}
		if ((sum - d) % 2 == 1) {
			return 0;
		}
		int[][] dp = new int[n][target + 1];
		for (int[] a : dp) {
			Arrays.fill(a, -1);
		}
		return helper(dp, n - 1, target, arr);

	}

	public static int helper(int[][] dp, int i, int target, int[] a) {
		if (i == 0) {
			if (target == 0 && a[i] == 0) {
				return 2;
			}
			if (target == a[i]) {
				return 1;
			}
			if (target == 0) {
				return 1;
			}
			return 0;
		}

		if (dp[i][target] != -1) {
			return dp[i][target];
		}
		int nonTake = helper(dp, i - 1, target, a);
		int take = 0;
		if (a[i] <= target) {
			take = helper(dp, i - 1, target - a[i], a);
		}
		return dp[i][target] = (take + nonTake) % mod;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
