/*
 * You are given an integer array nums.
 You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

 

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

 */
package com.dynamicprogramming;

public class JumpGame {

	public static boolean canJump(int[] nums) {

		int i = 0;
		for (int reach = 0; i < nums.length && i <= reach; i++) {
			reach = Math.max(i + nums[i], reach);
		}
		return i == nums.length;
	}

	public static void main(String[] args) {
		System.out.println(canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println();

	}

}
