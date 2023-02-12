package com.dynamicprogramming;

public class JumpGameII {

	public static int jump(int[] nums) {
		// if(nums.length<2) return 0 ;
		int result = 0;
		int farthest = 0;
		int current = 0;

		for (int i = 0; i < nums.length; i++) {
			farthest = Math.max(farthest, nums[i] + i);
			if (i == current && current < farthest && current < nums.length - 1) {
				current = farthest;
				result++;
				if (current >= nums.length - 1) {
					break;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {

	}
}
