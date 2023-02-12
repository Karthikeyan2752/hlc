
package com.dynamicprogramming;

import java.util.Arrays;

public class FrogJump {
	public static int frogJump(int n, int heights[]) {

		int prev = 0, prev2 = 0, cur = 0;
		for (int i = 1; i < n; i++) {
			int fs = prev + Math.abs(heights[i] - heights[i - 1]);
			int ss = Integer.MAX_VALUE;
			if (i > 1) {
				ss = prev2 + Math.abs(heights[i] - heights[i - 2]);
			}
			cur = Math.min(fs, ss);
			prev2 = prev;
			prev = cur;
		}
		return prev;
	}

	public static int frogJumpK(int n, int heights[], int k) {

		int prev = 0, prev2 = 0, cur = 0;
		for (int i = 1; i < n; i++) {
			for (int j = 1; j < k; j++) {
				if (j >= 0) {
					int fs = prev + Math.abs(heights[i] - heights[i - j]);
					int ss = Integer.MAX_VALUE;
					if (i - j > 1) {
						ss = prev2 + Math.abs(heights[i] - heights[i - j]);
					}
					cur = Math.min(fs, ss);
					prev2 = prev;
					prev = cur;
				}
			}
		}
		return prev;
	}

	// memoization-

	public static int frogJump1(int n, int heights[]) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, -1);
		return helper(n - 1, heights, dp);
	}

	public static int helper(int n, int[] heights, int[] dp) {
		if (n == 0) {
			return 0;
		}
		if (dp[n] != -1) {
			return dp[n];
		}
		int left = helper(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
		int right = Integer.MAX_VALUE;
		if (n > 1) {
			right = helper(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
		}
		return dp[n] = Math.min(left, right);

	}
	public static void main(String[] args) {
		System.out.println();
	}

}
