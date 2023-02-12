/*
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

 

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
 */
package com.dynamicprogramming;

public class MinCostClimbingStairrs {

	public int minCostClimbingStairs(int[] cost) {

		int[] result = new int[cost.length + 1];
		result[cost.length - 1] = cost[cost.length - 1];
		result[cost.length] = 0;
		for (int i = cost.length - 2; i >= 0; i--) {
			result[i] = (result[i + 1] < result[i + 2]) ? result[i + 1] + cost[i] : result[i + 2] + cost[i];
		}
		return Math.min(result[0], result[1]);
	}

}
