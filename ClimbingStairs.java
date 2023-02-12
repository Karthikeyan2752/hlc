/*
 * You are climbing a staircase. It takes n steps to reach the top.


Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
 */
package com.dynamicprogramming;

public class ClimbingStairs {
	public int climbingStairs(int n) {
		int one = 1;
		int two = 1;
		int temp = 0;

		for (int i = 0; i < n - 1; i++) {
			temp = one;
			one += two;
			two = temp;
		}
		return one;
	}
	public int climbStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		int[] a = new int[n];
		a[0] = 1;
		a[1] = 2;
		for (int i = 2; i < n; i++) {
			a[i] = a[i - 1] + a[i - 2];
		}
		return a[n - 1];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbingStairs cs = new ClimbingStairs();
		System.out.println(cs.climbingStairs(5));
		System.out.println(cs.climbStairs(5));

	}

}
