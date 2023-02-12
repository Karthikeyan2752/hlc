//https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

/*
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.

 

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.
 */
//AKA House Robber in leetcode
package com.dynamicprogramming;

import java.util.List;

public class MaximumSumOfNonAdjacentElements {
	public static int maximumNonAdjacentSum(List<Integer> s) {
		int prev = s.get(0);
		int prev2 = 0;
		int n = s.size();

		for (int i = 1; i < n; i++) {
			int take = s.get(i);
			// if (i > 1) {
				take += prev2;
			// }
			int nonTake = prev;
			int curr = Math.max(take, nonTake);
			prev2 = prev;
			prev = curr;

		}
		return prev;
	}
	public static void main(String[] args) {
		List<Integer> s = List.of(2, 1, 4, 9);
		System.out.println(maximumNonAdjacentSum(s));

	}

}