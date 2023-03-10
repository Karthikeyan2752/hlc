/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [2,3,2]
Output: 3
Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 */
package com.dynamicprogramming;

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int prev = nums[1];
		int prev2 = 0;
		int n = nums.length;
		int res1 = 0;

		for (int i = 2; i < n; i++) {
			int take = nums[i];
			if (i > 1) {
				take += prev2;
			}
			int nonTake = prev;
			int curr = Math.max(take, nonTake);
			prev2 = prev;
			prev = curr;
		}
		res1 = prev;

		prev = nums[0];
		prev2 = 0;
		n = nums.length - 1;
		for (int i = 1; i < n; i++) {
			int take = nums[i];
			if (i > 1) {
				take += prev2;
			}
			int nonTake = prev;
			int curr = Math.max(take, nonTake);
			prev2 = prev;
			prev = curr;
		}
		return Math.max(prev, res1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
